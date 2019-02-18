package com.example.translator;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @GET("api/v1.5/tr.json/translate")
    Call<Post> getPost(@Query("key") String key,
                             @Query("text") String str,
                             @Query("lang") String language);
}
