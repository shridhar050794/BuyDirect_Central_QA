package BuyDirect.PageobjectClass;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuyDirect.AbstractComponent.AbstractComponents;

public class IAVScreenClass extends AbstractComponents {
	WebDriver driver;
	public IAVScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(css="h2[id='headerBank']")
public WebElement iavHeader;

@FindBy(css="div[class='Flink-module__paneWrapper']")
public WebElement iavIframe;

@FindBy(css="button[id='aut-button']")
public WebElement iavIframeSubmit;

@FindBy(xpath="//input[@id='search-input']")
public WebElement searchBankName;

@FindBy(xpath="//iframe[@id='plaid-link-iframe-1']")
public WebElement plaidFrame;

@FindBy(xpath="//div[@class='SandboxMessage-module__sandboxMessage']")
public WebElement sandboxText;

@FindBy(xpath="//div/button[@id='aut-button']")
public WebElement firstContinueButton;

@FindBy(xpath="//h2[@class='SearchAndSelectPane-module__title']")
public WebElement bankName;

@FindBy(xpath="//button[@id='aut-button']")
public WebElement bankContinue;

@FindBy(css="button[id='submit-credentials']")
public WebElement bankSubmitCreds;

@FindBy(css="button[id='submit-device']")
public WebElement bankSubmitDevice;

@FindBy(css="button[id='submit-code']")
public WebElement bankSubmitCode;

@FindBy(xpath="(//div[@class='selection-text'])[1]")
public WebElement bankSelectionText;

@FindBy(xpath="//button[@id='submit-accounts']")
public WebElement bankSubmitAccount;

@FindBy(xpath="(//div[contains(text(),'Terms and Conditions')])[2]")
public WebElement bankTC;

@FindBy(xpath="//button[@id='submit-confirmation']")
public WebElement bankSubmitConfirm;

@FindBy(css="button[id='aut-button']")
public WebElement bankLinkNow;

@FindBy(xpath="//div[@class='loading-spinner__circle']")
public WebElement iframeSpinner;

@FindBy(id="txtSearchBank")
public WebElement actverifybankSearch;

@FindBy(id="iframe")
public WebElement mainIAVFrame;

@FindBy(id="ifrm")
public WebElement ActVerifyFrame;

  public void PlaidBankingProcess() throws InterruptedException {
  //System.out.println("you are in IAV"); 
//  waitImplicit();
  waitForWebElementToAppear(mainIAVFrame);  
  driver.switchTo().frame("iframe");
 // System.out.println("You are in Parent Iframe"); 
  TargetLocator CurrentFrame = driver.switchTo();
  CurrentFrame.frame(plaidFrame);
  CurrentFrame.activeElement().sendKeys(Keys.TAB);
  CurrentFrame.activeElement().sendKeys(Keys.PAGE_DOWN);
 // Thread.sleep(15000);
  //waitImplicit();
  System.out.println("You are in sec Iframe"); 
  Thread.sleep(4000);
  firstContinueButton.click(); 
  //Thread.sleep(10000);
  
  CurrentFrame.activeElement().sendKeys(Keys.TAB);
  CurrentFrame.activeElement().sendKeys(Keys.PAGE_UP);
  //waitImplicit();
  waitForWebElementToAppear(searchBankName);
  searchIntoIAV(searchBankName);
 // WebElement bankName = driver.findElement(By.xpath("//h2[@class='SearchAndSelectPane-module__title']"));
  if(bankName.getText().contains("Chase")) {
	  bankName.click();
  }
  waitImplicit();
  //driver.findElement(By.xpath("(//div/p)[2]")).getText().contains("Chase");
 
  //CurrentFrame.frame(if1);
  //CurrentFrame.activeElement().sendKeys(Keys.TAB);
  CurrentFrame.activeElement().sendKeys(Keys.PAGE_DOWN);
  Thread.sleep(2000);
 // driver.findElement(By.xpath("//button[@id='aut-button']")).click();
  bankContinue.click();
  Thread.sleep(8000);
  String parentWindow = driver.getWindowHandle();
  System.out.println("parent     "+parentWindow);
  Set<String> windows =driver.getWindowHandles(); 
 
  for(String win: windows) {
	  driver.switchTo().window(win);
	  System.out.println(driver.getTitle());
  }
  //driver.findElement(By.cssSelector("button[id='submit-credentials']")).click();
  bankSubmitCreds.click();
  Thread.sleep(2000);
 // driver.findElement(By.cssSelector("button[id='submit-device']")).click();
  bankSubmitDevice.click();
 // driver.findElement(By.cssSelector("button[id='submit-code']")).click();
  bankSubmitCode.click();
  //driver.findElement(By.xpath("(//div[@class='selection-text'])[1]")).click();
  bankSelectionText.click();
  CurrentFrame.activeElement().sendKeys(Keys.PAGE_DOWN);
 // driver.findElement(By.xpath("//button[@id='submit-accounts']")).click();
  waitForWebElementToClickable(bankSubmitAccount);
  bankSubmitAccount.click();
 // Thread.sleep(5000);
 // WebElement tc = driver.findElement(By.xpath("(//div[contains(text(),'Terms and Conditions')])[2]"));
  //bankTC.click();
  waitForWebElementToDisAppear(bankSubmitAccount);
  bankTC.click();
  //driver.findElement(By.xpath("//button[@id='submit-confirmation']")).click();
  bankSubmitConfirm.click();
 // Thread.sleep(8000);
  waitImplicit();
  driver.switchTo().window(parentWindow);
  driver.switchTo().frame("iframe");
  System.out.println("back to f1");
  //Thread.sleep(8000);
  waitImplicit();
  //driver.switchTo().frame(if1);
  //driver.findElement(By.xpath("//iframe[@id='plaid-link-iframe-1']"));
  driver.switchTo().frame("plaid-link-iframe-1");
 // Thread.sleep(1000);
  waitImplicit();
  System.out.println("back to f2");
  
 // Thread.sleep(6000);
  CurrentFrame.activeElement().sendKeys(Keys.PAGE_DOWN);
 // driver.findElement(By.cssSelector("button[id='aut-button']")).click();
  bankLinkNow.click();
  driver.switchTo().defaultContent();
  waitForWebElementToDisAppear(iframeSpinner);
 // Thread.sleep(20000);
  } 
  
  
  public void AcctverifyBankingProcess() throws InterruptedException {
	  
	  waitForWebElementToAppear(mainIAVFrame);
	 
	  driver.switchTo().frame("iframe");
	 // Thread.sleep(10000);
	  waitForWebElementToAppear(ActVerifyFrame);
	 // scrollToBottom();
	  driver.switchTo().frame("ifrm");
	  //Thread.sleep(20000);
	  //Thread.sleep(4000); 
	  waitForWebElementToAppear(actverifybankSearch);
	 
	  actverifybankSearch.sendKeys("CashEdge Bank");
	 Thread.sleep(4000);
	  WebElement bankname=driver.findElement(By.xpath("//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content']//p[contains(text(),'CashEdge Bank - Retail Non MFA')]"));
	  Actions a =new Actions(driver);
	  a.scrollToElement(bankname);
	  bankname.click();
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("nonmfa1234");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("nonmfa1234");
	  driver.findElement(By.id("btnLoginSubmit")).click();
	  waitForWebElementToDisAppear(iframeSpinner);
	  driver.switchTo().defaultContent();
	  
	  
	  
	  
	  
	  
	  
  }
  
}
