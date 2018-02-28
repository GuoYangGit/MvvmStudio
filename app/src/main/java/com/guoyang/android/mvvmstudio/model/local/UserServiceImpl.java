package com.guoyang.android.mvvmstudio.model.local;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.guoyang.android.mvvmstudio.model.Bean.User;
import com.guoyang.android.mvvmstudio.utils.DBHelper;

/**
 * Created by guoyang on 2018/2/7.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public class UserServiceImpl implements UserService {
    private static final UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    private UserDao mUserDao = DBHelper.getInstance().getDb().getUserDao();

    @SuppressLint("StaticFieldLeak")
    @Override
    public LiveData<Long> add(final User user) {
        final MutableLiveData<Long> data = new MutableLiveData<>();
        new AsyncTask<Void, Void, Long>() {

            @Override
            protected Long doInBackground(Void... voids) {
                return mUserDao.add(user);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                data.setValue(aLong);
            }
        }.execute();
        return data;
    }

    @Override
    public LiveData<User> queryByUsername(String username) {
        return mUserDao.queryByUsername(username);
    }
}
