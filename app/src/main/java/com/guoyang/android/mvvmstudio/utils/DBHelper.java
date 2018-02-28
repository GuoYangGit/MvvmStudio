package com.guoyang.android.mvvmstudio.utils;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.guoyang.android.mvvmstudio.network.DB;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public class DBHelper {
    private static final DBHelper instance = new DBHelper();
    private static final String DATABASE_NAME = "c_cache";

    private DBHelper(){

    }

    public static DBHelper getInstance(){
        return instance;
    }

    private DB db;

    public void init(Context context){
        db = Room.databaseBuilder(context.getApplicationContext(),DB.class,DATABASE_NAME).build();
    }

    public DB getDb(){
        return db;
    }
}
