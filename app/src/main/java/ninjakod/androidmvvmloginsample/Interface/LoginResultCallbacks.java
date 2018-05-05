package ninjakod.androidmvvmloginsample.Interface;

public interface LoginResultCallbacks {
    void onSuccess(String message);
    void onError(String message);
}
