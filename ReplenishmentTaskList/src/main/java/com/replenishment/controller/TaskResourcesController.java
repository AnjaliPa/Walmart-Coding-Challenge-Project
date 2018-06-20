package com.replenishment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.replenishment.dao.TaskDao;
import com.replenishment.model.Task;

@RestController
public class TaskResourcesController {

	@Autowired
	private TaskDao taskDao;

	/*
	 * Create task through rest api using rest webservice client URl:
	 * http://localhost:8080/ReplenishmentTaskList/createTaskbyRest {
	
	 */

	@RequestMapping(value = "/createTaskbyRest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> createTask(@RequestBody Task task, UriComponentsBuilder ucBuilder) {
		taskDao.addTask(task);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/task{taskId}").buildAndExpand(task.getTaskId()).toUri());
		return new ResponseEntity<Task>(headers, HttpStatus.CREATED);
	}

}
