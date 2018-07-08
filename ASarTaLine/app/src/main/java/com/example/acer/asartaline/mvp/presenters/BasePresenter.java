package com.example.acer.asartaline.mvp.presenters;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.acer.asartaline.mvp.views.BaseView;

/**
 * Created by Acer on 7/7/2018.
 */

public abstract class BasePresenter<T extends BaseView> extends ViewModel {
    protected T mView;
    protected Context context;

    protected MutableLiveData<String> errorLd;

    public void initPresenter(T mView, Context context){
        this.mView = mView;
        this.context= context;
        errorLd = new MutableLiveData<>();

    }

    public MutableLiveData<String> getErrorLd() {
        return errorLd;
    }
}
