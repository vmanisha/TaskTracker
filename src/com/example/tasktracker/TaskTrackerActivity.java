package com.example.tasktracker;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TaskTrackerActivity extends ActionBarActivity {

	public static final String TAG = "TaskTracker::";
	
	public static TaskTrackerEngine mTaskTrackerEngine = new TaskTrackerEngine();
	public ArrayAdapter<String> mTaskListAdapter; 
	public ListView mTaskListView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_tracker);
        
        //initialize engine
        //mTaskTrackerEngine = new TaskTrackerEngine(this);
        mTaskTrackerEngine.setTaskTrackerActivity(this);
        mTaskTrackerEngine.LoadUserData();
        ShowTaskList();
    }

    @Override
    protected void onPause(){
    	super.onPause();
    }

    @Override
    protected void onResume(){
    	super.onResume();
    	for(TaskInfo taskInfo : mTaskTrackerEngine.mTaskList){
    		Log.i(TAG,taskInfo.mTaskState+"");
    	}
    	mTaskTrackerEngine.mActiveTaskInd = -1;
    }

    public void ShowTaskList(){
    	mTaskListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mTaskTrackerEngine.mTaskNameList);
    	
    	mTaskListView = (ListView) findViewById(R.id.listView_taskList);
    	mTaskListView.setAdapter(mTaskListAdapter);
    	mTaskListView.setOnItemClickListener( new OnItemClickListener() {
    		        public void onItemClick(AdapterView parent, View v, int position, long id) {
    		        	mTaskTrackerEngine.mActiveTaskInd = position;
    		        	Intent intent = new Intent(TaskTrackerActivity.this,TaskInfoActivity.class);
    		        	startActivity(intent);
    		        }
    		    });
    	
    }
    
//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//      // Inflate the menu; this adds items to the action bar if it is present.
//      getMenuInflater().inflate(R.menu.task_tracker, menu);
//      return true;
//  }
//
//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//      // Handle action bar item clicks here. The action bar will
//      // automatically handle clicks on the Home/Up button, so long
//      // as you specify a parent activity in AndroidManifest.xml.
//      int id = item.getItemId();
//      if (id == R.id.action_settings) {
//          return true;
//      }
//      return super.onOptionsItemSelected(item);
//  }

       
}
