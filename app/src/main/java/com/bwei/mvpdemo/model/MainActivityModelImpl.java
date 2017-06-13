package com.bwei.mvpdemo.model;

/**
 * Created by muhanxi on 17/6/13.
 */


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求  本地数据库 业务逻辑操作
 */
public class MainActivityModelImpl implements IMainActivityModel {


    public MainActivityModelListener listener ;

    public MainActivityModelImpl(MainActivityModelListener listener){
        this.listener = listener ;
    }


    public static String url = "http://qhb.2dyt.com/Bwei/login" ;

    // username=11111111111
    // password = 1
    // postkey = 1503d

    @Override
    public void login(String username, String password) {


        StringBuilder builder = new StringBuilder();

        builder.append(url);
        builder.append("?").append("username=").append(username).append("&").append("password=").append(password).append("&")
                .append("postkey=1503d");


        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder().url(builder.toString()).build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                listener.onFailed();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

               String result =   response.body().string() ;


                listener.onSuccess();

                // 数据持久化

            }
        });





    }

    @Override
    public void forget(String phone) {

    }


    public interface MainActivityModelListener{

        public void onSuccess();

        public void onFailed();

    }

}
