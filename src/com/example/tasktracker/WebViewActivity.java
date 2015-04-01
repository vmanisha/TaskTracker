package com.example.tasktracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class WebViewActivity extends ActionBarActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener {

	public TaskInfo mTaskInfo;
	private MyWebView myWebView;
    public GestureDetector mDetector; 
    public PageInfo mPageInfo;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		
		int taskInd = TaskTrackerActivity.mTaskTrackerEngine.mActiveTaskInd; 
		mTaskInfo = TaskTrackerActivity.mTaskTrackerEngine.mTaskList.get(taskInd);

		mDetector = new GestureDetector(this, this);
        mDetector.setOnDoubleTapListener(this);
		
        myWebView = new MyWebView(this,this);
        setContentView(myWebView);
    	myWebView.loadUrl("http://www.google.com");
        mTaskInfo.mTaskState = TaskInfo.TASK_STATE_EXECUTED;  
	}
	
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
	
	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_SingleTap",e.toString());
		mPageInfo.mNSingleTap++;
		return true;
	}


	@Override
	public boolean onDoubleTap(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_DoubleTap",e.toString());
		mPageInfo.mNDoubleTap++;
		return true;
	}


	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_DoubleTapEvent",e.toString());
		return true;
	}


	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_Down",e.toString());
		return true;
	}


	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_Press",e.toString());
	}


	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_SingleTapUP",e.toString());
		return true;
	}


	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_Scroll",e1.toString());
		Log.i(TaskTrackerActivity.TAG+"Gesture_Scroll",e2.toString());
		return true;
	}


	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_LongPress",e.toString());
	}


	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		Log.i(TaskTrackerActivity.TAG+"Gesture_Fling",e1.toString());
		Log.i(TaskTrackerActivity.TAG+"Gesture_Fling",e2.toString());
		return true;
	}

	public void updatePage(String url, int pageType){
		mPageInfo = mTaskInfo.getPageData(url, pageType);
	}
}
