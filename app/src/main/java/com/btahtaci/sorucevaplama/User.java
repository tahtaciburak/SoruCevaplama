package com.btahtaci.sorucevaplama;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by buraktahtaci on 2.04.2018.
 */

public class User implements Serializable {

    private String username;
    private String password;

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public User(){

    }
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }


    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
