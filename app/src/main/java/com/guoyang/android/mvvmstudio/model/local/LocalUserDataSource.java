package com.guoyang.android.mvvmstudio.model.local;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.guoyang.android.mvvmstudio.model.Bean.User;
import com.guoyang.android.mvvmstudio.model.UserDataSource;
import com.guoyang.android.mvvmstudio.status.Lcee;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public class LocalUserDataSource implements UserDataSource {
    private static final LocalUserDataSource instance = new LocalUserDataSource();

    private LocalUserDataSource() {

    }

    public static LocalUserDataSource getInstance() {
        return instance;
    }

    private UserService mUserService = UserServiceImpl.getInstance();

    @Override
    public LiveData<Lcee<User>> queryByUsername(String username) {
        final MediatorLiveData<Lcee<User>> data = new MediatorLiveData<>();
        data.setValue(Lcee.<User>loading());
        data.addSource(mUserService.queryByUsername(username), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    data.setValue(Lcee.content(user));
                } else {
                    data.setValue(Lcee.<User>empty());
                }
            }
        });
        return data;
    }

    public LiveData<Long> addUser(User user) {
        return mUserService.add(user);
    }
}
