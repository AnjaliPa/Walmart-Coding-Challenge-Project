package com.replenishment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "StatusMatrix", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "taskId", "initialStatus", "nextStatus"}) })
public class StatusMatrix {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matrixId;
	private int taskId;
	private String initialStatus;
	private String nextStatus;
	private String taskAction;
	private String taskErrorStatus;

	public int getMatrixId() {
		return matrixId;
	}

	public void setMatrixId(int matrixId) {
		this.matrixId = matrixId;
	}

	

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getInitialStatus() {
		return initialStatus;
	}

	public void setInitialStatus(String initialStatus) {
		this.initialStatus = initialStatus;
	}

	public String getNextStatus() {
		return nextStatus;
	}

	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}

	public String getTaskAction() {
		return taskAction;
	}

	public void setTaskAction(String taskAction) {
		this.taskAction = taskAction;
	}

	public String getTaskErrorStatus() {
		return taskErrorStatus;
	}

	public void setTaskErrorStatus(String taskErrorStatus) {
		this.taskErrorStatus = taskErrorStatus;
	}

}
