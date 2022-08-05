package com.example.retrofitusingrecyclertask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArticlesModel articlesModel;
    JsonAdapter jsonAdapter;
    List<ArticlesModel> articlesModelList = new ArrayList<>();
    Retrofit retrofit;
    MyApiCall myApiCall;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit = new Retrofit.Builder().baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApiCall =retrofit.create(MyApiCall.class);

        jsonAdapter = new JsonAdapter(this,articlesModelList);
        recyclerView.setAdapter(jsonAdapter);

        loadData();

    }

    private void loadData() {

        Call<JsonResponce> call = myApiCall.getResponseList();
        call.enqueue(new Callback<JsonResponce>() {
            @Override
            public void onResponse(Call<JsonResponce> call, Response<JsonResponce> response) {
                progressDialog.dismiss();

                if(response.code()!=200)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<ArticlesModel> articlesModelList1=response.body().getArticlesModelList();

                    for(ArticlesModel articlesModel1:articlesModelList1)
                    {
                        String title1=articlesModel1.getTitle();
                        String desc=articlesModel1.getDescription();
                        String publishAt1=articlesModel1.getPublishedAt();
                        String image1=articlesModel1.getUrlToImage();
                        SourceDetails sourceDetails = new SourceDetails(articlesModel1.getSourceDetails().getName());

                      articlesModel = new ArticlesModel(title1,desc,image1,publishAt1,sourceDetails);
                      articlesModelList.add(articlesModel);
                      jsonAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponce> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}