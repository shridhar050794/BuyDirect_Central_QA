package BuyDirect.BuyDirectTests;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BuyDirect.AbstractComponent.AbstractComponents;
import BuyDirect.PageobjectClass.BankingIntroScreenClass;
import BuyDirect.PageobjectClass.PlasticScreenClass;
import BuyDirect.Utilities.TestHelper;
import TestComponents.TestUtils;

public class PlasticScreenTest extends TestUtils {
	//WebDriver driver;
	static BankingIntroScreenClass bankclass;
	static PlasticScreenClass plastic ;
	static TestHelper testhelper;
	static String plasticValue;
	//String DLrequired;
	//EnrollScreenClass enrollclass ;
	
	public void initializeEnrollTest() {
		enrollclass =welcome.submitEnrollScreen();
		testhelper = new TestHelper();
		plasticValue = plasticAbilityQuery();
		
	}
	@Test
	public void PlasticScreen_Entry() throws InterruptedException, IOException, ParseException {
		initializeEnrollTest();
		sendDataToEnrollScreen();
		
		if(plasticValue.equalsIgnoreCase("3")||plasticValue.equalsIgnoreCase("2") ) {
			plastic = enrollclass.submitEnroll();
			Assert.assertEquals(plastic.plasticHeader.getText(), "Plastic");
			
		}
		else {
			bankclass  = enrollclass.continueWithoutPlasticScreen();
			
		}
		
		
	}
	@Test
	public void partner_Logo_Name_Footer_Test() throws IOException, InterruptedException, ParseException 
		{
			
			PlasticScreen_Entry();
		    PartnerPropertiesTest();
		    Assert.assertEquals(plastic.partnerName.getText(),queryExecutionMethod(testhelper.partnerName_Query));
		    Assert.assertEquals(plastic.partnerFooter.getText(), requiredFooter);
		    Assert.assertEquals(imageorLinkStatus(imagelink), 200, "Image Is Broken");
		   
		}
	@Test
	public void verify_plasticHeader() throws InterruptedException, IOException, ParseException {
		PlasticScreen_Entry();
		Assert.assertEquals(plastic.plasticHeader.getText(),"Plastic");
	
	}
	@Test
	public void verify_plastic_SubTitle_Text() throws InterruptedException, IOException, ParseException {
		PlasticScreen_Entry();
		//String query = "select Plastics_Page_Subtitle from Partner_BuyDirect_Settings where partner_ID="+partner+"";
		String[] column= {"Plastics_Page_Subtitle"};
		Assert.assertEquals(plastic.plasticSubtitle.getText(),queryExecutionMethodForMultipleDataInColumns(testhelper.plastic_Subtitle_query,column).get(0));
	}
	
	@Test
	public void verify_default_Plastic_RadioButton() throws InterruptedException, IOException, ParseException {
		PlasticScreen_Entry();
		Assert.assertTrue(plastic.noButton.isEnabled());
		Assert.assertTrue(plastic.yesButton.isEnabled());
		Assert.assertTrue(plastic.noButton.isSelected());
		Assert.assertFalse(plastic.yesButton.isSelected());
	}
	
	
	@Test
	public void verify_RadionButtons_Clickable() throws InterruptedException, IOException, ParseException {
		PlasticScreen_Entry();
		Assert.assertTrue(plastic.noButton.isSelected());
		plastic.selectPlasticAbility();
		Assert.assertTrue(plastic.yesButton.isSelected());
		
	}
	
	@Test
	public void verify_Plastic_Body_Texts() throws InterruptedException, IOException, ParseException {
		PlasticScreen_Entry();
		//TestHelper testhelper = new TestHelper();
		//String name1="plasticBodyMain";
		//String name2="plasticBodySub";
		String[] column = {"plasticBodyMain","plasticBodySub"};
		List<String> plasticBody =  queryExecutionMethodForMultipleDataInColumns(testhelper.plasticProperties_Query,column);
		Assert.assertEquals(plastic.plasticMainBody.getText(),plasticBody.get(0).trim());
		Assert.assertEquals(plastic.plasticSubBody.getText(), plasticBody.get(1).trim());
		
	}
	
	@Test
	public void verify_Continue_Buttton() throws InterruptedException, IOException, ParseException {
		PlasticScreen_Entry();
		Assert.assertTrue(plastic.plasticSubmitButton.isDisplayed());
		Assert.assertTrue(plastic.plasticSubmitButton.isEnabled());//checking the clickability of the button
		plastic.click_Plastic_Continue() ;
		Assert.assertTrue(AbstractComponents.paceLoaderActive.isDisplayed());//check Continue button is Clicked
	}
}
