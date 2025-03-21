package com.duzceders.aicaltracker.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.duzceders.aicaltracker.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class CalorieTracker extends AppCompatActivity {

    private NutritionData nutritionData;


    private TextView totalCaloriesValue;
    private TextView totalProteinValue;
    private TextView totalCarbsValue;
    private TextView totalFatsValue;

    private CircularProgressIndicator circularProgressCalories;
    private CircularProgressIndicator circularProgressProtein;
    private CircularProgressIndicator circularProgressCarbs;
    private CircularProgressIndicator circularProgressFats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_tracker);

        initializeViews();


        loadSampleData();

        updateUI();

        setClickListeners();
    }

    private void initializeViews() {

        totalCaloriesValue = findViewById(R.id.totalCaloriesValue);
        totalProteinValue = findViewById(R.id.totalProteinValue);
        totalCarbsValue = findViewById(R.id.totalCarbsValue);
        totalFatsValue = findViewById(R.id.totalFatsValue);


        circularProgressCalories = findViewById(R.id.circularProgressCalories);
        circularProgressProtein = findViewById(R.id.circularProgressProtein);
        circularProgressCarbs = findViewById(R.id.circularProgressCarbs);
        circularProgressFats = findViewById(R.id.circularProgressFats);
    }

    private void loadSampleData() {
        int targetCalories = 3000;
        int targetProtein = 300;
        int targetCarbs = 300;
        int targetFats = 80;


        int consumedCalories = 613;
        int consumedProtein = 37;
        int consumedCarbs = 110;
        int consumedFats = 28;


        nutritionData = new NutritionData(
                targetCalories, targetProtein, targetCarbs, targetFats,
                consumedCalories, consumedProtein, consumedCarbs, consumedFats
        );
    }

    @SuppressLint("SetTextI18n")
    private void updateUI() {

        totalCaloriesValue.setText(String.valueOf(nutritionData.getRemainingCalories()));
        totalProteinValue.setText(nutritionData.getRemainingProtein() + "g");
        totalCarbsValue.setText(nutritionData.getRemainingCarbs() + "g");
        totalFatsValue.setText(nutritionData.getRemainingFats() + "g");

        int caloriesProgress = calculateProgress(nutritionData.getConsumedCalories(), nutritionData.getTargetCalories());
        int proteinProgress = calculateProgress(nutritionData.getConsumedProtein(), nutritionData.getTargetProtein());
        int carbsProgress = calculateProgress(nutritionData.getConsumedCarbs(), nutritionData.getTargetCarbs());
        int fatsProgress = calculateProgress(nutritionData.getConsumedFats(), nutritionData.getTargetFats());

        circularProgressCalories.setProgress(caloriesProgress);
        circularProgressProtein.setProgress(proteinProgress);
        circularProgressCarbs.setProgress(carbsProgress);
        circularProgressFats.setProgress(fatsProgress);
    }

    private int calculateProgress(int consumed, int target) {
        return (int)(((float)consumed / target) * 100);
    }

    private void setClickListeners() {

        findViewById(R.id.fabAddFood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private static class NutritionData {
        private final int targetCalories;
        private final int targetProtein;
        private final int targetCarbs;
        private final int targetFats;

        private final int  consumedCalories;
        private final int consumedProtein;
        private final int consumedCarbs;
        private final int consumedFats;

        public NutritionData(int targetCalories, int targetProtein, int targetCarbs, int targetFats,
                             int consumedCalories, int consumedProtein, int consumedCarbs, int consumedFats) {
            this.targetCalories = targetCalories;
            this.targetProtein = targetProtein;
            this.targetCarbs = targetCarbs;
            this.targetFats = targetFats;

            this.consumedCalories = consumedCalories;
            this.consumedProtein = consumedProtein;
            this.consumedCarbs = consumedCarbs;
            this.consumedFats = consumedFats;
        }

        public int getTargetCalories() { return targetCalories; }
        public int getTargetProtein() { return targetProtein; }
        public int getTargetCarbs() { return targetCarbs; }
        public int getTargetFats() { return targetFats; }

        public int getConsumedCalories() { return consumedCalories; }
        public int getConsumedProtein() { return consumedProtein; }
        public int getConsumedCarbs() { return consumedCarbs; }
        public int getConsumedFats() { return consumedFats; }

        public int getRemainingCalories() { return targetCalories - consumedCalories; }
        public int getRemainingProtein() { return targetProtein - consumedProtein; }
        public int getRemainingCarbs() { return targetCarbs - consumedCarbs; }
        public int getRemainingFats() { return targetFats - consumedFats; }
    }
}