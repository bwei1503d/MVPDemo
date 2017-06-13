package com.bwei.mvpdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.mvpdemo.presenter.MainActivithPresenter;
import com.bwei.mvpdemo.view.IMainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


// 处理view 的显示 隐藏  还有view 的常用事件(View交互的)

public class MainActivity extends Activity implements IMainView {

    @BindView(R.id.username)
    EditText username ;

    @BindView(R.id.password)
    EditText password;


    @BindView(R.id.btn)
    Button button ;


    MainActivithPresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        presenter = new MainActivithPresenter(this);







    }

    @OnClick(R.id.btn)
    public void loginBtn(View view){

        presenter.login(username.getText().toString(),password.getText().toString());

    }


    @OnClick(R.id.register)
    public void registerBtn(View view){

        startActivity(new Intent(this,RegisterActivity.class));


    }

    @Override
    public void usernameEmpty() {

        Toast.makeText(this, "username is empty", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void passwordEmpty() {

        Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucuess() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "loginSucuess", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void loginFailed() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "loginFailed", Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null ;


    }
}
