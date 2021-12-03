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
        mainImg = findViewById(R.id.imageView);
        title = findViewById(R.id.textView2);
        getData();
        setData();
    }
    String data1;
    int myimg;
    private  void getData(){
        if(getIntent().hasExtra("myimg")&& getIntent().hasExtra("data1")){
            data1 = getIntent().getStringExtra("data1");
            myimg = getIntent().getIntExtra("myimg", 1);
        }
        else{
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }
    private  void setData(){
        title.setText(data1);
        mainImg.setImageResource(myimg);
    }
}