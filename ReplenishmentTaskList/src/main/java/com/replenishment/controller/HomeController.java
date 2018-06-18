package com.replenishment.controller;

import java.io.IOException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PostLoad;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.replenishment.dao.TaskDao;
import com.replenishment.model.Task;
import com.replenishment.model.TaskAssign;
import com.replenishment.model.Users;

@Controller
public class HomeController {

	private static final Logger logger =  Logger.getLogger(HomeController.class);
	@Autowired
	private TaskDao taskDao;
	
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/adminlogin")
	public String adminloginPage() {
		logger.info("Display Admin Login Page!");
		return "login";
	}
	
	@RequestMapping("/userlogin")
	public String userloginPage() {
		logger.info("Display User Login Page!");
		return "userlogin";
	}
	
	@RequestMapping(value = "/adminlandingPage" , method = RequestMethod.POST)
	public ModelAndView adminlandingPage(@ModelAttribute("users") Users users, BindingResult result,HttpSession session) {
		ModelAndView modelView;
		
		if (!taskDao.checkAdminLogin(users)) {
			modelView = new ModelAndView("login");
			modelView.addObject("errors", "Invalid Credentials");
			logger.info("Invalid Credentials,Please Try Again!");

			return modelView;

		} else {
			modelView = new ModelAndView("landingPage");
			session.setAttribute("users", users);
			modelView.addObject("users", users);
			logger.info("Welcome to Admin Landing Page!");

		}
		
		return modelView;
	}
	
	@RequestMapping(value = "/userlandingPage" , method = RequestMethod.POST)
	public ModelAndView userlandingPage(@ModelAttribute("users") Users users, BindingResult result,HttpSession session) {
		ModelAndView modelView;
		
		if (!taskDao.checkUserLogin(users)) {
			modelView = new ModelAndView("userlogin");
			modelView.addObject("errors", "Invalid Credentials");
			logger.info("Invalid Credentials,Please Try Again!");

			return modelView;

		} else {
			modelView = new ModelAndView("userlandingPage");
			session.setAttribute("users", users);
			modelView.addObject("users", users);
			logger.info("Welcome to User Landing Page!");

		}
		
		
		return modelView;
	}
	
	@RequestMapping(value = "/displayCreateTaskForm")
	public String createTask(Model model) {

		return "createTask";
	}
	
	 @RequestMapping(value = "/createTaskProcess", method = RequestMethod.POST)
	    public String createTaskProcess(@ModelAttribute("task")Task task, BindingResult result, HttpServletRequest request) {
		taskDao.addTask(task);
		logger.info("Task Created Succesfully!");
	    return "redirect:/displayCreateTaskForm";
	    }
	 
	 
	 @RequestMapping(value = "/taskAssignProcess", method = RequestMethod.POST)
	    public String createTaskProcess(@ModelAttribute("taskassign")TaskAssign taskassign, BindingResult result, HttpServletRequest request) {
		taskDao.addTaskAssign(taskassign);
		logger.info("Task Assigned Succesfully!");
	    return "redirect:/displayTask";
	    }


	 @RequestMapping(value="/displayTask")
		public String displayTask(Model model,HttpSession session) throws IOException
		{
		 List<Task> tasks = taskDao.getAllTask((Users) session.getAttribute("users"));
		 model.addAttribute("tasks",tasks);
		 session.setAttribute("users", session.getAttribute("users"));
			logger.info("All Task Are Displayed!");

		 return "displayTask";
			
		}
	 
	 @RequestMapping(value="/assignTask/{taskId}")
		public String assignTask(@PathVariable int taskId,Model model) throws IOException
		{
		 Task task = taskDao.getTaskById(taskId);
		 model.addAttribute("task",task);
		 List<TaskAssign> taskAssign = taskDao.getAllAssignTo();
		 model.addAttribute("taskAssignList",taskAssign);
		 return "assignTask";
		}
	 
	 
	/* public void listtaskAssignTo(Model model) throws IOException
		{
		 List<TaskAssign> taskAssign = taskDao.getAllAssignTo();
			model.addAttribute("taskAssign",taskAssign);
			
			
		}*/
}