package com.example.retrofitusingrecyclertask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticlesModel {

    private String title;
    private String description;
    private String urlToImage;
    private String publishedAt;

    @SerializedName("source")
    @Expose
    private SourceDetails sourceDetails;

    public ArticlesModel(String title, String description, String urlToImage, String publishedAt, SourceDetails sourceDetails) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.sourceDetails = sourceDetails;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public SourceDetails getSourceDetails() {
        return sourceDetails;
    }

    public void setSourceDetails(SourceDetails sourceDetails) {
        this.sourceDetails = sourceDetails;
    }
}
