package com.nytimesmpa.Retrofit;

import com.nytimesmpa.BuildConfig;
import java.util.concurrent.TimeUnit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceFactory {

    private static Retrofit retrofit = null;

    public static WebService getClient() {
        WebService webService = null;
        if (webService == null) {
            okhttp3.OkHttpClient.Builder httpClient = new okhttp3.OkHttpClient.Builder();
            httpClient.connectTimeout(20, TimeUnit.SECONDS);
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create()).
                            baseUrl(BuildConfig.SERVER_URL).
                            client(httpClient.build()).
                            build();

             webService = retrofit.create(WebService.class);
        }
        return webService;
    }

}