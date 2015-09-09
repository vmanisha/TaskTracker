package com.example.tasktracker;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebView extends WebView{
	
	private WebViewActivity mWebViewActivity;
	
	public MyWebView(WebViewActivity activity, Context context) {
		super(context);
		mWebViewActivity = activity;
        setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mWebViewActivity.mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	
	public class MyWebViewClient extends WebViewClient{
		@Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
			mWebViewActivity.updatePage(url,TaskInfo.PAGE_TYPE_LANDING);
	        return false;
	    }
	}
}
