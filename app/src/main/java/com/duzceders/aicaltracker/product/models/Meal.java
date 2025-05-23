package com.duzceders.aicaltracker.product.models;

import com.duzceders.aicaltracker.product.models.enums.MealType;
import com.google.firebase.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Meal {
    private String id;
    private String meal_name;
    private String meal_type;
    private String image_url;
    private String user_note;
    private String recommendations;

    private double protein_g;
    private double fat_g;
    private double carbs_g;
    private double calorie_kcal;

    private Timestamp meal_time;


    public Meal() {
    }

    public Meal(String meal_name, String meal_type, String image_url, String user_note, double protein_g, double fat_g, double carbs_g, double calorie_kcal, Timestamp meal_time, String id, String recommendations) {
        this.meal_name = meal_name;
        this.meal_type = meal_type;
        this.image_url = image_url;
        this.user_note = user_note;
        this.protein_g = protein_g;
        this.fat_g = fat_g;
        this.carbs_g = carbs_g;
        this.calorie_kcal = calorie_kcal;
        this.meal_time = meal_time;
        this.id = id;
        this.recommendations = recommendations;
    }

}