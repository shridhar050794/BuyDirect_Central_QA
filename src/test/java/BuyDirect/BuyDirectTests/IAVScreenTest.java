package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.BankingIntroScreenClass;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import BuyDirect.PageobjectClass.IAVScreenClass;
import BuyDirect.PageobjectClass.PlasticScreenClass;
import TestComponents.TestUtils;

public class IAVScreenTest extends TestUtils {
	static BankingIntroScreenClass bankclass;
	static IAVScreenClass iavclass;
	@Test
	public void IAVtest() throws InterruptedException, IOException, ParseException {
	//	driver= browserInvoke();
	
		//WelcomePageClass welcome = launchApp();
		//WelcomePageClass wc =new WelcomePageClass(driver);
		EnrollScreenClass es =welcome.submitEnrollScreen();
		//EnrollScreenClass es = new EnrollScreenClass(driver);
		String DLrequired = DLRequired();
		sendDataToEnrollScreen();
		System.out.println("Dlrequired   "+DLrequired);
		//es.plasticScreen();
		//PlasticScreenClass plastic = es.submitEnroll();
		
		//BankingIntroScreenClass bank  = plastic.submitPlastic();
		
	//	BankingIntroScreenClass intro = new BankingIntroScreenClass(driver);
		String plasticValue =plasticAbilityQuery();
		System.out.println("Plastic Value   "+plasticValue);
		String bankIntroValue = bankInroQuery();
		System.out.println("BankIntro Value   "+bankIntroValue);
		if(plasticValue.equalsIgnoreCase("3")||plasticValue.equalsIgnoreCase("2") ) {
			
			if(bankIntroValue.equalsIgnoreCase("1")) 
			{
				PlasticScreenClass plastic = es.submitEnroll();
				bankclass  = plastic.submitPlastic();
				iavclass = bankclass.submitIntroScreenToIAV();
				Assert.assertEquals(iavclass.iavHeader.getText(), "Link Your Bank Account");
			}
			else {
				iavclass = es.continueWithoutIntroScreen();
				Assert.assertEquals(iavclass.iavHeader.getText(), "Link Your Bank Account");
			}
			
		}
		if(plasticValue.equalsIgnoreCase("0")||plasticValue.equalsIgnoreCase("1")) {
			
			if(bankIntroValue.equalsIgnoreCase("1")) 
			{
				bankclass  = es.continueWithoutPlasticScreen();
				iavclass = bankclass.submitIntroScreenToIAV();
				Assert.assertEquals(iavclass.iavHeader.getText(), "Link Your Bank Account");
			}
			else {
				iavclass = es.continueWithoutIntroScreen();
			}
		}
		//iavclass.AcctverifyBankingProcess();
	
		//iavclass.IavMain();
		
		
	}
	
}
