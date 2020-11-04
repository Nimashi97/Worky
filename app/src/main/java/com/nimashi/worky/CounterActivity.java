package com.nimashi.worky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
    }
    public void ready(View v)
    {
        Intent intent=new Intent(CounterActivity.this,CountPageActivity.class);
        startActivity(intent);
    }

}
