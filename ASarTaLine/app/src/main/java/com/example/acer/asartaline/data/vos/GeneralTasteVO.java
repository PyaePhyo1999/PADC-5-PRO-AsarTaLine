package com.example.acer.asartaline.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Acer on 7/7/2018.
 */
@Entity(tableName = "GeneralTaste")
public class GeneralTasteVO {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "warDeeId")
    private  String warDeeId;

    @ColumnInfo(name="tasteId")
    private String tasteId;

    @ColumnInfo(name = "taste")
    private String taste;

    @ColumnInfo(name = "tasteDesc")
    private String tasteDesc;

    public String getTasteId() {
        return tasteId;
    }

    public String getTaste() {
        return taste;
    }

    public String getTasteDesc() {
        return tasteDesc;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTasteId(String tasteId) {
        this.tasteId = tasteId;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public void setTasteDesc(String tasteDesc) {
        this.tasteDesc = tasteDesc;
    }

    public long getId() {

        return id;
    }

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }
}
