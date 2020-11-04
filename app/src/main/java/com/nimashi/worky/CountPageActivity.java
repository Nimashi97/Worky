package com.nimashi.worky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CountPageActivity extends AppCompatActivity {

    TextView tv, v1;
    NumberPicker n1,n2;
    int x = 0;
    int s = 0;
    int m= 0;
    int tt=0;
    int tm=0;
    Handler handler;
    LinearLayout lv;

    /* @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_count_page);
         tv = findViewById(R.id.count);
        handler =new Handler()
         {
             @Override
             public void handleMessage(Message msg)
             {

                 tv.setText(""+x);
                 if(x==2)

                 {
                     Intent intent=new Intent(CountPageActivity.this,CounterActivity.class);
                     startActivity(intent);
                 }
             }
         };
     }
     public void start(View v)
     {
         Runnable r= new Runnable() {
             @Override
             public void run() {
                 for (int i=10;i>=0;i--)
                 {
                     try {
                         Thread.sleep(1000);

                         final int x=i;
                         //tv.setText(""+i);
                         Runnable r2=new Runnable() {
                             @Override
                             public void run() {
                                 tv.setText(""+x);
                             }
                         };
                         runOnUiThread(r2);
                     }
                     catch (Exception e)
                     {

                     }
                 }
             }
         };

         Thread t=new Thread(r);
        t.start();
     }*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_page);
        //lv= findViewById(R.id.activity_ex_main);
        // tv=findViewById(R.id.count);
        n1 = findViewById(R.id.count);
        n2 = findViewById(R.id.count2);
        v1 = findViewById(R.id.v1);

        //n2=findViewById(R.id.n2);
        n1.setMinValue(0);
        n1.setMaxValue(10);
        n2.setMinValue(0);
        n2.setMaxValue(60);

        //n2.setMinValue(0);
        //n2.setMaxValue(59);
       /*n1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
       {
           @Override
           public void onValueChange(NumberPicker picker, int oldVal, int newVal)
           {
               String date= new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

               DatabaseHelper th=new DatabaseHelper(CountPageActivity.this);
               SQLiteDatabase db=th.getWritableDatabase();
               String sql ="INSERT INTO workout(time,date) VALUES ('"+newVal+"','"+date+"')";
               db.execSQL(sql);
               Toast.makeText(CountPageActivity.this, "Saved Successfully!"+newVal, Toast.LENGTH_SHORT).show();
           }
       });*/


        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                n1.setValue(m);
                n2.setValue(s);
                String time = String.valueOf(s);



                //n2.setValue(s);
                //tv.setText(""+x);
                //if(x==9)


                if (m==0 && s == 0) {
                    Toast.makeText(CountPageActivity.this, "Let's move to the next one", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CountPageActivity.this, CountPageTwoActivity.class);
                    startActivity(intent);


                }
            }
        };
    }

    //    public void start(View v)
//    {
//        Runnable r= new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<10;i++)
//                {
//                    try {
//                        Thread.sleep(1000);
//
//                        final int x=i;
//                        //tv.setText(""+i);
//                        Runnable r2=new Runnable() {
//                            @Override
//                            public void run() {
//                                tv.setText(""+x);
//                            }
//                        };
//                        runOnUiThread(r2);
//                    }
//                    catch (Exception e)
//                    {
//
//                    }
//                }
//            }
//        };
//        Thread t=new Thread(r);
//        t.start();
//
//    }
    public void start(View v) {


        Runnable r = new Runnable() {
            @Override
            public void run() {
                int total=(n1.getValue()*60+n2.getValue());
                tt=n2.getValue();
                tm=n1.getValue();
                for (int i = total; i >= 0; i--) {
                    try {
                        Thread.sleep(1000);
                        m=i/60;
                        s = i % 60;


                        handler.sendEmptyMessage(0);


                    } catch (Exception e) {

                    }
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
//        String t1=String.valueOf(tt);
//        v1.setText(t1);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        DatabaseHelper th = new DatabaseHelper(CountPageActivity.this);
        SQLiteDatabase db = th.getWritableDatabase();
        String sql = "INSERT INTO workout(min,sec,date) VALUES ('" + tm + "','" + tt + "','" + date + "')";
        db.execSQL(sql);
        //Toast.makeText(CountPageActivity.this, "Saved Successfully!" + tm +tt, Toast.LENGTH_SHORT).show();
    }

}
