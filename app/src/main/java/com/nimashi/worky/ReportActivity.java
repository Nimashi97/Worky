package com.nimashi.worky;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }
    @Override
    protected void onResume() {
        super.onResume();
        DatabaseHelper th = new DatabaseHelper(this);
        SQLiteDatabase db = th.getReadableDatabase();
        String sql = "SELECT _id,min,sec,date FROM workout";
        Cursor cursor = db.rawQuery(sql, null);

        //List<String> list = new ArrayList<String>();
        cursor.moveToFirst();
//        while (cursor.isAfterLast() == false) {
//            String time = cursor.getString(0);
//            String date = cursor.getString(1);
//            list.add(time + "(" + date + ")");
//            cursor.moveToNext();
//        }
        ListView listView = findViewById(R.id.report_list);
        int layout = R.layout.report;
        String[] columns = {"min","sec" ,"date", "_id"};
        int[] labels = {R.id.min,R.id.sec, R.id.date, R.id._id};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, layout, cursor, columns, labels);
        listView.setAdapter(adapter);

    }


}
