package uk.ac.cs.ucl.searchlogger;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class WebViewActivity extends ActionBarActivity implements GestureDetector.OnGestureListener{

	public TaskInfo mTaskInfo;
	private MyWebView myWebView;
    public GestureDetector mDetector; 
    public PageInfo mPageInfo;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		
		int taskInd = SearchLoggerActivity.mSearchLoggerEngine.mActiveTaskInd;
		mTaskInfo = SearchLoggerActivity.mSearchLoggerEngine.mTaskList.get(taskInd);

		mDetector = new GestureDetector(this, this);

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
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }


    @Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
        mPageInfo.updateScrollEvent(e1,  e2, distanceX, distanceY);
		Log.i(SearchLoggerActivity.TAG+"Gest_Scrol1",e1.getX()+" "+e1.getY());
		Log.i(SearchLoggerActivity.TAG+"Gest_Scrol2",e2.getX()+" "+e2.getY());
        Log.i(SearchLoggerActivity.TAG+"Gest_Scrol",distanceX+ " "+ distanceY);

        return true;
	}

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        return false;
    }


    public void updatePage(String url, int pageType){
        if (mPageInfo!=null)
            mPageInfo.setEndDate();
		mPageInfo = mTaskInfo.getPageData(url, pageType);
	}
}
