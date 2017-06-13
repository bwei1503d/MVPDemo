package com.bwei.mvpdemo.model;

/**
 * Created by muhanxi on 17/6/13.
 */

public interface IRegisterModel {


    public void register(String username,String password,RegisterModelImpl.RegisterModelImplListener listener);

}
