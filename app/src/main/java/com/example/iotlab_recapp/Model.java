package com.example.iotlab_recapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model {
    String title;
    String price;
    String description;
    String image;
    Map<String,Double> rating;


    public Model(String title, String price, String description, String image, Map<String, Double> rating) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Map<String, Double> getRating() {
        return rating;
    }
}
