package com.bwei.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.mvpdemo.presenter.RegisterPresenter;
import com.bwei.mvpdemo.view.IRegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends Activity implements IRegisterView{


    @BindView(R.id.register_username)
    EditText editTextPhone;

    @BindView(R.id.register_password)
    EditText editTextPassword ;

    @BindView(R.id.register_btn)
    Button button ;

    RegisterPresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        presenter = new RegisterPresenter(this);










    }


    @OnClick(R.id.register_btn)
    public void btnClick(View view){


        presenter.register(editTextPhone.getText().toString().trim(),editTextPassword.getText().toString().trim());
    }


    @Override
    public void usernameEmpty() {

    }

    @Override
    public void passwordEmpty() {

    }

    @Override
    public void onSuccess(String result) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterActivity.this, "register success", Toast.LENGTH_SHORT).show();
            }
        });
        finish();


    }

    @Override
    public void onFailed() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterActivity.this, "register failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.iRegisterView = null;
        presenter = null ;
    }
}
