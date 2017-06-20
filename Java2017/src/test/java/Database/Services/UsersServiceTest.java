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
	public void testGetAllUsers() {
		User a1 = new User("Jan","Kowalski","jkowalski","$2a$10$6BhnrXJtEqAh13afhtWedeU4mxtWaxcyebQbbsnxJKxPPiWuV.IMW");
		User a2 = new User("Karol","Bednarek","kbednarek","$2a$10$6BhnrXJtEqAh13afhtWedeU4mxtWaxcyebQbbsnxJKxPPiWuV.IMW");
		User a3 = new User("Karol","Kłos","kk","$2a$10$6BhnrXJtEqAh13afhtWedeU4mxtWaxcyebQbbsnxJKxPPiWuV.IMW");
		
		User[] users = {a1,a2,a3};
		String[] expected = {"Jan Kowalski","Karol Bednarek", "Karol Kłos"};
		
		String[] result = {};	
		result = userService.getAllUsers(users);	
		Assert.assertArrayEquals("Lista użytkowników niepoprawna", expected, result);
	}

}