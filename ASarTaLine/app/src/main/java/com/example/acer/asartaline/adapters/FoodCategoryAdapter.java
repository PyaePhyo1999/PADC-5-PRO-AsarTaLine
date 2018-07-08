package com.example.acer.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.asartaline.R;
import com.example.acer.asartaline.viewholders.ItemFoodCategoryViewHolder;

/**
 * Created by Acer on 7/6/2018.
 */

public class FoodCategoryAdapter extends BaseRecyclerAdapter {
    public FoodCategoryAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_food_category,parent,false);
        return new ItemFoodCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
