package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.TaskDAO;
import com.sprhib.model.Task;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDAO taskDAO;

	public void addTask(Task task) {
		taskDAO.addTask(task);
	}

	public void updateTask(Task task) {
		taskDAO.updateTask(task);
	}

	public Task getTask(int id) {
		return taskDAO.getTask(id);
	}

	public void deleteTask(int id) {
		taskDAO.deleteTask(id);
	}

	public List<Task> getTasks() {
		return taskDAO.getTasks();
	}
	public List<Task> getTasksIncomplete() {
		return taskDAO.getTasksIncomplete();
	}
	public List<Task> getTasksComplete() {
		return taskDAO.getTasksComplete();
	}

}
