package com.guoyang.android.mvvmstudio.model;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.guoyang.android.mvvmstudio.model.Bean.User;
import com.guoyang.android.mvvmstudio.model.local.LocalUserDataSource;
import com.guoyang.android.mvvmstudio.model.remote.RemoteUserDataSource;
import com.guoyang.android.mvvmstudio.status.Lcee;
import com.guoyang.android.mvvmstudio.utils.NetworkUtils;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public class UserRepository {
    private static final UserRepository intance = new UserRepository();

    private UserRepository() {

    }

    public static UserRepository getIntance() {
        return intance;
    }

    private Context mContext;
    private UserDataSource remoteUserDataSource = RemoteUserDataSource.getInstance();
    private UserDataSource localUserDataSource = LocalUserDataSource.getInstance();

    public void init(Context context) {
        this.mContext = context;
    }

    public LiveData<Lcee<User>> getUser(String username) {
        if (NetworkUtils.isConnected(mContext)) {
            return remoteUserDataSource.queryByUsername(username);
        } else {
            return localUserDataSource.queryByUsername(username);
        }
    }
}
