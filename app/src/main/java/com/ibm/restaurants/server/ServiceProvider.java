package com.ibm.restaurants.server;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {

    private final static String BASE_URL = "https://43ea16b4-e062-4605-99dd-cf041cf398f7.mock.pstmn.io";

    private ServiceProvider(){ }

    public static PostService createPostService(){

        HttpLoggingInterceptor loggingInterceptor = getHttpLoggingInterceptor();

        OkHttpClient okHttpClient = getOkHttpClient(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(PostService.class);
    }

    private static OkHttpClient getOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}