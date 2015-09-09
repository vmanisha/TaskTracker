package com.example.tasktracker;

import java.io.Serializable;
import java.util.HashMap;

public class TaskInfo{
	
	public static final int TASK_STATE_UNREAD = 0;
	public static final int TASK_STATE_READ = 1;
	public static final int TASK_STATE_EXECUTED = 2;
	public static final int TASK_STATE_SUBMITTED = 3;
	
	public static final int PAGE_TYPE_SRP = 0;
	public static final int PAGE_TYPE_LANDING = 1;
	
	public final int mTaskID;
	public int mTaskState;
	public String mTaskName;
	public String mTaskDescription;
	public HashMap mTaskData;

	public TaskInfo(int taskID, int taskState, String taskName, String taskDescription){
		mTaskID = taskID;
		mTaskState = taskState;
		mTaskName = taskName;
		mTaskDescription = taskDescription;
		mTaskData = new HashMap();
	}

	public PageInfo getPageData(String url, int pageType){
		PageInfo pageInfo = (PageInfo) mTaskData.get(url);
		if(pageInfo == null){
			pageInfo = new PageInfo(url,pageType);
			mTaskData.put(url, pageInfo);
		}
		return pageInfo;
	}
	
}
