package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class CongratsScreenClass extends AbstractComponents{
	WebDriver driver;
	public CongratsScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	
@FindBy(xpath="//h2[@id='headerConfirmation']")
public WebElement confirmationHeader;

@FindBy(id="dynamic-congrats-message")
public WebElement confirmationBody;

}