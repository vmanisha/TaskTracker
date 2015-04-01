package com.example.tasktracker;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class TaskTrackerEngine {
	
	public TaskTrackerActivity mTaskTrackerActivity;
	
	public String mUserID;
	public List<TaskInfo> mTaskList;
	public List<String> mTaskNameList;
	public int mActiveTaskInd = -1;
	
	public TaskTrackerEngine(){
	}
	
	public void setTaskTrackerActivity(TaskTrackerActivity activity){
		mTaskTrackerActivity = activity;
	}
	
	public void LoadUserData(){
		//populating dummy data
		mUserID = "nisarg";
		String temp = "After you have found the guide for the area you are interested in, there may still be more information waiting for you to read. We don't cover information on how to get into a country in every destination guide. You won't find visa information for Australia in the Sydney article. So, if you are coming from further afield, you may want to refer to the breadcrumb links at the top of the page, and read the country or region guide, to make sure you have the full picture.";
		temp = temp+temp+temp+temp+temp+temp;
		mTaskList = new ArrayList<TaskInfo>();
		mTaskList.add(new TaskInfo(1,TaskInfo.TASK_STATE_UNREAD,"Task 1",temp));
		mTaskList.add(new TaskInfo(2,TaskInfo.TASK_STATE_UNREAD,"Task 2","Dummy Description 2"));
		mTaskList.add(new TaskInfo(3,TaskInfo.TASK_STATE_UNREAD,"Task 3","Dummy Description 3"));
		mTaskList.add(new TaskInfo(4,TaskInfo.TASK_STATE_UNREAD,"Task 4","Dummy Description 4"));
		//load task names
		mTaskNameList = new ArrayList<String>();
		for(TaskInfo taskInfo : mTaskList){
			mTaskNameList.add(taskInfo.mTaskName);
		}
	}
	
	public boolean ValidUser(){
		if(mUserID == null)
			return false;
		else
			return true;
	}
}
