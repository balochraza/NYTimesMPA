package com.nytimesmpa.Retrofit;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;

public class WebResponse<T> {
    @Nullable
    @Expose
    public  String status;
    @Nullable
    @Expose
    public T results;


}
