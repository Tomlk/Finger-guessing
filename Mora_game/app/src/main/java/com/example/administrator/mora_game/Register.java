package com.example.administrator.mora_game;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
    private EditText edit_account;
    private EditText edit_password;
    private Button button_register;
    private String account;
    private String password;
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account=edit_account.getText().toString();
                password=edit_password.getText().toString();
                if(account.trim().equals("")||password.trim().equals("")) //注册时输入密码或账户为空
                {
                    Toast.makeText(Register.this,"注册时账户名或密码不能为空",Toast.LENGTH_SHORT).show();;
                }
                else{
                    User user=new User();
                    user.setUsername(account);
                    user.setUserpwd(password);
                    int result=SqliteDB.getInstance(getApplicationContext()).saveUser(user);
                    if (result==-1) {
                        Toast.makeText(Register.this, "该用户名已被注册，注册失败", Toast.LENGTH_SHORT).show();
                        ;

                    }
                    else
                    {
                        if (result==1) {
                            Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                            edit_account.setText("");
                            edit_password.setText("");
                        }
                    }
                }
            }
        });


    }
    public void  findViews()
    {
        edit_account=(EditText)findViewById(R.id.register_account);
        edit_password=(EditText)findViewById(R.id.register_password);
        button_register=(Button)findViewById(R.id.register_register_bt);

    }
}
