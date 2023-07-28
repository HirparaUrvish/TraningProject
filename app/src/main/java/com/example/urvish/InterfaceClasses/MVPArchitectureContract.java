package com.example.urvish.InterfaceClasses;

public interface MVPArchitectureContract {

    interface View {
        void Onsuccess(String message);
        void OnError(String message);
    }

    interface Presenter{
        void dologin(String email,String password);
    }

}
