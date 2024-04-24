package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BuyDirect.AbstractComponent.AbstractComponents;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import TestComponents.TestUtils;

public class EnrollScreenTest extends TestUtils{
	public EnrollScreenClass enrollclass;
	static String DLrequired;
	
	
	public void initializeEnrollTest() throws InterruptedException, IOException {
		enrollclass =welcome.submitEnrollScreen();
		String[] column= {"IsDLrequired"};
		DLrequired = queryExecutionMethodForMultipleDataInColumns(testhelper.dLFlag_Query,column).get(0);
		sendDataToEnrollScreen();
	}
	
	@Test
	public void verify_Input() throws InterruptedException, IOException {
		initializeEnrollTest();
		if(DLrequired.equalsIgnoreCase("1")) {
			
			Assert.assertTrue(enrollclass.Dlstateheader.isDisplayed());
			Assert.assertTrue(enrollclass.Dlstateheader.getText().equalsIgnoreCase("State Issued"));
			}
		else{
			Assert.assertTrue(true);
		}
		
	}
		
	@Test
	public void partner_Logo_Name_Footer_Test() throws IOException, InterruptedException 
		{
			String[] column ={"Tender_Name_header"};
			
		    initializeEnrollTest();
		    PartnerPropertiesTest();
		    
		    List<String> res = queryExecutionMethodForMultipleDataInColumns(testhelper.partnerName_Query,column );
		    Assert.assertEquals(enrollclass.partnerName.getText(),res.get(0));
		    Assert.assertEquals(enrollclass.partnerFooter.getText(), requiredFooter);
		    Assert.assertEquals(imageorLinkStatus(imagelink), 200, "Image Is Broken");
		   
		}
	
	@Test
	public void verify_Enroll_Header() throws InterruptedException, IOException {
		initializeEnrollTest();
		Assert.assertTrue(enrollclass.enrollHeader.getText().contains("Enroll"));
	}

	@Test
	public void check_FirstName_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		ClearElementInputAndScroll(enrollclass.firstname);
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredFirstName.getText(),"Required");
	}
		
	@Test
	public void check_LasttName_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		ClearElementInputAndScroll(enrollclass.lastname);
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredLastName.getText(),"Required");
	}
	
	@Test
	public void check_Phone_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		ClearElementInputAndScroll(enrollclass.partnerPhone);
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredPhone.getText(),"Required");
	}
	@Test
	public void check_Email_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		ClearElementInputAndScroll(enrollclass.email);
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredEmail.getText(),"Required");
	}
	
	@Test
	public void check_StreetAddress_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		ClearElementInputAndScroll(enrollclass.street);
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredStreet.getText(),"Required");
	}
	
	@Test
	public void check_City_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		ClearElementInputAndScroll(enrollclass.city);
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredCity.getText(),"Required");
	}
	
	@Test
	public void check_state_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		//ClearElementInputAndScroll(enrollclass.state);
		//enrollclass.btnEnroll.click();
		enrollclass.validationOfState();
		Assert.assertEquals(enrollclass.requiredState.getText(),"Required");
	}
	
	@Test
	public void check_Zip_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		ClearElementInputAndScroll(enrollclass.zip);
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredZip.getText(),"Required");
	}
	
	@Test
	public void check_DOB_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		enrollclass.validationOfDOB(enrollclass.dateofbirth);
		Assert.assertEquals(enrollclass.requiredDOB.getText(),"Required");
	}
	
	@Test
	public void check_PIN_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		enrollclass.ElementValidationCheck(enrollclass.Createpin);
		Assert.assertEquals(enrollclass.requiredPIN.getText(),"Required");
	}
	
	@Test
	public void check_Term_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		enrollclass.term.click();
		enrollclass.btnEnroll.click();
		Assert.assertEquals(enrollclass.requiredTerm.getText(),"Please Select Terms and Conditions");
	}
	
	@Test
	public void check_IDStateAndNumber_Mandatory() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		sendDataToEnrollScreen();
		if(DLrequired=="1") {
		enrollclass.validationOfIDStateAndNumber();
		Assert.assertEquals(enrollclass.requiredIdState.getText(),"Required");
		Assert.assertEquals(enrollclass.requiredIDNumber.getText(),"Required");
		}
		else {System.out.println("The DL fields are disabled");}
	}
	
	@Test
	public void check_SignInLink() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		//sendDataToEnrollScreen(DLrequired);
		//if(DLrequired=="1") {
		//enrollclass.validationOfIDStateAndNumber();
		Assert.assertTrue(enrollclass.signInLink.isDisplayed());
		Assert.assertEquals(enrollclass.signInLink.getText(),"sign in here");
		}
	
	@Test
	public void check_PartnerPhoneNumber() throws InterruptedException, IOException {
		//enrollclass =welcome.enrollScreen();
		initializeEnrollTest();
		//sendDataToEnrollScreen(DLrequired);
		//if(DLrequired=="1") {
		//enrollclass.validationOfIDStateAndNumber();
		String query = "select Partner_Contact_Number from Partner_Profile where partner_ID="+partner+"";
		String partnerPhone=queryExecutionMethod(query);
		Assert.assertTrue(enrollclass.PartnerPhoneNumber.isDisplayed());
		Assert.assertEquals(enrollclass.PartnerPhoneNumber.getText(),partnerPhone);
		}
	@Test
	public void check_TermLink() throws InterruptedException, IOException {
		
		initializeEnrollTest();
		
		Assert.assertTrue(enrollclass.TermsLink.isDisplayed());
		
		Assert.assertTrue(enrollclass.termsLinkTab().contains(partner) );
		}
	
	@Test
	public void check_NotificationLink() throws InterruptedException, IOException {
		
		initializeEnrollTest();
		Assert.assertTrue(enrollclass.NotificationLink.isDisplayed());
		Assert.assertTrue(enrollclass.notificatoinLinkTab().contains(partner+"#text-notification"));
		}
	
	@Test
	public void check_TermsTextClick_Ability() throws InterruptedException, IOException {
		
		initializeEnrollTest();
		
		Assert.assertTrue(enrollclass.termText.isDisplayed());
		enrollclass.termText.click();
		Assert.assertTrue(enrollclass.term.isSelected());
		}
	
	@Test
	public void verify_Continue_Buttton() throws InterruptedException, IOException, ParseException {
		initializeEnrollTest();
		Assert.assertEquals(enrollclass.btnEnroll.getText(), "Continue");	
		Assert.assertTrue(enrollclass.btnEnroll.isDisplayed());
		Assert.assertTrue(enrollclass.btnEnroll.isEnabled());
		sendDataToEnrollScreen();
		enrollclass.click_Button_functionality() ;
		Assert.assertTrue(AbstractComponents.paceLoaderActive.isDisplayed());//check Continue button is Clicked
	}
}




