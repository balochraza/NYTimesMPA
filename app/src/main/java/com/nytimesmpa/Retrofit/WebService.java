package com.nytimesmpa.Retrofit;

import com.nytimesmpa.Model.MostViewArticleModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {
    @GET("v2/mostviewed/all-sections/7.json?api-key=m1MISZU9Gu8fBmrGwQRpqsFDxBTTNGfL")

    Call<WebResponse<ArrayList<MostViewArticleModel>>> getMostPopularArticles();
}
