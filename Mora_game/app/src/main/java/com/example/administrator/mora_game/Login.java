package com.example.administrator.mora_game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText edit_account;
    private EditText edit_password;
    private Button button_login;
    private Button button_register;
    static public String account;
    private String password;
    //private  MyDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account=edit_account.getText().toString();
                password=edit_password.getText().toString();
                if(account.trim().equals("")||password.trim().equals(""))
                {
                    Toast.makeText(Login.this,"注册时账户名或密码不能为空",Toast.LENGTH_SHORT).show();;
                }
                else
                {
                    int result=SqliteDB.getInstance(getApplicationContext()).Quer(password,account);
                    //获取保存文件中的用户名和密码
                    if(result==1)
                    {
                        Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this,Game_activity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(Login.this,"用户名或者密码错误",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

    }

    public void  findViews()
    {
        edit_account=(EditText)findViewById(R.id.input_account);
        edit_password=(EditText)findViewById(R.id.input_password);
        button_login=(Button)findViewById(R.id.Bt_login);
        button_register=(Button)findViewById(R.id.Bt_register);

    }


}
