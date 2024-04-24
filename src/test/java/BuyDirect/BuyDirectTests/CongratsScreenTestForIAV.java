package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.PageobjectClass.BankingIntroScreenClass;
import BuyDirect.PageobjectClass.CongratsScreenClass;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import BuyDirect.PageobjectClass.IAVScreenClass;
import BuyDirect.PageobjectClass.PlasticScreenClass;
import TestComponents.TestUtils;

public class CongratsScreenTestForIAV extends TestUtils {
	static BankingIntroScreenClass bankclass;
	static IAVScreenClass iavclass;
	@Test
	public void congratsTest() throws InterruptedException, IOException, ParseException {
		//driver= browserInvoke();
		
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
		
		//IAVScreenClass iavclass = bank.submitIntroScreenToIAV();
	
		//Assert.assertEquals(iavclass.iavHeader.getText(), "Link Your Bank Account");
		//get the IAV frame link text to check whether it is a plaid or Actverift
		String iavframe=iavclass.mainIAVFrame.getAttribute("src");
		System.out.println(iavframe);
		if(iavframe.contains("iavred")) {
		iavclass.PlaidBankingProcess();
		}
		else {
			iavclass.AcctverifyBankingProcess();
		}
		CongratsScreenClass congratsclass= new CongratsScreenClass(driver);
		
		Assert.assertEquals(congratsclass.confirmationHeader.getText(),"Confirmation");
		System.out.println(congratsclass.confirmationBody.getText());
		Assert.assertTrue(congratsclass.confirmationBody.getText().contains("CONGRATULATIONS on your enrollment"));
		
	}
}
