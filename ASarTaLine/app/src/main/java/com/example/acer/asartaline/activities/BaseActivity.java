package com.example.acer.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by aung on 12/2/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements Observer<String> {

    @Override
    public void onChanged(@Nullable String s) {
        displayErrorMsg(s);
    }

    protected void displayErrorMsg(String errorMsg){

    }



}
