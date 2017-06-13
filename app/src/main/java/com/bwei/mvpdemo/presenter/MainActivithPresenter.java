package com.bwei.mvpdemo.presenter;

import android.text.TextUtils;

import com.bwei.mvpdemo.model.MainActivityModelImpl;
import com.bwei.mvpdemo.view.IMainView;

/**
 * Created by muhanxi on 17/6/13.
 * 是 model 和view 通讯的桥梁
 *
 *
 */
public class MainActivithPresenter  {




    public IMainView mainView ;

    public MainActivityModelImpl mainActivityModelImpl;

    public MainActivithPresenter(IMainView mainView){

        this.mainView = mainView ;
        this.mainActivityModelImpl = new MainActivityModelImpl();

    }



    public void login(String username,String password){

        if(TextUtils.isEmpty(username)){
            //提示用户

            mainView.usernameEmpty();

            return;
        }
        if( TextUtils.isEmpty(password)){

            mainView.passwordEmpty();

            return;
        }

        mainActivityModelImpl.login(username, password, new MainActivityModelImpl.MainActivityModelListener() {
            @Override
            public void onSuccess() {

                mainView.loginSucuess();

            }

            @Override
            public void onFailed() {
                mainView.loginFailed();

            }
        });





    }


}
