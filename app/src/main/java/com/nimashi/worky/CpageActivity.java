package com.nimashi.worky;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class CpageActivity extends AppCompatActivity {

    TextView tv;
    //NumberPicker n1,n2;
    Handler handler;
    int x=0;
   // int m=0;
    //int s=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv=findViewById(R.id.count);
        //n1=findViewById(R.id.n1);
        //n2=findViewById(R.id.n2);

        handler =new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                //n1.setValue(m);
                //n2.setValue(s);
                tv.setText(""+x);
                if(x==9)
                //if(m==0 && s==0)
                {
                    Intent intent=new Intent(CpageActivity.this,CounterActivity.class);
                    startActivity(intent);
                }
            }
        };
    }
//        public void start(View v)
//    {
//        Runnable r= new Runnable() {
//            @Override
//            public void run() {
//                for (int i=10;i>=0;i++)
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
    public void start(View v)
    {
        Runnable r= new Runnable() {
            @Override
            public void run() {
                //int total=(n1.getValue()*60+n2.getValue());
                for (int i=10;i>=0;i--)
                {
                    try {
                        Thread.sleep(1000);

                        handler.sendEmptyMessage(0);


                    }
                    catch (Exception e)
                    {

                    }
                }
            }
        };
        Thread t=new Thread(r);
        t.start();

    }
}
