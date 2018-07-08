package com.example.acer.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.acer.asartaline.R;
import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.mvp.presenters.FoodDetailPresenter;
import com.example.acer.asartaline.mvp.views.FoodDetailView;
import com.example.acer.asartaline.utils.AppConstant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 7/7/2018.
 */

public class FoodDetailActivity extends BaseActivity implements FoodDetailView{
    @BindView(R.id.tv_food_desc)
    TextView tvFoodDesc;
    @BindView(R.id.tv_food_title)
    TextView tvFoodTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.iv_food_detail)
    ImageView ivFoodDetail;
    private FoodDetailPresenter mPresenter;

    public static Intent newIntent(Context context,String foodListId){
        Intent intent = new Intent(context,FoodDetailActivity.class);
        intent.putExtra(AppConstant.IE_FOOD_ID,foodListId);
        return intent;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this, this);
        mPresenter = ViewModelProviders.of(this).get(FoodDetailPresenter.class);
        mPresenter.initPresenter(this,getApplicationContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        String id = getIntent().getStringExtra(AppConstant.IE_FOOD_ID);
        mPresenter.getFoodList(id).observe(this, new Observer<FoodListVO>() {
            @Override
            public void onChanged(@Nullable FoodListVO foodListVO) {
                displayDetailFood(foodListVO);
            }
        });
        mPresenter.getErrorLd().observe(this,this);




    }
    public void displayDetailFood(FoodListVO foodList){
//        tvFoodDesc.setText(foodList.getGeneralTasteVOS().get(0).getTasteDesc());
        tvFoodTitle.setText(foodList.getName());
        tvPrice.setText(foodList.getPriceRangeMin()+"-"+foodList.getPriceRangeMax());
//        Glide.with(ivFoodDetail.getContext())
//                .load(foodList.getImages().get(0))
//                .into(ivFoodDetail);
    }

    @Override
    protected void displayErrorMsg(String errorMsg) {
        Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();
    }
}
