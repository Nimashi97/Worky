package com.nimashi.worky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_main);
    }
    public void day1(View v)
    {
        Intent intent =new Intent(ExMainActivity.this,CounterActivity.class);
        startActivity(intent);
    }
    public void exercise(View v)
    {
        Intent intent =new Intent(ExMainActivity.this,ExMainActivity.class);
        startActivity(intent);
    }
    public void report(View v)
    {
        Intent intent =new Intent(ExMainActivity.this,ReportActivity.class);
        startActivity(intent);
    }
}
