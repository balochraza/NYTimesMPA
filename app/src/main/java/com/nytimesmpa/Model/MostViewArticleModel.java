package com.nytimesmpa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MostViewArticleModel {

    @Expose
    public String url;
    @Expose
    public  String title;
    @Expose
    public  String published_date;

    @Expose
    public  String source;
    @Expose
    public  String byline;


    @Expose
    public ArrayList<Media> media;

    public class Media{
        @Expose
        public String type;


        @Expose @SerializedName("media-metadata")
        public ArrayList<Mediametadata> mediametadata;
    }
    public class Mediametadata{
        @Expose
        public String url;
    }
}
