package com.example.tasktracker;

public class PageInfo{
	public String mURL;
	public int mPageType;
	public int mNSingleTap;
	public int mNDoubleTap;
	
	public PageInfo(String url, int pageType){
		mURL = url;
		mPageType = pageType;
		mNSingleTap = 0;
		mNDoubleTap = 0;
	}
}
