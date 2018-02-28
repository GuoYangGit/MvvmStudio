package com.guoyang.android.mvvmstudio.model.local;

import android.arch.lifecycle.LiveData;

import com.guoyang.android.mvvmstudio.model.Bean.User;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public interface UserService {
    LiveData<Long> add(User user);

    LiveData<User> queryByUsername(String username);
}
