package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class CDWScreenClass extends AbstractComponents {
	WebDriver driver;
	public CDWScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath ="//label[contains(text(),'Routing')]")
public WebElement routingLabel;

@FindBy(xpath ="//input[@placeholder='Routing Number']")
public WebElement routingbox;

@FindBy(xpath ="//input[@placeholder='Account Number']")
public  WebElement accountbox;

@FindBy(xpath ="//button[@id='btnCDW']")
public WebElement submitCDW;

@FindBy(xpath ="//p[contains(text(),'enter your routing and account numbers')]")
public WebElement cdwBody;


public CDWSuccessScreenClass submitCDW() throws InterruptedException {
	//routingbox.sendKeys("121000358");
	//accountbox.sendKeys("2423140677");
	Thread.sleep(4000);
	
	scrollToBottom();
	waitForWebElementToClickable(submitCDW);
	submitCDW.click();
	Thread.sleep(10000);
	//waitForWebElementToDisAppear(routingLabel);
	
	driver.navigate().refresh();
	CDWSuccessScreenClass cdwsuccess = new CDWSuccessScreenClass(driver);
	return cdwsuccess;
}

}
