package com.dya.hanbanborina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {


    ImageView imageIcon;
    Animation fromTop ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageIcon =findViewById(R.id.imageIcon);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.frometope);

        imageIcon.setAnimation(fromTop);

        Thread splashThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        splashThread.start();

    }
}