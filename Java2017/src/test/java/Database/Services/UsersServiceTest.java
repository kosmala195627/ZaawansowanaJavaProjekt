package Database.Services;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import Database.Models.User;



@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {

	UsersService userService;
	
    @Before
    public void setUp() {
    	userService = new UsersService();
    } 
	
	@Test
	public void testGetAllUsers(User[] tab) {
		fail("Not yet implemented");
	}

}