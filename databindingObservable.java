package com.example.shakibuzzaman.tasker.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.support.annotation.NonNull;

import com.example.shakibuzzaman.tasker.BR;

@Entity
public class ModelUserRegistration implements Observable {

    private String userName, passWord,age,gender,address;

    @Ignore
    private PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    @NonNull
    @PrimaryKey
    private String email;


    public ModelUserRegistration() {

    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        propertyChangeRegistry.notifyChange(this, BR.userName);
    }

    public void setEmail(String email) {
        this.email = email;
        propertyChangeRegistry.notifyChange(this, BR.email);
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
        propertyChangeRegistry.notifyChange(this, BR.passWord);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.remove(callback);
    }
}