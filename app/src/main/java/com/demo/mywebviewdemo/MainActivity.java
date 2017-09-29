package com.demo.mywebviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.view.KeyEvent.KEYCODE_BACK;

public class MainActivity extends AppCompatActivity {

    private WebView wb_main;
    String url = "http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wb_main = (WebView) findViewById(R.id.wb_main);
        wb_main.getSettings().setJavaScriptEnabled(true);//支持JavaScriptEnable
        wb_main.setWebViewClient(new WebViewClient());
        wb_main.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && wb_main.canGoBack()) {
            wb_main.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

//        @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){
//            if(wb_main.canGoBack() ){
//                //获取浏览记录
//                WebBackForwardList backForwardList= wb_main.copyBackForwardList();
//                //这里的判断是为了让页面在有上一个页面的情况下，跳转到上一个html页面，而不是退出当前activity
//                 if(backForwardList.getCurrentIndex()>0){
//                     String  historyUrl =  backForwardList.getItemAtIndex(backForwardList.getCurrentIndex()-1).getUrl();
//                     if(historyUrl !=url ){
//                         wb_main.goBack();
//                         return true;
//                     }
//                 }else{
//                     finish();
//                 }
//
//            } else{
//                return  true;
//            }
//        }
//        return true;
//    }
}
