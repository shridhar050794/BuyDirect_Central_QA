package BuyDirect.PageobjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class CDWSuccessScreenClass extends AbstractComponents {
	WebDriver driver;
	public CDWSuccessScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//span[contains(text(),'small deposit and withdrawal')]")
public WebElement cdwSuccessBody;






 
 
}