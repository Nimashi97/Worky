package com.nimashi.worky;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context)
    {
        super(context,"dbworks",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlOne="CREATE TABLE workout (_id INTEGER PRIMARY KEY AUTOINCREMENT, min TEXT, sec TEXT, date DATE)";

        sqLiteDatabase.execSQL(sqlOne);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)//vertion eke movement athara wenaskam
    {

    }
}
