package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class DepositScreenClass extends AbstractComponents {
	WebDriver driver;
	public DepositScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

@FindBy(xpath="//h5[contains(text(),'Enter Deposit and Withdrawal')]")
public WebElement depositBody;

@FindBy(xpath="//input[@name='DepositAmount']")
public WebElement depositInput;

@FindBy(xpath="//input[@name='webWithDrawlAmount']")
public WebElement withdrawalInput;

@FindBy(xpath="//button[@id='btnAmount']")
public WebElement depositSubmitButton;

public CongratsScreenClass submitDeposit() throws InterruptedException {
	depositInput.sendKeys("0.09");
	withdrawalInput.sendKeys("0.08");
	depositSubmitButton.click();
	//Thread.sleep(15000);
	waitImplicit();
	CongratsScreenClass congratsclass= new CongratsScreenClass(driver);
	return congratsclass;
}

}
