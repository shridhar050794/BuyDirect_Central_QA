package BuyDirect.BuyDirectTests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.LoginScreenClass;
import TestComponents.TestUtils;

public class LoginScreenTest extends TestUtils{
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		//driver= browserInvoke();
		
		//WelcomePageClass welcome = launchApp();
		LoginScreenClass loginclass =welcome.signIn();
		
		
		Assert.assertEquals(loginclass.signinHeader.getText() ,"Sign In");
		 
		
		
		
	}

}
