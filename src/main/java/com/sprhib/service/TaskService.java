package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Task;

public interface TaskService {
	
	public void addTask(Task task);
	public void updateTask(Task task);
	public Task getTask(int id);
	public void deleteTask(int id);
	public List<Task> getTasks();
	public List<Task> getTasksIncomplete();
	public List<Task> getTasksComplete();
}
