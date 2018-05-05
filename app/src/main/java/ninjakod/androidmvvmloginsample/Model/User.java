package ninjakod.androidmvvmloginsample.Model;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

import ninjakod.androidmvvmloginsample.Contract.Enums.LoginResultEnums;

public class User extends BaseObservable{
    @NonNull
    private String user,password;


    public User() {
    }

    public User(@NonNull String user, @NonNull String password) {
        this.user = user;
        this.password = password;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    public void setUser(@NonNull String user) {
        this.user = user;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }


    public LoginResultEnums isValidData(){

        if(TextUtils.isEmpty(getUser())){
            return LoginResultEnums.UserNameIsEmpty;

        }else if(!Patterns.EMAIL_ADDRESS.matcher(getUser()).matches()){
            return LoginResultEnums.UserNameIsNotInCorrectFormat;

        }else if(TextUtils.isEmpty(getPassword())){
            return LoginResultEnums.PasswordIsEmpty;

        }else if(getPassword().length() < 6){
            return LoginResultEnums.PasswordIsNotInCorrectFormat;

        }else{
            return LoginResultEnums.LoginSuccess;

        }

    }
}
