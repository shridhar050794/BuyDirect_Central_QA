package BuyDirect.BuyDirectTests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.LoginScreenClass;
import BuyDirect.PageobjectClass.WelcomeBackPageClass;
import TestComponents.TestUtils;

public class WelcomeBackScreenTest extends TestUtils {
	
	@Test
	public void welcomeBack() throws InterruptedException, IOException {
		//driver= browserInvoke();
		
		//WelcomePageClass welcome = launchApp();
		LoginScreenClass loginclass =welcome.signIn();
		//Assert.assertEquals(loginclass.signinHeader.getText() ,"Sign In");
		WelcomeBackPageClass welcomebackclass =loginclass.login();
		Assert.assertEquals(welcomebackclass.welcomeHeader.getText() ,"Welcome Back");
		welcomebackclass.submitWelcome();
		
	}

}
