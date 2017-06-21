package Database;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import Database.Models.Project;
import Database.Models.Task;
import Database.Models.TaskUser;
import Database.Models.User;
import Database.Services.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class JSONTesterTest {
	
	static JSONTester jsonTester;
	
	@BeforeClass
	public static void init()
	{
		jsonTester = new JSONTester();
	}

	@Before
	public void setUp() {
		Collections.usersList.clear();
		Collections.projectsList.clear();
		Collections.tasksList.clear();
		Collections.tasksUsersList.clear();
	} 

	@After
	public void clean()
	{
		Collections.usersList.clear();
		Collections.projectsList.clear();
		Collections.tasksList.clear();
		Collections.tasksUsersList.clear();
	}
	
	@Test
	public void testReadUsersJSON() {
		String jsonString = "{\"_id\":{\"$oid\":\"593a6efe243f7fea11a98fc8\"},\"firstName\":\"user\",\"lastName\":\"user\",\"login\":\"user\",\"password\":\"$2a$10$6BhnrXJtEqAh13afhtWedeU4mxtWaxcyebQbbsnxJKxPPiWuV.IMW\"}";		
		User expected = new User("user","user","user","$2a$10$6BhnrXJtEqAh13afhtWedeU4mxtWaxcyebQbbsnxJKxPPiWuV.IMW");
		User result = new User("","","","");

		try{
		result = jsonTester.readUsersJSON(jsonString);
		}
		catch(Exception e)
		{
			fail("Exception raised - testReadUsersJSON : " + e.getMessage());	
		}
		assertEquals("Wrong first name",expected.getFirstName(), result.getFirstName());
		assertEquals("Wrong last name",expected.getLastName(), result.getLastName());
		assertEquals("Wrong login",expected.getLogin(), result.getLogin());
		assertEquals("Wrong password",expected.getPassword(), result.getPassword());
	}

	@Test
	public void testReadProjectsJSON() {
		String jsonString = "{\"_id\":{\"$oid\":\"59402ae3a2785ddfa4a6685d\"},\"name\":\"Projekt z Javy\",\"leaderId\":\"593a6e8e243f7fea11a98fc5\"}";
		Project expected = new Project("Projekt z Javy","593a6e8e243f7fea11a98fc5");
		Project result = new Project("","");
		try{
		result = jsonTester.readProjectsJSON(jsonString);
		}
		catch(Exception e)
		{
			fail("Exception raised - testReadProjectsJSON : " + e.getMessage());	
		}
		assertEquals("Wrong project name",expected.getName(), result.getName());
		assertEquals("Wrong leader id",expected.getLeaderId(), result.getLeaderId());
	}

	@Test
	public void testReadTasksJSON() {
		String jsonString = "{\"_id\":{\"$oid\":\"5940344a085a24a1d0a61291\"},\"name\":\"Pierwszy Task\",\"startDate\":\"2017-03-05\",\"endDate\":\"2017-06-21\",\"projectId\":\"59402ae3a2785ddfa4a6685d\",\"managerId\":\"593a6de1243f7fea11a98fc4\",\"status\":\"false\"}";		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateStart = new Date();
		Date dateEnd = new Date();
		try {
			dateStart = formatter.parse("2017-03-05");
			dateEnd = formatter.parse("2017-06-21");
		} catch (ParseException e) {
			fail("Exception raised - testReadTasksJSON : " + e.getMessage());
		}

		Task expected = new Task("Pierwszy Task",dateStart,dateEnd,"59402ae3a2785ddfa4a6685d","593a6de1243f7fea11a98fc4");
		Task result = new Task("",new Date(),new Date(),"","");

		try{
		result = jsonTester.readTasksJSON(jsonString);
		}
		catch(Exception e)
		{
			fail("Exception raised - testReadUsersJSON : " + e.getMessage());	
		}
		System.out.println(result);
		assertEquals("Wrong task name",expected.getName(), result.getName());
		assertEquals("Wrong start date",expected.getStartDate(), result.getStartDate());
		assertEquals("Wrong end date",expected.getEndDate(), result.getEndDate());
		assertEquals("Wrong project id",expected.getProjectId(), result.getProjectId());
		assertEquals("Wrong manager id",expected.getManagerId(), result.getManagerId());
		assertEquals("Wrong status",expected.getStatus(), result.getStatus());
	}

	@Test
	public void testReadTasksUsersJSON() {
		String jsonString = "{\"_id\":{\"$oid\":\"59450623f3c38193a86811c6\"},\"userId\":\"593a6de1243f7fea11a98fc4\",\"taskId\":\"5940344a085a24a1d0a61291\"}";		
		TaskUser expected = new TaskUser("593a6de1243f7fea11a98fc4","5940344a085a24a1d0a61291");
		TaskUser result = new TaskUser("","");

		try{
		result = jsonTester.readTasksUsersJSON(jsonString);
		}
		catch(Exception e)
		{
			fail("Exception raised - testReadUsersJSON : " + e.getMessage());	
		}
		assertEquals("Wrong first name",expected.getTaskId(), result.getTaskId());
		assertEquals("Wrong last name",expected.getUserId(), result.getUserId());
	}

}
