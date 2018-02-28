package com.guoyang.android.mvvmstudio.network;

import com.guoyang.android.mvvmstudio.model.Bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public interface UserApi {

    @GET("/users/{username}")
    Call<User> queryUserByUsername(@Path("username") String username);
}
