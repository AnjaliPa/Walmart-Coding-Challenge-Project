
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.junit.Assert.*;

import java.util.List;

import com.replenishment.controller.HomeController;
import com.replenishment.dao.TaskDao;
import com.replenishment.daoImpl.TaskDaoImpl;
import com.replenishment.model.Task;
import com.replenishment.model.TaskAssign;
import com.replenishment.model.Users;

import org.apache.log4j.Logger;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml",
					   "file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class UserControllerTest{
	private static final Logger logger =  Logger.getLogger(UserControllerTest.class);

	@Autowired
	private  TaskDao taskDao;
	
	
	/*Get all assigned task list  of individual user*/
	@Test
	@Transactional
	public void testAllAssignTo()
	{
	List<TaskAssign> taskList = taskDao.getAllAssignTo();
	assertTrue("Get all assigned task list  of individual user",taskList.size()>0);
	}

	/*Add New Task in Database*/
	@Transactional
	@Test
	public void testAddSingleTask() {
		Task task = new Task();
		HomeController home = new HomeController();
		task.setTaskName("TestJunit");
		task.setTaskPriority("high");
		task.setUsername("junituser");
		task.setTaskDescription("Junit task are performed");
		task.setUsername("anjali");
		int key = taskDao.addTask(task);
		Task task2 = taskDao.getTaskById(key);
		assertNotNull("Task Found by ID "+task2);  

		Assert.assertEquals("Task has been created",task.getTaskName(),task2.getTaskName());
	}
	
	
	
	
	
	
}