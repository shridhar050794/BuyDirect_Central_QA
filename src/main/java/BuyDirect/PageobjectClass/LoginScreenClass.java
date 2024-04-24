package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class LoginScreenClass extends AbstractComponents{
	WebDriver driver;
	public LoginScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

@FindBy(css="#headerSignIn")
public WebElement signinHeader;

@FindBy(css="input[name='logInEmail']")
public WebElement loginEmail;

@FindBy(css="input[name='logInPin']")
public WebElement loginPIN;

@FindBy(xpath="//button[@id='btnSignIn']")
public WebElement loginSubmit;

@FindBy(xpath="(//i[@class='mdi mdi-eye zulu-pass-icon'])[1]")
public WebElement pinView;

public WelcomeBackPageClass login() throws InterruptedException {
	//List<String> emails = dbConnect();
	//System.out.println(emails);
	loginEmail.sendKeys("selenium3acca@hep.com");
	loginPIN.sendKeys("9192");
	loginSubmit.click();
	Thread.sleep(10000);
	WelcomeBackPageClass welcomebackclass = new WelcomeBackPageClass(driver);
	return welcomebackclass;
}


}
