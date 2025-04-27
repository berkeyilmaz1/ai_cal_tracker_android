    package com.duzceders.aicaltracker.features.calorie_tracker.adapter;

    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import com.duzceders.aicaltracker.R;
    import com.duzceders.aicaltracker.product.models.Meal;

    import java.util.ArrayList;

    import lombok.Getter;

    public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder> {

        private ArrayList<Meal> mealList;

        public MealAdapter(ArrayList<Meal> mealList) {
            this.mealList = mealList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_card, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.mealName.setText(mealList.get(position).getMeal_name());
        }

        @Override
        public int getItemCount() {
            return mealList.size();
        }

        @Getter
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView mealName;

            public ViewHolder(View view) {
                super(view);
                mealName = (TextView) view.findViewById(R.id.mealName);

            }
        }
    }