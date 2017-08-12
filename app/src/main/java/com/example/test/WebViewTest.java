package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewTest extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_test);
        init();
    }

    private void init() {
        webView=(WebView)findViewById(R.id.webview);
        //用web资源打开网页
        webView.loadUrl("http://www.baidu.com");
        //覆盖webview 默认通过第三方或者是系统浏览器打开网页的行为,使得网页可以在webview中打开
        webView.setWebViewClient(new WebViewClient(){

        });
    }
}
