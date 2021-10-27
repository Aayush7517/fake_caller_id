package com.example.calling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

 EditText text;
 Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.txtno);
        btn = findViewById(R.id.btncall);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL);
                String number = text.getText().toString();

                if(number.trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter your Number", Toast.LENGTH_SHORT).show();
                }
                else{
                    i.setData(Uri.parse("tel:"+number));
                }

                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(MainActivity.this, "Please Grant Permission",Toast.LENGTH_SHORT);
                    requestpermission();
                }
                else{
                    startActivity(i);
                }

            }
        });
    }

    private void requestpermission(){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
    }
}