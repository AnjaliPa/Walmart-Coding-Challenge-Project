package com.replenishment.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.replenishment.dao.TaskDao;
import com.replenishment.model.StatusMatrix;
import com.replenishment.model.Task;
import com.replenishment.model.TaskAssign;
import com.replenishment.model.Users;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {

	private static final Logger logger = Logger.getLogger(TaskDaoImpl.class);

	@Autowired
	private SessionFactory SessionFactory;

	/* Add new task in database */
	@Override
	public int addTask(Task task) {
		Session session = SessionFactory.getCurrentSession();
		int key = (int) session.save(task);
		session.flush();
		return key;

	}

	/* Add Status action matrix */
	@Override
	public void addStatusMatrix(StatusMatrix statusMatrix) {
		Session session = SessionFactory.getCurrentSession();
		int key = (int) session.save(statusMatrix);
		session.flush();

	}

	/* Get all tasks */
	@Override
	public List<Task> getAllTask(Users users) {
		Query query;
		Session session = SessionFactory.getCurrentSession();
		if (users.getUsername().equals("admin"))
			query = session.createQuery("From Task");
		else
			query = session.createQuery("From Task where  username = '" + users.getUsername() + "' ");
		List<Task> tasks = query.list();
		return tasks;
	}

	/* Get individual task */
	@Override
	public Task getTaskById(int id) {
		Session session = SessionFactory.getCurrentSession();
		Task task = (Task) session.get(Task.class, id);
		session.flush();
		return task;
	}

	/* Add assigned task */
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

	/* Check validation for admin login */
	@Override
	public boolean checkAdminLogin(Users users) {
		boolean validuser = false;
		Session session = SessionFactory.getCurrentSession();
		String username = users.getUsername();
		String password = users.getPassword();
		Query query = session.createQuery("Select username from Users where username= '" + username
				+ "' and password= '" + password + "' and role = 'admin' ");

		try {
			List list = query.list();
			if ((list != null) && (list.size() == 1)) {
				validuser = true;
			}
		} catch (Exception ex) {
			return validuser;
		}
		session.flush();

		return validuser;
	}

	/* Check validation for user login */
	@Override
	public boolean checkUserLogin(Users users) {
		boolean validuser = false;
		Session session = SessionFactory.getCurrentSession();
		String username = users.getUsername();
		String password = users.getPassword();
		Query query = session.createQuery("Select username from Users where username= '" + username
				+ "' and password= '" + password + "' and role = 'user' ");

		try {
			List list = query.list();
			if ((list != null) && (list.size() == 1)) {
				validuser = true;
			}
		} catch (Exception ex) {
			return validuser;
		}
		session.flush();

		return validuser;
	}

	/* Get all pending task for admin */
	@Override
	public List<TaskAssign> getAllPendingTask(Users user) {

		Query query;
		Session session = SessionFactory.getCurrentSession();
		if (user.getUsername().equals("admin"))
			query = session.createQuery("From TaskAssign where  taskStatus = 'pending'");
		else
			query = session.createQuery("From TaskAssign where  taskAssignTo = '" + user.getUsername() + "'");
		logger.info(query);
		List<TaskAssign> TaskAssigns = query.list();
		return TaskAssigns;

	}

	/* get all assigned task to individual */
	@Override
	public List<Task> getAllAssignedUserTask(Users users) {
		Query query;
		Session session = SessionFactory.getCurrentSession();
		query = session.createQuery("From Task where   username = '" + users.getUsername() + "' ");
		System.out.println(query);
		List<Task> Tasks = query.list();
		return Tasks;

	}

	
	/* Adding new user in the database */
	@Override
	public void addUser(Users user) {

		Session session = SessionFactory.getCurrentSession();
		session.save(user);
		session.flush();

	}

}
