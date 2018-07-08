package com.example.acer.asartaline.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.acer.asartaline.data.models.FoodListModel;
import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.delegates.FoodDelegate;
import com.example.acer.asartaline.mvp.views.FoodListView;

import java.io.LineNumberInputStream;
import java.util.List;

/**
 * Created by Acer on 7/7/2018.
 */

public class FoodListPresenter extends BasePresenter<FoodListView> implements FoodDelegate{
    private MutableLiveData<List<FoodListVO>> mFoodListLD;
    private MutableLiveData<String> mErrorLd;

    @Override
    public void initPresenter(FoodListView mView, Context context) {
        super.initPresenter(mView,context);
        mFoodListLD = new MutableLiveData<>();
        mErrorLd = new MutableLiveData<>();
        FoodListModel.getObjInstance(context).startLoadingFoodList(mFoodListLD,mErrorLd);
    }

    public LiveData<List<FoodListVO>> getmFoodListLD() {
       return mFoodListLD;
    }


    @Override
    public void onTapFoodList(FoodListVO foodList) {
        mView.launchDetailFoodList(foodList.getWarDeeId());
    }
}
