package com.demo.mywebviewdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Set;

public class Main4Activity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings= webView.getSettings();
        //设置加载JS权限
        webSettings.setJavaScriptEnabled(true);
        //设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
         //加载file文件

        webView.loadUrl("file:///android_asset/sencodJs.html");

         webView.setWebViewClient(new WebViewClient() {
             //  一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
             //  "js://webview?location=1"
             @Override
             public boolean shouldOverrideUrlLoading(WebView view, String url) {
                 Uri uri = Uri.parse(url);
                 //如果url的协议 = 预先约定的 js 协议
                 if (uri.getScheme().equals("js")) {
                     // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                     if (uri.getAuthority().equals("webview")) {
                         // 执行JS所需要调用的逻辑
                         System.out.println("js调用了Android的方法");
                         // 可以在协议上带有参数并传递到Android上
//                           HashMap<String, String> params = new HashMap<>();
//                           Set<String> collection = uri.getQueryParameterNames();
                         AlertDialog.Builder mBuilder = new AlertDialog.Builder(Main4Activity.this);
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
                     return true;
                 }
                 return super.shouldOverrideUrlLoading(view, url);
             }


         });
    }


}
