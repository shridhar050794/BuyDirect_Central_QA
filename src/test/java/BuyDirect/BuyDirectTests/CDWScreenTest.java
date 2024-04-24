package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.BankingIntroScreenClass;
import BuyDirect.PageobjectClass.CDWScreenClass;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import BuyDirect.PageobjectClass.PlasticScreenClass;
import TestComponents.TestUtils;

public class CDWScreenTest extends TestUtils {
	
	@Test
	public void validation() throws InterruptedException, IOException, ParseException {
		//driver= browserInvoke();
	
		//WelcomePageClass welcome = launchApp();
		//WelcomePageClass wc =new WelcomePageClass(driver);
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
		Assert.assertEquals(cdwclass.routingLabel.getText(), "Routing Number");
		Assert.assertTrue(cdwclass.cdwBody.getText().contains("enter your routing and account numbers"));
		
		
	}

}
