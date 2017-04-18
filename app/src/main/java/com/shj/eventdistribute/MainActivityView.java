package com.shj.eventdistribute;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shj.eventdistribute.view.MyLinearLayout;

/**
 * View在activity中有一个setOnTouchListener的事件分发机制的方法
 */
public class MainActivityView extends Activity
{
    protected static final String TAG = "MyLinearLayout";
    private Button mButton ;
    private MyLinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = ((MyLinearLayout) findViewById(R.id.activity_main));
        mButton = (Button) findViewById(R.id.id_btn);
//        mButton.setEnabled(false);
        //如果mButton.setEnabled(false)，就没有onTouch方法了
        mButton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int action = event.getAction();

                switch (action)
                {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "onTouch ACTION_UP");
                        break;
                    default:
                        break;
                }
                //onTouch的返回值，决定onTouchEvent这个方法是否会被调用，true（不调用onTouchEvent）
                return false;
            }
        });
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.e(TAG, "button click");
            }
        });

        mButton.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                Log.e(TAG, "button longclick");
                //长按return false，onClick和onLongClick都触发,return true,屏蔽return flase
                return false;
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"PARENT",Toast.LENGTH_LONG).show();
                Log.e(TAG, "CLICK PARENT");
            }
        });
        ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.e(TAG, "longCLICK PARENT");
                return false;
            }
        });
        ll.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int action = event.getAction();

                switch (action)
                {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "LL onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "LL onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "LL onTouch ACTION_UP");
                        break;
                    default:
                        break;
                }
                //onTouch的返回值，决定onTouchEvent这个方法是否会被调用，true（不调用onTouchEvent）
                return false;
            }
        });
    }


}
