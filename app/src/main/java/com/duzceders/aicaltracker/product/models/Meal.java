package com.duzceders.aicaltracker.product.models;

import com.duzceders.aicaltracker.product.models.enums.MealType;
import com.google.firebase.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Meal {
    private String meal_name;
    private MealType meal_type;
    private String image_url;
    private String user_note;

    private double protein_g;
    private double fat_g;
    private double carbs_g;
    private double calorie_g;

    private Timestamp meal_time;

    public Meal() {
    }

    public Meal(String meal_name, MealType meal_type, String image_url, String user_note, double protein_g, double fat_g, double carbs_g, double calorie_g, Timestamp meal_time) {
        this.meal_name = meal_name;
        this.meal_type = meal_type;
        this.image_url = image_url;
        this.user_note = user_note;
        this.protein_g = protein_g;
        this.fat_g = fat_g;
        this.carbs_g = carbs_g;
        this.calorie_g = calorie_g;
        this.meal_time = meal_time;
    }
}


