package com.example.acer.asartaline.persistances;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.acer.asartaline.data.vos.FoodListVO;
import com.example.acer.asartaline.data.vos.GeneralTasteVO;
import com.example.acer.asartaline.data.vos.SuitedForVO;
import com.example.acer.asartaline.persistances.daos.FoodListDao;
import com.example.acer.asartaline.persistances.daos.GeneralTasteDao;
import com.example.acer.asartaline.persistances.daos.SuitedForDao;

/**
 * Created by Acer on 7/7/2018.
 */
@Database(entities = {FoodListVO.class,
        GeneralTasteVO.class,
        SuitedForVO.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase objInstance;
    private static final String DB_NAME = "FOOD.DB";

    public abstract FoodListDao foodListDao();
    public abstract GeneralTasteDao generalTasteDao();
    public abstract SuitedForDao suitedForDao();

    public static AppDatabase getObjInstance(Context context) {
        if (objInstance==null){
            objInstance = Room.databaseBuilder(context,AppDatabase.class,DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return objInstance;
    }
}
