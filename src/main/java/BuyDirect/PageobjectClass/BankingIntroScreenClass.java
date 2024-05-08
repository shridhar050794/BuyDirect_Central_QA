package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class BankingIntroScreenClass extends AbstractComponents{
	WebDriver driver;
	public BankingIntroScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//div/h1")
public WebElement introHeader;

@FindBy(xpath="//p[@id='banking-intro__body']/span")
public WebElement introBody;


@FindBy(xpath="//label[@for='btn-banking-intro-mob__iav']")
public WebElement iavBox;

@FindBy(xpath="//span[contains(text(),'Securely log in')]")
public WebElement iavBoxText;


@FindBy(xpath="//label[@for='btn-banking-intro-mob__cdw']")
public WebElement cdwBox;


@FindBy(xpath="//span[contains(text(),'Enter your routing')]")
public WebElement cdwButtonText; 


//String introBodyText = introBody.getText();
public IAVScreenClass submitIntroScreenToIAV() throws InterruptedException {
	//waitImplicit();
	waitForWebElementToAppear(iavBox); 
	iavBox.click();
	IAVScreenClass iavclass = new IAVScreenClass(driver);
	
	waitImplicit();
	return iavclass;
	}


public CDWScreenClass submitIntroScreenToCDW() throws InterruptedException 
	{
	waitForWebElementToAppear(cdwBox);

	cdwBox.click();
	CDWScreenClass cdwclass = new CDWScreenClass(driver);
	//Thread.sleep(20000);
	waitImplicit();
	return cdwclass;
	}
}
