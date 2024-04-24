package BuyDirect.BuyDirectTests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.CongratsScreenClass;
import BuyDirect.PageobjectClass.DepositScreenClass;
import BuyDirect.PageobjectClass.LoginScreenClass;
import BuyDirect.PageobjectClass.WelcomeBackPageClass;
import TestComponents.TestUtils;

public class CongratsScreenTest extends TestUtils {

	@Test
	public void congratsTest() throws InterruptedException, IOException {
		//driver= browserInvoke();
		//WelcomePageClass welcome = launchApp();
		LoginScreenClass loginclass =welcome.signIn();
		
		WelcomeBackPageClass welcomebackclass =loginclass.login();
		
		DepositScreenClass depositclass=welcomebackclass.submitWelcome();
		CongratsScreenClass congratsclass=depositclass.submitDeposit();
		Assert.assertEquals(congratsclass.confirmationHeader.getText(),"Confirmation");
		Assert.assertTrue(congratsclass.confirmationHeader.getText().contains("CONGRATULATIONS on your enrollment"));
	}
}
