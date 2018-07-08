package com.example.acer.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.acer.asartaline.R;
import com.example.acer.asartaline.adapters.FoodCategoryAdapter;
import com.example.acer.asartaline.adapters.FoodShopAdapter;
import com.example.acer.asartaline.adapters.MainAdapter;
import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.mvp.presenters.FoodListPresenter;
import com.example.acer.asartaline.mvp.views.FoodListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements FoodListView {
      @BindView(R.id.rv_main)
      RecyclerView rvMain;

    private MainAdapter mMainAdapter;
    private FoodListPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);
        mPresenter = ViewModelProviders.of(this).get(FoodListPresenter.class);
        mPresenter.initPresenter(this,getApplicationContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        mMainAdapter = new MainAdapter(getApplicationContext(),mPresenter);
        LinearLayoutManager linearLayoutManagerForFoodCategory = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvMain.setAdapter(mMainAdapter);
        rvMain.setLayoutManager(linearLayoutManagerForFoodCategory);

        mPresenter.getmFoodListLD().observe(this, new Observer<List<FoodListVO>>() {
            @Override
            public void onChanged(@Nullable List<FoodListVO> foodListVOS) {
                displayFoodList(foodListVOS);
            }
        });

        mPresenter.getErrorLd().observe(this,this);

    }
    public void displayFoodList(List<FoodListVO> foodList){
        mMainAdapter.appendNewData(foodList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void launchDetailFoodList(String foodListId) {
        Intent intent = FoodDetailActivity.newIntent(getApplicationContext(),foodListId);
        startActivity(intent);
    }

    @Override
    public void displayErrorMsg(String errorMsg) {
        Snackbar.make(rvMain, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
    }
}
