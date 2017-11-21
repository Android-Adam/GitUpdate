package com.xdj.dyc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String url_ = "http://lapp.mallcoo.cn/error/urltolapp?_targetType=3&_actType=0&_url=https%3A%2F%2Fopen.weixin.qq.com%2Fconnect%2Foauth2%2Fauthorize%3Fappid%3Dwx92cf60f7577e2d48%26redirect_uri%3Dhttp%253A%252F%252Fwx.wepiao.com%252Fcinema_detail.html%253Fcinema_id%253D1014633%2526city_id%253D267%2526startFrom%253D0%2526_%253D1473158519737%26response_type%3Dcode%26scope%3Dsnsapi_base%26state%3D1%23wechat_redirect&_activityName=&_mid=111";
    WebView webview;
    AppCompatActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAppCacheEnabled(true);
        //设置 缓存模式
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启 DOM storage API 功能
        webview.getSettings().setDomStorageEnabled(true);
        webview.loadUrl("http://lapp.mallcoo.cn/?_mid=111");
        webview.setWebViewClient(new WebViewClient() {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Log.e("","电影网页链接：" + url);
                if(url_.equals(url)){
                    Toast.makeText(activity,"努力开发中...",Toast.LENGTH_SHORT).show();
                    return true;
                }
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(webview.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK){
            webview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
