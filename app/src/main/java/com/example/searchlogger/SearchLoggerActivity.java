package com.example.searchlogger;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SearchLoggerActivity extends ActionBarActivity {

	public static final String TAG = "SearchLogger::";
	
	public static SearchLoggerEngine mSearchLoggerEngine = new SearchLoggerEngine();
	public ArrayAdapter<String> mTaskListAdapter; 
	public ListView mTaskListView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_tracker);
        
        //initialize engine
        //mSearchLoggerEngine = new SearchLoggerEngine(this);
        mSearchLoggerEngine.setSearchLoggerActivity(this);
        mSearchLoggerEngine.LoadUserData();
        ShowTaskList();
    }

    @Override
    protected void onPause(){
    	super.onPause();
    }

    @Override
    protected void onResume(){
    	super.onResume();
    	for(TaskInfo taskInfo : mSearchLoggerEngine.mTaskList){
    		Log.i(TAG,taskInfo.mTaskState+"");
    	}
    	mSearchLoggerEngine.mActiveTaskInd = -1;
    }

    public void ShowTaskList(){
    	mTaskListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSearchLoggerEngine.mTaskNameList);
    	
    	mTaskListView = (ListView) findViewById(R.id.listView_taskList);
    	mTaskListView.setAdapter(mTaskListAdapter);
    	mTaskListView.setOnItemClickListener( new OnItemClickListener() {
    		        public void onItemClick(AdapterView parent, View v, int position, long id) {
    		        	mSearchLoggerEngine.mActiveTaskInd = position;
    		        	Intent intent = new Intent(SearchLoggerActivity.this,SearchInfoActivity.class);
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
