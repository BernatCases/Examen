package com.example.examen.viewmodel;

import androidx.lifecycle.MutableLiveData;

public class SecondViewModel {


    private MutableLiveData<String> emailLiveData;
    private MutableLiveData<String> passwordLiveData;

    public SecondViewModel(){
        this.emailLiveData = new MutableLiveData<>();
        this.passwordLiveData = new MutableLiveData<>();

    }

    public MutableLiveData<String> getPasswordLiveData() {
        return passwordLiveData;
    }

    public void setPasswordLiveData(MutableLiveData<String> passwordLiveData) {
        this.passwordLiveData = passwordLiveData;
    }

    public MutableLiveData<String> getEmailLiveData() {
        return emailLiveData;
    }

    public void setEmailLiveData(MutableLiveData<String> emailLiveData) {
        this.emailLiveData = emailLiveData;
    }
}
