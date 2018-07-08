package com.example.acer.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.asartaline.R;
import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.delegates.FoodDelegate;
import com.example.acer.asartaline.viewholders.ItemFoodViewHolder;

/**
 * Created by Acer on 7/7/2018.
 */

public class MainAdapter extends BaseRecyclerAdapter<ItemFoodViewHolder,FoodListVO> {
    private FoodDelegate mDelegate;
    public MainAdapter(Context context,FoodDelegate mDelegate) {
        super(context);
        this.mDelegate =mDelegate;
    }

    @NonNull
    @Override
    public ItemFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_food_shop,parent,false);
        return new ItemFoodViewHolder(view,mDelegate);
    }


//    private static final int FOOD_CATEGORY = 0;
//    private static final int FOOD_SHOP = 1;





}
