package com.example.homework4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

public class Web_Activity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView=findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);

        Intent intent=getIntent();
        Uri uri=intent.getData();
        String urlString=null;
        try {
            urlString=new URL(uri.getScheme(), uri.getHost(), uri.getPath()).toString();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        webView.loadUrl(urlString);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                if(url.startsWith("http:")||url.startsWith("https:")){
                    view.loadUrl(url);
                    return super.shouldOverrideUrlLoading(view,url);
                }
                view.loadUrl(url);
                return true;
            }
        });
    }
}
