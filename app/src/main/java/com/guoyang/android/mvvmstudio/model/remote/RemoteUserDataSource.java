package com.guoyang.android.mvvmstudio.model.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.guoyang.android.mvvmstudio.model.Bean.User;
import com.guoyang.android.mvvmstudio.model.UserDataSource;
import com.guoyang.android.mvvmstudio.model.local.LocalUserDataSource;
import com.guoyang.android.mvvmstudio.network.RetrofitFactory;
import com.guoyang.android.mvvmstudio.network.UserApi;
import com.guoyang.android.mvvmstudio.status.Lcee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public class RemoteUserDataSource implements UserDataSource {
    private static final RemoteUserDataSource instance = new RemoteUserDataSource();

    private RemoteUserDataSource() {
    }

    public static RemoteUserDataSource getInstance() {
        return instance;
    }

    private UserApi mUserApi = RetrofitFactory.getInstance().create(UserApi.class);

    @Override
    public LiveData<Lcee<User>> queryByUsername(String username) {
        final MutableLiveData<Lcee<User>> data = new MutableLiveData<>();
        data.setValue(Lcee.<User>loading());
        mUserApi.queryUserByUsername(username)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        User user = response.body();
                        if (user == null) {
                            data.setValue(Lcee.<User>empty());
                            return;
                        }
                        data.setValue(Lcee.content(user));
                        LocalUserDataSource.getInstance().addUser(user);
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        t.printStackTrace();
                        data.setValue(Lcee.<User>error(t));
                    }
                });
        return data;
    }
}
