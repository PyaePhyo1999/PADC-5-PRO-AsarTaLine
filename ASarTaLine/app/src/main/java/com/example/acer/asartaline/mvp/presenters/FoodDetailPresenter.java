package com.example.acer.asartaline.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.acer.asartaline.data.models.FoodListModel;
import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.mvp.views.BaseView;
import com.example.acer.asartaline.mvp.views.FoodDetailView;

import java.util.List;

/**
 * Created by Acer on 7/7/2018.
 */

public class FoodDetailPresenter extends BasePresenter<FoodDetailView> {


    @Override
    public void initPresenter(FoodDetailView mView, Context context) {
        super.initPresenter(mView, context);


    }
    public LiveData<FoodListVO> getFoodList(String foodListId){
       return FoodListModel.getObjInstance(context).getFoodListByIdLd(foodListId);

    }

}
