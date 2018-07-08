package com.example.acer.asartaline.persistances.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.acer.asartaline.data.vos.GeneralTasteVO;

import java.util.List;

/**
 * Created by Acer on 7/8/2018.
 */

@Dao
public interface GeneralTasteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertGeneralTaste (GeneralTasteVO... generalTaste);

    @Query("SELECT * FROM GeneralTaste WHERE warDeeId = :tasteId")
    List<GeneralTasteVO> getTasteById(String tasteId);
}
