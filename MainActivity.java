package com.example.fake_call;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.call_recording);
       // mp.start();
        ImageView i = (ImageView)findViewById(R.id.imageView);
       i.setBackgroundResource(R.drawable.fakecall);
       i.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mp.start();
           }
       });

    }
}