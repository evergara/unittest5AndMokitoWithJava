package service.util;

public interface Callback {
    void onSuccess(String response);
    void onFail(String error);
}
