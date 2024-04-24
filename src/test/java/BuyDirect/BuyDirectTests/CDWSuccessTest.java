package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.BankingIntroScreenClass;
import BuyDirect.PageobjectClass.CDWScreenClass;
import BuyDirect.PageobjectClass.CDWSuccessScreenClass;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import BuyDirect.PageobjectClass.PlasticScreenClass;
import TestComponents.TestUtils;

public class CDWSuccessTest extends TestUtils {
	
	@Test
	public void cdwScreen() throws InterruptedException, IOException, ParseException {
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
		//Assert.assertEquals(cdwclass.routingLabel.getText(), "Routing Number");
		//send inputs to account and routing number
		cdwclass.routingbox.sendKeys("042000314");
		cdwclass.accountbox.sendKeys("435677777");
		CDWSuccessScreenClass cdwSuccess = cdwclass.submitCDW();
		
		Assert.assertTrue(cdwSuccess.cdwSuccessBody.getText().contains("small deposit and withdrawal"));
		//cdwSuccess.refreshCDWSuccess();
		
		
	}

}
