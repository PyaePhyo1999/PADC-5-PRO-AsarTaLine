package com.example.acer.asartaline.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.data.vos.GeneralTasteVO;
import com.example.acer.asartaline.data.vos.SuitedForVO;
import com.example.acer.asartaline.network.FoodListApi;
import com.example.acer.asartaline.network.GetFoodListResponse;
import com.example.acer.asartaline.utils.AppConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Acer on 7/7/2018.
 */

public class FoodListModel extends BaseModel {
    private static FoodListModel objInstance;
    private Map<String,FoodListVO> mFood;
    private MutableLiveData<FoodListVO> foodListLd;

    protected FoodListModel(Context context) {
        super(context);
        mFood = new HashMap<>();
    }

    public static FoodListModel getObjInstance(Context context) {
        if (objInstance == null){
            objInstance = new FoodListModel(context);
        }
        return objInstance;
    }
    public FoodListVO getFoodListId(String foodListId){
        return mFood.get(foodListId);
    }

    public void startLoadingFoodList(final MutableLiveData<List<FoodListVO>> mFoodList, final MutableLiveData<String> errorLd){
        mTheApi.loadFoodList(AppConstant.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetFoodListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetFoodListResponse getFoodListResponse) {
                        if (getFoodListResponse != null && getFoodListResponse.getFoodList().size()>0 ){
                                 persistFoodList(getFoodListResponse.getFoodList());
                                 mFoodList.setValue(getFoodListResponse.getFoodList());
                                 for (FoodListVO foodList : getFoodListResponse.getFoodList()){
                                     mFood.put(foodList.getWarDeeId(),foodList);
                                 }

                        }
                        else {
                            errorLd.setValue("No data could be loaded");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLd.setValue(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void persistFoodList(List<FoodListVO> foodList){
        List<FoodListVO> mfootList = new ArrayList<>();
        List<GeneralTasteVO> generalTaste = new ArrayList<>();
        List<SuitedForVO> suitedFor = new ArrayList<>();

        for (FoodListVO foodListVO : foodList) {
            for (GeneralTasteVO generalTasteVO : foodListVO.getGeneralTasteVOS()) {
                generalTasteVO.setWarDeeId(foodListVO.getWarDeeId());
                generalTaste.add(generalTasteVO);
            }
            for (SuitedForVO suitedForVO : foodListVO.getSuitedForVOS()){
                suitedForVO.setWarDeeId(foodListVO.getWarDeeId());
                suitedFor.add(suitedForVO);
            }
            mfootList.add(foodListVO);
        }
        mDateBase.clearAllTables();
        long [] insertGeneralTaste = mDateBase.generalTasteDao().insertGeneralTaste(generalTaste.toArray(new GeneralTasteVO[0]));
        Log.d(AppConstant.LOG_TAG,"insertedGeneralTaste : "+ insertGeneralTaste);

        long [] insertSuitedFor = mDateBase.suitedForDao().insertSuitedFor(suitedFor.toArray(new SuitedForVO[0]));
        Log.d(AppConstant.LOG_TAG,"insertedSuitedFor : "+ insertSuitedFor);

        long [] insertFoodList = mDateBase.foodListDao().insertFoodList(foodList.toArray(new FoodListVO[0]));
        Log.d(AppConstant.LOG_TAG,"insertedFoodList : "+ insertFoodList);

    }

    public LiveData<List<FoodListVO>> getAllWarDee() {
        return mDateBase.foodListDao().getAllFood();
    }

    public LiveData<FoodListVO> getFoodListByIdLd(final String foodListId){
       foodListLd = new MutableLiveData<>();
        mDateBase.foodListDao().getFoodByIdLd(foodListId).observeForever(new android.arch.lifecycle.Observer<FoodListVO>() {
            @Override
            public void onChanged(@Nullable FoodListVO foodList) {
                foodList = mDateBase.foodListDao().getFoodById(foodListId);
                foodList.setGeneralTasteVOS(mDateBase.generalTasteDao().getTasteById(foodListId));
                for (GeneralTasteVO generalTasteVO : foodList.getGeneralTasteVOS()) {

                }
                foodList.setSuitedForVOS(mDateBase.suitedForDao().getSuitedForById(foodListId));
                for (SuitedForVO suitedForVO : foodList.getSuitedForVOS()){

                }

                foodListLd.setValue(foodList);
            }

        });
        return foodListLd;
    }


}
