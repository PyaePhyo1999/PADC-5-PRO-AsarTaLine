package com.example.acer.asartaline.viewholders;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.example.acer.asartaline.R;
import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.delegates.FoodDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 7/6/2018.
 */

public class ItemFoodViewHolder extends BaseViewHolder<FoodListVO> {
    private FoodDelegate mDelegate;
    @BindView(R.id.tv_shop_name)
    TextView tvName;

    @BindView(R.id.iv_food_image)
    ImageView ivFoodImage;

    @BindView(R.id.tv_taste)
    TextView tvTaste;

    @BindView(R.id.tv_cash)
    TextView tvCash;
    private FoodListVO mFoodList;

    public ItemFoodViewHolder(View itemView, FoodDelegate foodDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = foodDelegate;
    }

    @Override
    public void setData(FoodListVO data) {
        mFoodList = data;
        tvName.setText(data.getName());
        tvTaste.setText(data.getGeneralTasteVOS().get(0).getTaste());
        tvCash.setText(data.getPriceRangeMin() + "-" + data.getPriceRangeMax());
        Glide.with(ivFoodImage.getContext())
                .load(data.getImages().get(0))
                .into(ivFoodImage);
    }

    @Override
    public void onClick(View view) {
        mDelegate.onTapFoodList(mFoodList);
    }
}
