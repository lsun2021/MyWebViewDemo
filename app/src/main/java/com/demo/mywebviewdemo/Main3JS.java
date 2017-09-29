package com.demo.mywebviewdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.webkit.JavascriptInterface;

import java.util.Objects;

/**
 * Created by ${momoThree} on 2017/9/29.
 * Title:
 */

public class Main3JS  extends Object {

    private Context mContext;

    public Main3JS(Context mContext) {
        this.mContext = mContext;
    }

    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public  void  ToJs(String msg){
        Log.e("tag","JS调用Android的代码");
        AlertDialog.Builder mBuilder= new AlertDialog.Builder(mContext);
        mBuilder.setTitle("Alert");
        mBuilder.setMessage("JS要调用Android的代码");
        mBuilder.setCancelable(true);
        mBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 dialogInterface.dismiss();
            }
        });
        mBuilder.create().show();
    }

}
