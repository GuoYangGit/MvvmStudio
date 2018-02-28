package com.guoyang.android.mvvmstudio.model;

import android.arch.lifecycle.LiveData;

import com.guoyang.android.mvvmstudio.model.Bean.User;
import com.guoyang.android.mvvmstudio.status.Lcee;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public interface UserDataSource {
    LiveData<Lcee<User>> queryByUsername(String username);
}
