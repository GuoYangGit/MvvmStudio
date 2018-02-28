package com.guoyang.android.mvvmstudio.network;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.guoyang.android.mvvmstudio.model.Bean.User;
import com.guoyang.android.mvvmstudio.model.local.UserDao;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase {
    public abstract UserDao getUserDao();
}
