package com.example.mybookslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web=findViewById(R.id.web);
        Intent intent=getIntent();
        if(intent!=null)
        {
            String url=intent.getStringExtra("webview");
            web.loadUrl(url);
            web.setWebViewClient(new WebViewClient());
            web.getSettings().setJavaScriptEnabled(true);
        }
    }

    @Override
    public void onBackPressed()
    {
        if(web.canGoBack())
        {
            web.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}