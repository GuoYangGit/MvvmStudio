package com.guoyang.android.mvvmstudio.model.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.guoyang.android.mvvmstudio.model.Bean.User;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long add(User user);

    @Query("select * from user where login = :username")
    LiveData<User> queryByUsername(String username);
}
