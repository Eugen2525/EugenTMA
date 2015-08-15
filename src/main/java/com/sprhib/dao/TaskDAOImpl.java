package com.sprhib.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTask(Task task) {
		getCurrentSession().save(task);
	}

	public void updateTask(Task task) {
		Task taskToUpdate = getTask(task.getId());
		taskToUpdate.setName(task.getName());
		taskToUpdate.setDay(task.getDay());
		taskToUpdate.setCompleted(task.isCompleted());
		getCurrentSession().update(taskToUpdate);
	}

	public Task getTask(int id) {
		Task task = (Task) getCurrentSession().get(Task.class, id);
		return task;
	}

	public void deleteTask(int id) {
		Task task = getTask(id);
		if (task != null)
			getCurrentSession().delete(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTasks() {
		return getCurrentSession().createQuery("from Task").list();
	}
	@SuppressWarnings("unchecked")
	public List<Task> getTasksIncomplete() {
		return getCurrentSession().createQuery("from Task where completed=0").list();
	}
	@SuppressWarnings("unchecked")
	public List<Task> getTasksComplete() {
		return getCurrentSession().createQuery("from Task where completed=1").list();
	}

}
