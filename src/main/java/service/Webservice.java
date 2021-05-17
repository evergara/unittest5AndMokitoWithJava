package service;

public class Webservice {
    public boolean checkLogin(String user, String password){
        if(user.equals("admin") && password.equals("123")){
            return true;
        }
        return false;
    }
}
