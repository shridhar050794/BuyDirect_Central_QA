package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class WelcomePageClass extends AbstractComponents{
	
	WebDriver driver;
	
	//WelcomePageClass WelcomePageClass;
	public WelcomePageClass(WebDriver driver) {
		super(driver);
		 this.driver=driver;
		 //page factory
		 PageFactory.initElements(driver,this);
		
	}


@FindBy(css="h2[id='headerWelcomeStart']")
 public WebElement pageLabel;

@FindBy(id="btnGetStarted")
public  WebElement startbutton;

@FindBy(xpath="(//a[contains(text(),'Click Here to continue where you left off')])[2]")
 public WebElement signinLink;


@FindBy(id="dynamic-welcome-message")
public WebElement welcomeBody;

@FindBy(xpath="(//p[@class='text-muted mb-0'])[2]")
public WebElement signininfo;


public void goTo(String partnerid, String enrollmentorigin) {
	if(enrollmentorigin==null) {
	driver.get("https://bimhep-qa.bimnetworkstech.com/?partnerId="+partnerid+"");
	}
	else {
		driver.get("https://bimhep-qa.bimnetworkstech.com/?partnerId="+partnerid+""+"&EnrollmentOrigin="+enrollmentorigin+"");
	}
	}
	

public EnrollScreenClass submitEnrollScreen() 
{
	
	startbutton.click();
	waitForWebElementToDisAppear(pageLabel);
	EnrollScreenClass enrollscreen = new EnrollScreenClass(driver);
	return enrollscreen;
}

public LoginScreenClass signIn() throws InterruptedException {
	//waitElementVisibility(signinLink);
	Thread.sleep(4000);
	signinLink.click();
	Thread.sleep(4000);
	LoginScreenClass loginclass= new LoginScreenClass(driver);
	return loginclass;
}
public void refreshScreen() throws InterruptedException 
{
driver.navigate().refresh();
Thread.sleep(4000);
//WelcomePageClass welcomeclass=new WelcomePageClass(driver);
//return welcomeclass;

}

}
