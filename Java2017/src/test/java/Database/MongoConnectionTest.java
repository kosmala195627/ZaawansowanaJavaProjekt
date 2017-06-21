package Database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.mongodb.DBCollection;

public class MongoConnectionTest {
	
	@Mock
	MongoConnection mongoConnection;
	@Mock 
	DBCollection usersCollection;
	@Mock 
	DBCollection projectsCollection;
	@Mock 
	DBCollection tasksCollection;
	@Mock 
	DBCollection tasksUsersCollection;
	
	
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
	
/*
	@Test
	public void testMongoConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadProjects() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadTasks() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadTasksUsers() {
		fail("Not yet implemented");
	}
*//*
	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}*/
/*
	@Test
	public void testInsertProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTaskUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateInDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFromDB() {
		fail("Not yet implemented");
	}*/

}
