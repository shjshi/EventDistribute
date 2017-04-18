package com.shj.eventdistribute.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Reus on 2017/4/18.
 * 1 没有拦截
 * view有两个关于事件分发机制的方法 1 onTouchEvent，2 dispatchTouchEvent
 */

public class MyButton extends Button
{
    private static final String TAG = MyButton.class.getSimpleName();

    public MyButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        //默认所有都走
        return super.onTouchEvent(event);
        //false，走了dispatchTouchEvent，OnTouch，onTouchEvent的down方法
//        return false;
        //true，dispatchTouchEvent，onTouch，onTouchEvent，down，move，up方法，没有onClick
//        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        //请求父亲不要拦截
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        //super往下传递，走dispatchTouchEvent，onTouch,onTouchEvent(走不走看onTouch),onClick(走不走看onTouchEvent),onLongClick(走不走看onTouchEvent)
        return super.dispatchTouchEvent(event);
        //没有super,所有的操作都在super中，你不super,当然就不往下走了
        //true,只完成了dispatchTouchEvent的down，move，up
//        return true;
        //false 就仅仅停止在dispatchTouchEvent ACTION_DOWN，不在往下进行
//        return false;
    }


}
