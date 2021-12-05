JFLAGS = -g
JC = javac
BIN_FOLDER = bin
SRC_FOLDER = src

MAIN_FILE = com/FinalProject/Main

SRC = \
		com/FinalProject/Main.java							\
		com/FinalProject/Logger/FileLogger.java				\
		com/FinalProject/Logger/ILogger.java				\
		com/FinalProject/Pattern/IPattern.java				\
		com/FinalProject/Pattern/OneTimePattern.java		\
		com/FinalProject/PatternManager/PatternManager.java	\
		com/FinalProject/WebObject/IWebObject.java			\
		com/FinalProject/WebObject/ImageWebObject.java		\
		com/FinalProject/WebScrapper/IWebScrapper.java		\
		com/FinalProject/WebScrapper/AWebScrapper.java		\
		com/FinalProject/WebScrapper/ImgurScrapper.java

.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $(SRC)

default:
	cd $(SRC_FOLDER) && $(JC) $(JFLAGS) -d ../$(BIN_FOLDER) $(SRC)

clean:
	rm -rf $(BIN_FOLDER)

run: default
	cd $(BIN_FOLDER) && java $(MAIN_FILE)

.PHONY: default clean run