package com.nytimesmpa.Activities;

import android.graphics.Bitmap;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.nytimesmpa.BaseClasses.BaseActivity;
import com.nytimesmpa.R;

public class ArticleDetailActivity extends BaseActivity {

   private WebView webView ;
   private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        webView = findViewById(R.id.web_view);
        progressBar = findViewById(R.id.progress_bar);

        // Setting WebView Configuration
        webView.setInitialScale(1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        String data = getIntent().getExtras().getString(BaseActivity.articleDetailURL);
        if(data !=""){
            //Load Url in WebView
            loadUrlInWebView(data);

           // makeToast(data);
        }
    }

    private void loadUrlInWebView(String url){

        progressBar.setVisibility(View.VISIBLE);
        ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) webView.getLayoutParams();
        p.leftMargin=0;
        p.rightMargin=0;
        p.topMargin=0;
        webView.setLayoutParams(p);

        webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                progressBar.setVisibility(View.GONE);
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }

            public void onPageFinished(WebView view, String url) {

                progressBar.setVisibility(View.GONE);

            }
        });

        webView.loadUrl(url);

    }
}
