package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Task;
import com.sprhib.service.TaskService;

@Controller
@RequestMapping(value="/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTaskPage() {
		ModelAndView modelAndView = new ModelAndView("add-task-form");
		modelAndView.addObject("task", new Task());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingTask(@ModelAttribute Task task) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		taskService.addTask(task);
		
		String message = "Task was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfTasks() {
		ModelAndView modelAndView = new ModelAndView("list-of-tasks");
		
		List<Task> tasks = taskService.getTasks();
		modelAndView.addObject("tasks", tasks);
		
		return modelAndView;
	}

	@RequestMapping(value="/list_incomplete")
	public ModelAndView listOfTasksIncomplete() {
		ModelAndView modelAndView = new ModelAndView("list-of-incomplete");

		List<Task> tasks = taskService.getTasksIncomplete();
		modelAndView.addObject("tasks", tasks);

		return modelAndView;
	}
	@RequestMapping(value="/list_complete")
	public ModelAndView listOfTasksComplete() {
		ModelAndView modelAndView = new ModelAndView("list-of-complete");

		List<Task> tasks = taskService.getTasksComplete();
		modelAndView.addObject("tasks", tasks);

		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editTaskPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-task-form");
		Task task = taskService.getTask(id);
		modelAndView.addObject("task", task);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingTask(@ModelAttribute Task task, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		taskService.updateTask(task);
		
		String message = "Task was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteTask(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		taskService.deleteTask(id);
		String message = "Task was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
