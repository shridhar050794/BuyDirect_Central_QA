package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class WelcomeBackPageClass extends AbstractComponents {
	WebDriver driver;
	public WelcomeBackPageClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
@FindBy(css="h2[id='headerWelcome']")
public WebElement welcomeHeader;

@FindBy(xpath="//p[@class='zulu-custom-font']")
public WebElement welcomeBody;

@FindBy(xpath="//button[@id='btnContinue']")
public WebElement welcomeContinueButton;


public DepositScreenClass submitWelcome() throws InterruptedException {
	welcomeContinueButton.click();
	//Thread.sleep(8000);
	waitImplicit();
	DepositScreenClass depositclass =new DepositScreenClass(driver);
	return depositclass;
	
}
}
