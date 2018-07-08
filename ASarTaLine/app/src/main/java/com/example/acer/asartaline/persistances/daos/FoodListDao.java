package com.example.acer.asartaline.persistances.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.acer.asartaline.data.vos.FoodListVO;

import java.util.List;

/**
 * Created by Acer on 7/8/2018.
 */
@Dao
public interface FoodListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertFoodList(FoodListVO... foodList);

    @Query("SELECT * FROM Food")
    LiveData<List<FoodListVO>> getAllFood();

    @Query("SELECT * FROM Food WHERE warDeeId = :warDeeId")
    FoodListVO getFoodById(String warDeeId);

    @Query("SELECT * FROM Food WHERE warDeeId = :warDeeId")
    LiveData<FoodListVO> getFoodByIdLd(String warDeeId);


}
