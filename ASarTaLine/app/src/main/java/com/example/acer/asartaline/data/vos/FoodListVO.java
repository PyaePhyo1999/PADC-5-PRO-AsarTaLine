package com.example.acer.asartaline.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Acer on 7/7/2018.
 */
@Entity(tableName = "Food")
public class FoodListVO {

    @PrimaryKey(autoGenerate =true)
    private long id;

    public long getId() {
        return id;
    }

    @SerializedName("warDeeId")
    @ColumnInfo(name = "warDeeId")
    private String warDeeId;

    @ColumnInfo(name="foodName")
    private String name;

    @ColumnInfo(name="images")
    @Ignore
    private List<String> images;


    @SerializedName("generalTaste")
    @Ignore
    private List<GeneralTasteVO> generalTasteVOS;

    @SerializedName("suitedFor")
    @Ignore
    private List<SuitedForVO> suitedForVOS;

    @ColumnInfo(name="priceRangeMin")
    private int priceRangeMin;

    @ColumnInfo(name="priceRangeMax")
    private int priceRangeMax;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTasteVOS() {
        return generalTasteVOS;
    }

    public List<SuitedForVO> getSuitedForVOS() {
        return suitedForVOS;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setGeneralTasteVOS(List<GeneralTasteVO> generalTasteVOS) {
        this.generalTasteVOS = generalTasteVOS;
    }

    public void setSuitedForVOS(List<SuitedForVO> suitedForVOS) {
        this.suitedForVOS = suitedForVOS;
    }

    public void setPriceRangeMin(int priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public void setPriceRangeMax(int priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }
}
