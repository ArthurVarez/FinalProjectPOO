package com.FinalProject.Pattern.Factory;

import com.FinalProject.Pattern.IPattern;

public interface  AFactory<T> extends IPattern {
    public T CreateObject (String data);
}
