package ninjakod.androidmvvmloginsample;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.dmoral.toasty.Toasty;
import ninjakod.androidmvvmloginsample.Interface.LoginResultCallbacks;
import ninjakod.androidmvvmloginsample.ViewModel.LoginViewModel;
import ninjakod.androidmvvmloginsample.ViewModel.LoginViewModelFactory;
import ninjakod.androidmvvmloginsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  implements LoginResultCallbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(
                ViewModelProviders.of(this,  new LoginViewModelFactory(this)).get(LoginViewModel.class)
         );
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, message).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this, message).show();
    }
}
