package com.example.administrator.mora_game;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class Game_activity extends AppCompatActivity implements View.OnClickListener {
public Button Bt_s,Bt_p,Bt_f;
public ImageView image_player,image_robot;
public TextView life_me,life_robot,player_account;
public int robot_life=50,player_life=50;
String user_name;
int win_time=0;

MediaPlayer mediaPlayer=null;
public enum Player_attack{
    scissors,fist,palm

}
public enum Robot_attack{
    scissors2,fist2,palm2
}

    public Player_attack player_attack;
    public Robot_attack robot_attack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_activity);
        findViews();
        user_name=Login.account;
        Bt_s.setOnClickListener(this);
        Bt_f.setOnClickListener(this);
        Bt_p.setOnClickListener(this);
        player_account.setText(user_name);

    }


    @Override
    public  void onClick(View v)
    {
        Random random=new Random();
        int Robot_J=random.nextInt(3)%3+1;
        switch (Robot_J)
        {
            case 1:image_robot.setImageResource(R.drawable.fist2_);  //机器人出石头
                robot_attack=Robot_attack.fist2;
                break;
            case 2:image_robot.setImageResource(R.drawable.scissors2_); //机器人出剪刀
                robot_attack=Robot_attack.scissors2;
                break;
            case 3:image_robot.setImageResource(R.drawable.palm2_);  //机器人出布
                robot_attack=Robot_attack.palm2;
                break;

        }
        switch (v.getId())
        {
            case R.id.Bt_fist:
                image_player.setImageResource(R.drawable.fist_);
                player_attack=Player_attack.fist;
                break;
            case R.id.Bt_palm:  image_player.setImageResource(R.drawable.palm_);
                player_attack=Player_attack.palm;
                break;
            case R.id.Bt_scissorrs:  image_player.setImageResource(R.drawable.scissors_);
                player_attack=Player_attack.scissors;
                break;

        }
        if((player_attack==Player_attack.fist&&robot_attack==Robot_attack.fist2)||
        (player_attack==Player_attack.palm&&robot_attack==Robot_attack.palm2)||
        (player_attack==Player_attack.scissors&&robot_attack==Robot_attack.scissors2) )
    {
        win_time=0;
    }
        else if((player_attack==Player_attack.fist&&robot_attack==Robot_attack.scissors2)||
                (player_attack==Player_attack.palm&&robot_attack==Robot_attack.fist2)||
                (player_attack==Player_attack.scissors&&robot_attack==Robot_attack.palm2))
        {
            win_time++;
            if(win_time==3)
            {
                mediaPlayer=MediaPlayer.create(this,R.raw.win_third);
                mediaPlayer.start();
                win_time=0;

            }else if(win_time==2)
            {
                mediaPlayer=MediaPlayer.create(this,R.raw.succeed_twicce);
                mediaPlayer.start();
            }
            else{
                mediaPlayer=MediaPlayer.create(this,R.raw.succed_once);
                mediaPlayer.start();

            }
            robot_life-=10;
            player_life+=10;
            life_me.setText(String.valueOf(player_life));
            life_robot.setText(String.valueOf(robot_life));

        }
        else if((player_attack==Player_attack.fist&&robot_attack==Robot_attack.palm2)||
                (player_attack==Player_attack.palm&&robot_attack==Robot_attack.scissors2)||
                (player_attack==Player_attack.scissors&&robot_attack==Robot_attack.fist2))
        {
            mediaPlayer=MediaPlayer.create(this,R.raw.false_once);
            mediaPlayer.start();
            win_time=0;
            robot_life+=10;
            player_life-=10;
            life_me.setText(String.valueOf(player_life));
            life_robot.setText(String.valueOf(robot_life));
        }
        if(player_life==100)
        {


            Toast.makeText(Game_activity.this,"Game Over,You win",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Game_activity.this,win.class);
            startActivity(intent);
            mediaPlayer=MediaPlayer.create(this,R.raw.success);
            mediaPlayer.start();
            win_time=0;
            robot_life=50;
            player_life=50;
            life_me.setText(String.valueOf(50));
            life_robot.setText(String.valueOf(50));
        }
        else if(player_life==0)
        {
            Toast.makeText(Game_activity.this,"Game Over,You died",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Game_activity.this,lost.class);
            startActivity(intent);
            mediaPlayer=MediaPlayer.create(this,R.raw.false_);
            mediaPlayer.start();
            win_time=0;

            robot_life=50;
            player_life=50;
            life_me.setText(String.valueOf(50));
            life_robot.setText(String.valueOf(50));
        }

    }
    public void findViews()
    {
        Bt_s=(Button)findViewById(R.id.Bt_scissorrs);
        Bt_f=(Button)findViewById(R.id.Bt_fist);
        Bt_p=(Button)findViewById(R.id.Bt_palm);
        image_player=(ImageView)findViewById(R.id.imageView);
        image_robot=(ImageView)findViewById(R.id.robot);
        life_me=(TextView)findViewById(R.id.textView4);
        life_robot=(TextView)findViewById(R.id.textView2);
        player_account=(TextView)findViewById(R.id.player_account);

    }
}
