package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.BankingIntroScreenClass;
import BuyDirect.PageobjectClass.CDWScreenClass;
import BuyDirect.PageobjectClass.DepositScreenClass;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import BuyDirect.PageobjectClass.LoginScreenClass;
import BuyDirect.PageobjectClass.PlasticScreenClass;
import BuyDirect.PageobjectClass.WelcomeBackPageClass;
import TestComponents.TestUtils;

public class DepositScreenTest extends TestUtils {

	@Test
	public void depositTest() throws InterruptedException, IOException, ParseException {
		//driver= browserInvoke();
		//WelcomePageClass welcome = launchApp();
		EnrollScreenClass es =welcome.submitEnrollScreen();
		//EnrollScreenClass es = new EnrollScreenClass(driver);
		String DLrequired = DLRequired();
		sendDataToEnrollScreen();
		System.out.println("Dlrequired   "+DLrequired);
		//es.plasticScreen();
		PlasticScreenClass plastic = es.submitEnroll();
		
		BankingIntroScreenClass bank  = plastic.submitPlastic();
		
	//	BankingIntroScreenClass intro = new BankingIntroScreenClass(driver);
		
		CDWScreenClass cdwclass = bank.submitIntroScreenToCDW();
		//Assert.assertEquals(cdwclass.routingLabel.getText(), "Routing Number");
		
		//cdwclass.routingbox.sendKeys("121000358");
		//cdwclass.accountbox.sendKeys("2423140677");
		cdwclass.submitCDW();
		//sign back 
		LoginScreenClass loginclass =welcome.signIn();
		
		WelcomeBackPageClass welcomebackclass =loginclass.login();
		
		DepositScreenClass depositclass=welcomebackclass.submitWelcome();
		Assert.assertTrue(depositclass.depositBody.getText().contains("Enter Deposit"));
		//depositclass.submitDeposit();
	}
}
