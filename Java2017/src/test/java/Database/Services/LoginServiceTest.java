package Database.Services;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
		
	LoginService loginService;
	
    @Before
    public void setUp() {
    	loginService = new LoginService();
    } 
	
	@Test
	public void testGetUserByLogin() {
		Assert.assertEquals("Atrybut login nie może być nullem",null,loginService.getUserByLogin(null));
		Assert.assertEquals("Atrybut login nie może być pustym stringiem",null,loginService.getUserByLogin(null));		
	}

}
