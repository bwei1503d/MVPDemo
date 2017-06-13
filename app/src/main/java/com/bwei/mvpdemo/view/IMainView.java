package com.bwei.mvpdemo.view;

/**
 * Created by muhanxi on 17/6/13.
 */

public interface IMainView {


    //用户名空
    public void usernameEmpty();

    //密码是空
    public void passwordEmpty();


    //登录成功
    public void loginSucuess();
    // 登录失败
    public void loginFailed();

}
