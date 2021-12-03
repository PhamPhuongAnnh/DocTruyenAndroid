package com.example.myapplication1;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImg;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        title = findViewById(R.id.textView2);
        getData();
        setData();
    }
    String ConTent_Truyen;
    private  void getData(){
        if(getIntent().hasExtra("ConTent_Truyen")){
            ConTent_Truyen = getIntent().getStringExtra("ConTent_Truyen");
        }
        else{
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }
    private  void setData(){
        title.setText(ConTent_Truyen);
    }
}