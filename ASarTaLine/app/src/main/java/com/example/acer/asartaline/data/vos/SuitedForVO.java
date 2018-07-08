package com.example.acer.asartaline.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.view.LayoutInflater;

/**
 * Created by Acer on 7/7/2018.
 */
@Entity(tableName = "SuitedFor")
public class SuitedForVO {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "suitedForId")
    private String suitedForId;

    @ColumnInfo(name = "warDeeId")
    private  String warDeeId;


    @ColumnInfo(name="suitedFor")
    private String suitedFor;
    @ColumnInfo(name="suitedForDesc")
    private String suitedForDesc;

    public String getSuitedFor() {
        return suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }

    public String getSuitedForId() {
        return suitedForId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSuitedForId(String suitedForId) {
        this.suitedForId = suitedForId;
    }

    public void setSuitedFor(String suitedFor) {
        this.suitedFor = suitedFor;
    }

    public void setSuitedForDesc(String suitedForDesc) {
        this.suitedForDesc = suitedForDesc;
    }

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }
}
