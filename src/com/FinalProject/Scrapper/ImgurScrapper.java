package com.FinalProject.Scrapper;


import com.FinalProject.Logger.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.*;
import java.io.IOException;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class that scraps the Imgur website
 */

public class ImgurScrapper extends AWebScrapper {
    private String _data;
    public ImgurScrapper(String data, long maxCount, ILogger logger) {
        super(maxCount, logger);

        _data=data;
    }

    private int _pageCount = 0;
    private int _imageLoadedOnPage = 0;

    /**
     * todo a commenter
     */
    private JSONArray getImagePage(int page) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                        URI.create("https://api.imgur.com/3/gallery/search/time/all" + page + "?q=" + _data + "&q_type=jpg&q_type=png"))
                .header("accept", "application/json")
                .header("Authorization", "Client-ID 56dd1451c577189")
                .build();
        JSONObject response = new JSONObject(client.send(request, BodyHandlers.ofString()).body());
        return response.getJSONArray("data");
    }

    /**
     * Load the *count* next IScrapped in *list*
     * Return true if there is still IWebObject to load
     */
    public boolean load(List<String> list, long count) {
        boolean ret = !(_count >= _maxCount);
        count = updateCount(count);

        try {
            while (count > 0) {
                JSONArray data = getImagePage(_pageCount);

                for (int i = 0; i < data.length() && count > 0; ++i) {
                    JSONObject gallery = data.getJSONObject(i);
                    JSONArray imageArray = null;

                    try {
                        imageArray = gallery.getJSONArray("images");
                    }
                    catch (Exception e) {
                    }

                    if (imageArray != null) {
                        for (int j = 0; j < imageArray.length(); ++j) {
                            JSONObject image = imageArray.getJSONObject(j);
                            String url = image.getString("link");
                            if (count-- <= 0)
                                break;
                            list.add(url);
                        }
                    }
                }
                ++_pageCount;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}