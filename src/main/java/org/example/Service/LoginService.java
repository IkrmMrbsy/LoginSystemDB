package org.example.Service;

import org.example.Database.DbAccess;
import org.example.Database.Koneksi;

public class LoginService {
    private DbAccess dbAccess;

    public LoginService(){
        this.dbAccess = new DbAccess();
    }

    public boolean register(String username, String password){
        if (dbAccess.checkUserExist(username)){
            System.out.println("Username Already Exist");
            return false;
        }

        boolean isRegister = dbAccess.saveUser(username,password);
        if (isRegister){
            System.out.println("Sukses Register");
        }else {
            System.out.println("Gagal Nama Sudah Ada");
        }
        return isRegister;
    }

    public boolean login(String username, String password){
        boolean isLogin = dbAccess.checkUser(username, password);
        if (isLogin){
            System.out.println("Berhasil Login");
            System.out.println("Hello " + username);
        }else {
            System.out.println("Gagal Login");
        }
        return isLogin;
    }

    public void close(){
        Koneksi.close();
    }
}
