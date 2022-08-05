package com.example.retrofitusingrecyclertask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponce {
    @SerializedName("articles")
    @Expose
  private List<ArticlesModel> articlesModelList;

    public List<ArticlesModel> getArticlesModelList() {
        return articlesModelList;
    }

    public void setArticlesModelList(List<ArticlesModel> articlesModelList) {
        this.articlesModelList = articlesModelList;
    }
}
