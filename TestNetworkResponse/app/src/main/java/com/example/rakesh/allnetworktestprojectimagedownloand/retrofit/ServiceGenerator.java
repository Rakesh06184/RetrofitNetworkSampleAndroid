package com.example.rakesh.allnetworktestprojectimagedownloand.retrofit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class ServiceGenerator {

    public static Retrofit.Builder builder;
    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    private static Interceptor logging = interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    private static OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();

    public Retrofit.Builder apiClientBaseUrl(String url) {
        builder = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        return builder;
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
