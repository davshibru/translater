package com.example.translator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private final String apikey = "trnsl.1.1.20190216T062401Z.3a6da0c57d03dac2.01b9abd902341c1f71c49c6fddc33ce555b59325";
    private String language;
    private String transWord;
    private JsonPlaceHolder jsonPlaceHolderApi;
    private Language lang = new Language();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolder.class);

    }

    public void OnButtonClick(View v){

        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinerFrom);
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinerTo);

        String from = spinnerFrom.getSelectedItem().toString();
        String to = spinnerTo.getSelectedItem().toString();

        language = lang.makeLang(from,to);

        EditText ed = (EditText)findViewById(R.id.word);

        transWord = ed.getText().toString();

        Call<Post> call = jsonPlaceHolderApi.getPost(apikey, transWord, language);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post posts = response.body();
                String texts = posts.getText()[0];

                textViewResult.setText(texts);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
