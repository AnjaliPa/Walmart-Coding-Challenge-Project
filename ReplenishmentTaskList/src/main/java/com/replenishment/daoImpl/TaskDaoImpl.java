package com.replenishment.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.replenishment.dao.TaskDao;
import com.replenishment.model.Task;
import com.replenishment.model.TaskAssign;
import com.replenishment.model.Users;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private SessionFactory SessionFactory;

	@Override
	public void addTask(Task task) {
		Session session = SessionFactory.getCurrentSession();
		session.saveOrUpdate(task);
		session.flush();
	}

	@Override
	public List<Task> getAllTask(Users users) {
		Query query;
		Session session = SessionFactory.getCurrentSession();
		
		if(users.getUsername().equals("admin"))
			query = session.createQuery("From Task");
		else
			query = session.createQuery("From Task where  username = '"+users.getUsername()+"' ");
		//			query = session.createQuery("Select t.taskId,t.taskDescription,t.taskName, t.taskPriority,t.taskEstimatedTime,t.username From Task t,TaskAssign ta where  t.username = '"+users.getUsername()+"' or ta.taskAssignTo= '"+users.getUsername()+"'");

		System.out.println(query);
		List<Task> tasks = query.list();
		
		return tasks;
	}

	@Override
	public Task getTaskById(int id) {
		Session session = SessionFactory.getCurrentSession();
		Task task = (Task) session.get(Task.class,id);
		session.flush();
		return task;
	}

	@Override
	public void addTaskAssign(TaskAssign taskassign) {
		Session session = SessionFactory.getCurrentSession();
		session.saveOrUpdate(taskassign);
		session.flush();
		
	}

	@Override
	public List<TaskAssign> getAllAssignTo() {

		Session session = SessionFactory.getCurrentSession();
		Query query = session.createQuery("Select username from Users where role='user'");
		List<TaskAssign> assignToList = query.list();
		session.flush();
		return assignToList;
	
	}

	@Override
	public boolean checkAdminLogin(Users users) {
		boolean validuser = false;
		Session session = SessionFactory.getCurrentSession();
		String username = users.getUsername();
		String password = users.getPassword();
		Query query = session.createQuery("Select username from Users where username= '"+username+"' and password= '"+password+"' and role = 'admin' ");
		
		try{
			List list = query.list();
			if ((list != null) && (list.size() == 1)) {
				validuser= true;
			}
			}
			catch(Exception ex){
				return validuser;
			}
		session.flush();
		
		
		return validuser;
	}
	
	
	@Override
	public boolean checkUserLogin(Users users) {
		boolean validuser = false;
		Session session = SessionFactory.getCurrentSession();
		String username = users.getUsername();
		String password = users.getPassword();
		Query query = session.createQuery("Select username from Users where username= '"+username+"' and password= '"+password+"' and role = 'user' ");
		
		try{
			List list = query.list();
			if ((list != null) && (list.size() == 1)) {
				validuser= true;
			}
			}
			catch(Exception ex){
				return validuser;
			}
		session.flush();
		
		
		return validuser;
	}
}

	
