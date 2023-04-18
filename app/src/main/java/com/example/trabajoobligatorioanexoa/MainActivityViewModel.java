package com.example.trabajoobligatorioanexoa;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Boolean> access;
    private MutableLiveData<String> error;
    private Map<String,String> users = new HashMap<>();


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        users.put("Admin","123456");
    }

    public LiveData<Boolean> getAccess(){
        if(access == null){
            this.access = new MutableLiveData<>();
        }
        return access;
    }

    public LiveData<String> getError(){
        if(error == null){
            this.error = new MutableLiveData<>();
        }
        return error;
    }

    public void login(String username , String password){
        if(!users.containsKey(username)){
            error.setValue("Usuario no registrado");
            access.setValue(false);
        }else if(!users.get(username).equals(password)){
            error.setValue("Contraseña incorrecta");
            access.setValue(false);
        }else{
            access.setValue(true);
        }

    }
}
