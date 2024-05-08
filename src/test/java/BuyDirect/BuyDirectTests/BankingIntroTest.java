package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.BankingIntroScreenClass;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import BuyDirect.PageobjectClass.PlasticScreenClass;
import TestComponents.TestUtils;

public class BankingIntroTest extends TestUtils {
	static BankingIntroScreenClass bankclass;
	
	public void validation() throws InterruptedException, IOException, ParseException {
	
		EnrollScreenClass es =welcome.submitEnrollScreen();
		
		String DLrequired = DLRequired();
		
		sendDataToEnrollScreen();
		
		String plasticValue =plasticAbilityQuery();
		if(plasticValue.equalsIgnoreCase("3")||plasticValue.equalsIgnoreCase("2") ) {
			PlasticScreenClass plastic = es.submitEnroll();
			bankclass  = plastic.submitPlastic();
		}
		else {
			bankclass  = es.continueWithoutPlasticScreen();
			
		}
	
		
	}
	@Test
	public void page_title() throws InterruptedException, IOException, ParseException {
		PlasticScreenTest plasticScreenobject = new PlasticScreenTest();
		plasticScreenobject.PlasticScreen_Entry();
		BankingIntroTest testobject = new BankingIntroTest();
		testobject.validation();
		String actualTitle=bankclass.introHeader.getText();
		String expectedTitle="Connect your account";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
		

}
