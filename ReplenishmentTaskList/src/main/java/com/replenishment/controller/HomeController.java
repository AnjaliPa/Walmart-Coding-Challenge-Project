package com.replenishment.controller;

import java.io.IOException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.replenishment.dao.TaskDao;
import com.replenishment.model.StatusMatrix;
import com.replenishment.model.Task;
import com.replenishment.model.TaskAssign;
import com.replenishment.model.Users;

/*Controller file*/

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private TaskDao taskDao;

	/* Display home page of application */
	@RequestMapping("/")
	public String home() {

		return "home";
	}

	/* Display registration page */
	@RequestMapping("/displayRegistrationPage")
	public String displayRegistrationPage() {
		logger.info("Display Registration User Page!");
		return "registrationUser";
	}

	/* Process registration */
	@RequestMapping("/userRegistrationPage")
	public String userRegistration(@ModelAttribute("users") Users users) {
		logger.info("Process Registration  Page!");
		taskDao.addUser(users);
		return "home";
	}

	/* Display login administrator page */
	@RequestMapping("/adminlogin")
	public String adminloginPage() {
		logger.info("Display Admin Login Page!");
		return "login";
	}

	/* Display landing admin Page after processing admin login Page */
	@RequestMapping(value = "/adminlandingPage", method = RequestMethod.POST)
	public ModelAndView adminlandingPage(@ModelAttribute("users") Users users, BindingResult result,
			HttpSession session) {
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

	/* Display user login page */
	@RequestMapping("/userlogin")
	public String userloginPage() {
		logger.info("Display User Login Page!");
		return "userlogin";
	}

	/* Process user login page to landing page */
	@RequestMapping(value = "/userlandingPage", method = RequestMethod.POST)
	public ModelAndView userlandingPage(@ModelAttribute("users") Users users, BindingResult result,
			HttpSession session) {
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

	/* Display create task form for admin and individual user */
	@RequestMapping(value = "/displayCreateTaskForm")
	public String createTask(Model model) {

		return "createTask";
	}

	/* Process create task form for admin and individual user */
	@RequestMapping(value = "/createTaskProcess", method = RequestMethod.POST)
	public String createTaskProcess(@ModelAttribute("task") Task task, BindingResult result,
			HttpServletRequest request) {
		taskDao.addTask(task);
		logger.info("Task Created Succesfully!");
		return "redirect:/displayCreateTaskForm";
	}

	/*
	 * Display all the task which is created by admin,individual user and rest
	 * api
	 */
	@RequestMapping(value = "/displayTask")
	public String displayTask(Model model, HttpSession session) throws IOException {
		List<Task> tasks = taskDao.getAllTask((Users) session.getAttribute("users"));
		model.addAttribute("tasks", tasks);
		session.setAttribute("users", session.getAttribute("users"));
		return "displayTask";

	}

	/* Display the task which is going to assign individual user by admin */
	@RequestMapping(value = "/assignTask/{taskId}")
	public String assignTask(@PathVariable int taskId, Model model) throws IOException {
		Task task = taskDao.getTaskById(taskId);
		model.addAttribute("task", task);
		List<TaskAssign> taskAssign = taskDao.getAllAssignTo();
		model.addAttribute("taskAssignList", taskAssign);
		return "assignTask";
	}

	/* Process assign task */
	@RequestMapping(value = "/taskAssignProcess", method = RequestMethod.POST)
	public String createTaskProcess(@ModelAttribute("taskassign") TaskAssign taskassign, Model model,
			BindingResult result, HttpServletRequest request) {
		taskDao.addTaskAssign(taskassign);
		return "redirect:/displayTask";
	}

	/* Display status action matrix */
	@RequestMapping(value = "/statusMatrixForm/{taskId}")
	public String statusMatrixActionForm(@PathVariable int taskId, Model model) throws IOException {
		Task task = taskDao.getTaskById(taskId);
		model.addAttribute("task", task);
		return "statusMatrix";
	}

	/* Process status action matrix */
	@RequestMapping(value = "/saveStatusMatrix/{taskId}", method = RequestMethod.POST)
	public String saveStatusMatrix(@ModelAttribute("statusMatrix") StatusMatrix statusMatrix, @PathVariable int taskId,
			BindingResult result, HttpServletRequest request) {
		taskDao.addStatusMatrix(statusMatrix);
		return "redirect:/statusMatrixForm/{taskId}";
	}

	/* Display all the pending task */
	@RequestMapping(value = "/displayPendingTask")
	public String displayPendingTask(Model model, HttpSession session) throws IOException {
		List<TaskAssign> taskAssigns = taskDao.getAllPendingTask((Users) session.getAttribute("users"));
		model.addAttribute("taskAssigns", taskAssigns);
		return "displayPendingTask";

	}

	/* Display all task to individual */
	@RequestMapping(value = "/displayUsersTask")
	public String displayUsersTask(Model model, HttpSession session) throws IOException {
		List<Task> Task = taskDao.getAllAssignedUserTask((Users) session.getAttribute("users"));
		model.addAttribute("Task", Task);
		session.setAttribute("users", session.getAttribute("users"));
		return "displayUsersTask";
	}

	/* Using for Junit test case */
	private List<Task> taskList = new ArrayList<>();

	public int getTaskCount() {
		return taskList.size();
	}

}