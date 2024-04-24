package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.AbstractComponent.AbstractComponents;
import BuyDirect.PageobjectClass.LoginScreenClass;
import BuyDirect.Utilities.TestHelper;
import TestComponents.TestUtils;

public class WelcomePageTest extends TestUtils {
	static WebDriver driver;
	//static WelcomePageClass welcome;
	//static String imagelink;
	
	@Test
	public void verify_Welcome_Page_Body_Texts() throws IOException {
		testhelper = new TestHelper();
		String[] columns = {"WelcomeMessage"};
		List<String> requiredtext=db_Value_Extractor(testhelper.welcomebody_Query,columns);
		String atualBody = requiredtext.get(0);
		String expectedBody= welcome.welcomeBody.getText().replaceAll("\\n", "");
		Assert.assertEquals(atualBody,expectedBody );
		
		Assert.assertEquals(welcome.signininfo.getText(), "To continue enrolling, sign in here");
		
	
		
	}
	

	@Test
	public void signInLink() throws InterruptedException, IOException 
	{
	//driver= browserInvoke();
	
	//welcome = launchApp();
	LoginScreenClass loginclass =welcome.signIn();
	Assert.assertEquals(loginclass.signinHeader.getText() ,"Sign In");
	} 
	
	@Test
	public void partnerLogo_ImageAndName_Test() throws IOException 
	{			
				PartnerPropertiesTest();
			    Assert.assertEquals(welcome.partnerName.getText(),queryExecutionMethod(testhelper.partnerName_Query));
			    Assert.assertEquals(welcome.partnerFooter.getText(), requiredFooter);
			    Assert.assertEquals(imageorLinkStatus(imagelink), 200, "Image Is Broken");
			   
			
	}
	@Test
	public void verify_Continue_Buttton() throws InterruptedException, IOException, ParseException {
		Assert.assertEquals(welcome.startbutton.getText(), "Get Started");	
		Assert.assertTrue(welcome.startbutton.isDisplayed());
		Assert.assertTrue(welcome.startbutton.isEnabled());
		
		
	}
}
