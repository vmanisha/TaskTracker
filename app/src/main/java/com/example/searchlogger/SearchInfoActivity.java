package com.example.searchlogger;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchInfoActivity extends ActionBarActivity {

	public TaskInfo mTaskInfo;

	public TextView mTaskNameView;
	public TextView mTaskDescriptionView;
	public Button mTaskExecuteButton;
	public Button mTaskQAButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_info);
		
		int taskInd = SearchLoggerActivity.mSearchLoggerEngine.mActiveTaskInd;
		mTaskInfo = SearchLoggerActivity.mSearchLoggerEngine.mTaskList.get(taskInd);
		
		mTaskNameView = (TextView) findViewById(R.id.textView_taskName);
		mTaskDescriptionView = (TextView) findViewById(R.id.textView_taskDescription);
		
		mTaskNameView.setText(mTaskInfo.mTaskName);
		mTaskDescriptionView.setText(mTaskInfo.mTaskDescription);
		mTaskInfo.mTaskState = TaskInfo.TASK_STATE_READ;
	}

	public void executeTaskOnClickHandler(View v){
		Log.i(SearchLoggerActivity.TAG,"Execute");
    	Intent intent = new Intent(this,WebViewActivity.class);
    	startActivity(intent);
	}

	public void qaOnClickHandler(View v){
		Log.i(SearchLoggerActivity.TAG,"QA");
    	Intent intent = new Intent(this,QAActivity.class);
    	startActivity(intent);
		Set set = mTaskInfo.mTaskData.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry)i.next();
			Log.i(SearchLoggerActivity.TAG,me.getKey().toString());
			PageInfo pageInfo = (PageInfo) me.getValue();

		}
	}

}
