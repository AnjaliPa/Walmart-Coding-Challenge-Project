package com.replenishment.dao;

import java.util.List;

import com.replenishment.model.StatusMatrix;
import com.replenishment.model.Task;
import com.replenishment.model.TaskAssign;
import com.replenishment.model.Users;

public interface TaskDao {
	
	/*Add new task*/
	int addTask(Task task);

	/*Get all tasks*/
	List<Task> getAllTask(Users user);

	/*Add new user*/
	void addUser(Users user);

	/* Get individual task */
	Task getTaskById(int id);

	/*Add assigned task*/
	void addTaskAssign(TaskAssign taskassign);

	/*Get all assigned task*/
	List<TaskAssign> getAllAssignTo();

	/*Check validation for admin login*/
	public boolean checkAdminLogin(Users users);

	/*Check validation for user login*/
	public boolean checkUserLogin(Users users);

	/*Add Status action matrix*/
	void addStatusMatrix(StatusMatrix statusMatrix);
	
	/*Get all pending task for admin or individual*/
	List<TaskAssign> getAllPendingTask(Users users);
	
	
	/* get all assigned task to individual*/
	List<Task> getAllAssignedUserTask(Users users);

	//List<TaskAssign> getAllPendingUserTask(Users users);

}
