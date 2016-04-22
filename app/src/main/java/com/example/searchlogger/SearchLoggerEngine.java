package com.example.searchlogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchLoggerEngine {
	
	public SearchLoggerActivity mSearchLoggerActivity;
	
	public String mUserID;
	public List<TaskInfo> mTaskList;
	public List<String> mTaskNameList;
	public int mActiveTaskInd = 0;
	
	public SearchLoggerEngine(){
	}
	
	public void setSearchLoggerActivity(SearchLoggerActivity activity){
		mSearchLoggerActivity = activity;
	}
	
	public void LoadUserData(){
		//populating dummy data
		mUserID = "nisarg";
		HashMap <String, String> tasks= new HashMap<String, String>();
        tasks.put("Ebola Virus" , "You want to know about ebola, its symptoms, prevention and cure.");
        tasks.put("Welch Corgi "," You are looking for information about Welch corgi dog.");
        tasks.put("History of Music ","  Find information about history of music. ");
        tasks.put("Turkey Leftover "," Find information for cooking suggestions for turkey leftover. ");
        tasks.put("Bouguereau "," You are looking for information about Bouguereau and his paintings. ");
        tasks.put("Hobbits Theme "," You are looking for the theme music of the hobbits, from the  movie Lord of the Rings. ");
        tasks.put("Sphere inertia "," You want to know how to calculate the inertia of a sphere. ");
        tasks.put("Cats Purr "," You want to know why cats purr and what it means. ");
        tasks.put("Upcoming games "," You want to know which are this year's most anticipates games and their projected rating. ");
        tasks.put("BMW motorcycle "," You want to know what a BMW C1 motorcycle is and how its like. ");
        tasks.put("Long Beach "," Find out about Long Beach, California as tourist destination. ");

        mTaskList = new ArrayList<TaskInfo>();
        int i =1;
        for (Map.Entry<String, String> entry : tasks.entrySet())
            mTaskList.add(new TaskInfo(i++,TaskInfo.TASK_STATE_UNREAD,entry.getKey(),entry.getValue()));
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
