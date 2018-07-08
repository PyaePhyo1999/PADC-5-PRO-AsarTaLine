package com.example.acer.asartaline.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.acer.asartaline.R;
import com.example.acer.asartaline.adapters.FoodCategoryAdapter;

import butterknife.BindView;

/**
 * Created by Acer on 7/7/2018.
 */

public class FoodCategoryViewHolder extends BaseViewHolder {

    @BindView(R.id.rv_food_category)
    RecyclerView rvFoodCategory;

    private FoodCategoryAdapter mFoodCategoryAdapter;

    public FoodCategoryViewHolder(View itemView) {
        super(itemView);
        mFoodCategoryAdapter = new FoodCategoryAdapter(itemView.getContext());
        LinearLayoutManager linearLayoutManagerForFoodCategory = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvFoodCategory.setAdapter(mFoodCategoryAdapter);
        rvFoodCategory.setLayoutManager(linearLayoutManagerForFoodCategory);
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void onClick(View view) {

    }
}
