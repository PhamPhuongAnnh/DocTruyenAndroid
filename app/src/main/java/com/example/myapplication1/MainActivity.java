package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    String s1[], s2[];
    int images[] = {R.drawable.congai, R.drawable.connit, R.drawable.contrai, R.drawable.congso,
    R.drawable.cuchai, R.drawable.cuoi18, R.drawable.dangian, R.drawable.giadinh,
    R.drawable.giaothong, R.drawable.hocsinh, R.drawable.hoctrocuoi, R.drawable.khoahoc,
    R.drawable.nghenghiep, R.drawable.nguoilon, R.drawable.nhahang,
    R.drawable.sayxin, R.drawable.tamquoc, R.drawable.tayduky, R.drawable.thegioi, R.drawable.thocacuoi,
    R.drawable.thovui, R.drawable.tieulam,R.drawable.tinhyeu,
    R.drawable.tongiao, R.drawable.trangquynh, R.drawable.truyenbua, R.drawable.vietnamvathegioi, R.drawable.voca, R.drawable.yte};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.List_truyen);
        s2 = getResources().getStringArray(R.array.decription);
        Myadapter myAdapter = new Myadapter(this, s1,s2,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}