package com.bwei.mvpdemo.model;

/**
 * Created by muhanxi on 17/6/13.
 */

public interface IMainActivityModel {

    //做方法的申明

    //登录
    public void login(String username,String password,MainActivityModelImpl.MainActivityModelListener listener);

    // 忘记密码
    public void forget(String phone);


}
