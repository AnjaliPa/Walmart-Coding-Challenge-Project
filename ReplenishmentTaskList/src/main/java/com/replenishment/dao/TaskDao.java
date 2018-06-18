package com.replenishment.dao;

import java.util.List;

import com.replenishment.model.Task;
import com.replenishment.model.TaskAssign;
import com.replenishment.model.Users;

public interface TaskDao {

	void addTask(Task task);
	List<Task> getAllTask(Users user);
	Task getTaskById(int id);
	void addTaskAssign(TaskAssign taskassign);
	List<TaskAssign> getAllAssignTo();
	public boolean checkAdminLogin(Users users);
	public boolean checkUserLogin(Users users);

}
