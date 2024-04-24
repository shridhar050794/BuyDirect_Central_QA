package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class PlasticScreenClass extends AbstractComponents {
	WebDriver driver;
	public PlasticScreenClass(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css="h2[id='headerPlasticRequest']")
public WebElement plasticHeader;

@FindBy(id="plastic-request--subtitle")
public WebElement plasticSubtitle;

@FindBy(id="plastic-request--no")
public WebElement noButton;
//public By noButton = By.id("plastic-request--no");

@FindBy(id="plastic-request--yes")
public WebElement yesButton;
//public By yesButton = By.id("plastic-request--yes");

@FindBy(xpath="//button[@id='plastic-request--btn']")
public WebElement plasticSubmitButton;

@FindBy(xpath="//p[@id='plastic-request--body-pri']")
public WebElement plasticMainBody;


@FindBy(xpath="//p[@id='plastic-request--body-sec']")
public WebElement plasticSubBody;



public BankingIntroScreenClass submitPlastic() throws InterruptedException {
	//Thread.sleep(10000);
	//pageLoadWait();
	waitForWebElementToAppear(plasticHeader);
	//String plasticHeaderText = plasticHeader.getText();
	//System.out.println("PlasticHeader   "+ plasticHeaderText);
	//driver.findElement(noButton).isEnabled();
	yesButton.click();
	plasticSubmitButton.click();
	//Thread.sleep(20000);
	waitForWebElementToDisAppear(plasticHeader);
	
	BankingIntroScreenClass intro = new BankingIntroScreenClass(driver);
	return intro;
}
public void selectPlasticAbility() {
	waitForWebElementToAppear(plasticHeader);
	yesButton.click();
}
public void click_Plastic_Continue() {
	waitForWebElementToAppear(plasticHeader);
	plasticSubmitButton.click();
	waitForWebElementToAppear(paceLoaderActive);
}
}
