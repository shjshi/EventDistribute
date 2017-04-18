package com.shj.eventdistribute.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Reus on 2017/4/18.
 * ViewGroup有拦截
 * */


 /**
  * 父布局三个方法都super
  * down，move，up
  E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
  E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
  E/MyButton: dispatchTouchEvent ACTION_DOWN
  E/MyLinearLayout: onTouch ACTION_DOWN
  E/MyButton: onTouchEvent ACTION_DOWN
  E/MyLinearLayout: dispatchTouchEvent ACTION_MOVE
  E/MyLinearLayout: onInterceptTouchEvent ACTION_MOVE
  E/MyButton: dispatchTouchEvent ACTION_MOVE
  E/MyLinearLayout: onTouch ACTION_MOVE
  E/MyButton: onTouchEvent ACTION_MOVE
  E/MyLinearLayout: dispatchTouchEvent ACTION_UP
  E/MyLinearLayout: onInterceptTouchEvent ACTION_UP
  E/MyButton: dispatchTouchEvent ACTION_UP
  E/MyLinearLayout: onTouch ACTION_UP
  E/MyButton: onTouchEvent ACTION_UP

 */

/**
 * onInterceptTouchEvent return true
 * 只有父布局的down被触发
 * E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
  E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
  E/MyLinearLayout: onTouchEvent ACTION_DOWN
 * 但是如果activity中给父布局设置了setOnClickListener
 *
 */

public class MyLinearLayout extends LinearLayout
{
    private static final String TAG = MyLinearLayout.class.getSimpleName();

    public MyLinearLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        int action = ev.getAction();
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
//        return true;
        return super.dispatchTouchEvent(ev);
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

        return super.onTouchEvent(event);
//        return true;
//        return false;
    }

    /**
     *
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
    int action = ev.getAction();
    switch (action)
    {
    case MotionEvent.ACTION_DOWN:
    //如果你觉得需要拦截
    return true ;
    case MotionEvent.ACTION_MOVE:
    //如果你觉得需要拦截
    return true ;
    case MotionEvent.ACTION_UP:
    //如果你觉得需要拦截
    return true ;
    }

    return false;
    }
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {

        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        //默认不允许拦截
//        return super.onInterceptTouchEvent(ev);
        //true拦截了，不往view传递了，onClick事件也没有了
        return true;
//        return false;
    }
    //
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept)
    {
        Log.e(TAG, "requestDisallowInterceptTouchEvent ");
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

}