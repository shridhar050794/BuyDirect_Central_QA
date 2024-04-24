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
	
@FindBy(xpath="//h2[contains(text() ,'Link Your Bank Account')]")
public WebElement introHeader;

@FindBy(xpath="//span[contains(text(),'Two ways')]")
public WebElement introBody;


@FindBy(xpath="//button[@id='btn-banking-intro__iav']")
public WebElement iavButton;

@FindBy(xpath="//div/button/div/h2[text()='Instant']")
public WebElement iavButtonText;


@FindBy(xpath="//button[@id='btn-banking-intro__cdw']")
public WebElement cdwButton;


//String introBodyText = introBody.getText();
public IAVScreenClass submitIntroScreenToIAV() throws InterruptedException {
	//waitImplicit();
	waitForWebElementToAppear(iavButton); 
	iavButton.click();
	IAVScreenClass iavclass = new IAVScreenClass(driver);
	
	waitImplicit();
	return iavclass;
	}


public CDWScreenClass submitIntroScreenToCDW() throws InterruptedException 
	{
	waitForWebElementToAppear(cdwButton);

	cdwButton.click();
	CDWScreenClass cdwclass = new CDWScreenClass(driver);
	//Thread.sleep(20000);
	waitImplicit();
	return cdwclass;
	}
}
