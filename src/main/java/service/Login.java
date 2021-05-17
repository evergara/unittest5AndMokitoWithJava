package service;

import service.util.Callback;

public class Login {
    private Webservice webservice;

    private boolean isLogin;

    public Login(Webservice webservice) {
        this.webservice = webservice;
    }

    public boolean isLogin() {
        return isLogin;
    }
    public void doLogin(){
        webservice.login("admin", "123", new Callback() {
            @Override
            public void onSuccess(String response) {
                System.out.println(response);

                isLogin = true;
            }

            @Override
            public void onFail(String error) {
                System.out.println(error);
                isLogin = false;
            }
        });
    }
}
