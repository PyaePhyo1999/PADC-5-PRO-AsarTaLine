package com.example.acer.asartaline.persistances.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.acer.asartaline.data.vos.SuitedForVO;

import java.util.List;


/**
 * Created by Acer on 7/8/2018.
 */
@Dao
public interface SuitedForDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertSuitedFor (SuitedForVO... generalTaste);

    @Query("SELECT * FROM Suitedfor WHERE warDeeId = :suitedFor")
    List<SuitedForVO> getSuitedForById(String suitedFor);
}
