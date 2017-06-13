package com.bwei.mvpdemo.view;

/**
 * Created by muhanxi on 17/6/13.
 */

public interface IRegisterView {


    public void usernameEmpty();
    public void passwordEmpty();


    // 得到结果 数据更新

    public void onSuccess(String result);

    public void onFailed();



}
