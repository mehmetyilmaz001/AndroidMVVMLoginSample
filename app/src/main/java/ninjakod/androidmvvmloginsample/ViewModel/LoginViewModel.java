package ninjakod.androidmvvmloginsample.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import ninjakod.androidmvvmloginsample.Contract.Enums.LoginResultEnums;
import ninjakod.androidmvvmloginsample.Interface.LoginResultCallbacks;
import ninjakod.androidmvvmloginsample.Model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        this.user = new User();
    }

    public TextWatcher getUserNameTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setUser(editable.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setPassword(editable.toString());
            }
        };
    }

    public void onLoginClicked(View view){

        LoginResultEnums resultEnums = user.isValidData();

        if(resultEnums == LoginResultEnums.LoginSuccess){
            loginResultCallbacks.onSuccess("Login Success");

        }else if (resultEnums == LoginResultEnums.UserNameIsEmpty){
            loginResultCallbacks.onError("User name is empty");

        }else if(resultEnums == LoginResultEnums.UserNameIsNotInCorrectFormat){
            loginResultCallbacks.onError("User name is not in correct format");

        }else if(resultEnums == LoginResultEnums.PasswordIsEmpty){
            loginResultCallbacks.onError("Password is empty");

        }else if(resultEnums == LoginResultEnums.PasswordIsNotInCorrectFormat){
            loginResultCallbacks.onError("Password is not in correct format");

        }
    }
}
