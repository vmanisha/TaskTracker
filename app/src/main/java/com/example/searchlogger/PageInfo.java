package com.example.searchlogger;

import android.util.Log;
import android.view.MotionEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageInfo{
	public String mURL;
	public int mPageType;
    public Date startDate;
    public Date endDate;
    public int numDownScrolls;
    public int numUpScrolls;

    //TODO(mverma): Store the number of scrolls
    //TODO(mverma): Store the elements that were viewed on the page.

	public PageInfo(String url, int pageType){
		mURL = url;
		mPageType = pageType;

        DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        Log.i("Starting PageInfo "+mURL, startDate.toString());

	}

    public void setEndDate() {
        DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        endDate = new Date();
        Log.i("Ending PageInfo "+mURL, endDate.toString());

    }

    public void updateScrollEvent(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //TODO(mverma): Extract the
    }
}
