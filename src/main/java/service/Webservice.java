package service;

import service.util.Callback;

public class Webservice {

    public void login(String user, String password, Callback callback){
       if (checkLogin(user,password)){
           callback.onSuccess("Usuario Correcto");
       }else {
           callback.onFail("Usuario Incorrecto");
       }
    }


    public boolean checkLogin(String user, String password){
        if(user.equals("admin") && password.equals("123")){
            return true;
        }
        return false;
    }
}
