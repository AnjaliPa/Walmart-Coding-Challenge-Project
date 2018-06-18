package com.replenishment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskAssign {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int replenishmentId;
	private int taskId;
	private String taskName;
	private String taskDescription;
	private String taskNotes;
	private String taskFeedback;
	private String taskStatus;
	private String taskAssignTo;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTaskAssignTo() {
		return taskAssignTo;
	}
	public void setTaskAssignTo(String taskAssignTo) {
		this.taskAssignTo = taskAssignTo;
	}
	public int getReplenishmentId() {
		return replenishmentId;
	}
	public void setReplenishmentId(int replenishmentId) {
		this.replenishmentId = replenishmentId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskNotes() {
		return taskNotes;
	}
	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}
	public String getTaskFeedback() {
		return taskFeedback;
	}
	public void setTaskFeedback(String taskFeedback) {
		this.taskFeedback = taskFeedback;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
}