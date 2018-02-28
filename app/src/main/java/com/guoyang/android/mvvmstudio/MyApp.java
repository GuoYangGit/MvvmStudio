package com.guoyang.android.mvvmstudio;

import android.app.Application;

import com.guoyang.android.mvvmstudio.model.UserRepository;
import com.guoyang.android.mvvmstudio.utils.DBHelper;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBHelper.getInstance().init(this);
        UserRepository.getIntance().init(this);
    }
}
