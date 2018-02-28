package com.guoyang.android.mvvmstudio.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.guoyang.android.mvvmstudio.model.Bean.User;
import com.guoyang.android.mvvmstudio.model.UserRepository;
import com.guoyang.android.mvvmstudio.status.Lcee;


/**
 * Created by guoyang on 2018/2/6.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */

public class UserViewModel extends ViewModel {
    private UserRepository userRepository = UserRepository.getIntance();
    private MutableLiveData<String> ldUsername;
    private LiveData<Lcee<User>> ldUser;

    public LiveData<Lcee<User>> getUser() {
        if (null == ldUser) {
            ldUsername = new MutableLiveData<>();
            ldUser = Transformations.switchMap(ldUsername, username -> userRepository.getUser(username));
        }
        return ldUser;
    }

    public void reload(String username) {
        ldUsername.setValue(username);
    }
}