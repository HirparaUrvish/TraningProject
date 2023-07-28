package com.example.urvish.HelperClasses;

import com.example.urvish.InterfaceClasses.MVPArchitectureContract;

public class MVPArchitecturePresenter implements MVPArchitectureContract.Presenter {

    MVPArchitectureContract.View view;

    public MVPArchitecturePresenter(MVPArchitectureContract.View view) {
        this.view = view;
    }

    public void dologin(String email, String password) {

        if(email.equals("urvish@gmail.com")&&password.equals("123"))
        {
            view.Onsuccess("login Successfully");
        }else{
            view.OnError("Wrong Email & Password");
        }

    }
}
