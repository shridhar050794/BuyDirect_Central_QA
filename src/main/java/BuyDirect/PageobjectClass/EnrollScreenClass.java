package BuyDirect.PageobjectClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BuyDirect.AbstractComponent.AbstractComponents;

public class EnrollScreenClass extends AbstractComponents {
	WebDriver driver;
	Select selState;
	//Select selDLState;
	public EnrollScreenClass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(id="headerEnroll")
public WebElement enrollHeader;

@FindBy(css="input[id='firstname']")
public WebElement firstname;


@FindBy(css="input[id='lastname']")
public WebElement lastname;

@FindBy(css="input[id='email']")
public WebElement email;

@FindBy(css="input[id='address']")
public WebElement street;


@FindBy(css="input[id='city']")
public WebElement city;


@FindBy(id="suite")
public WebElement suite;


@FindBy(css="select[id='state']")
public WebElement state;

@FindBy(css="input[id='zip']")
public WebElement zip;

@FindBy(css="input[id='dateofbirth']")
public WebElement dateofbirth;

@FindBy(css=".picker__day.picker__day--infocus.picker__day--highlighted")
public WebElement presentday;

@FindBy(css="input[id='Createpin']")
public WebElement Createpin;

@FindBy(css="input[id='term']")
public WebElement term;


@FindBy(xpath="//label[@for='term']")
public WebElement termText;


@FindBy(css="button[id='btnEnroll']")
public WebElement btnEnroll;

@FindBy(css="p[id='main-footer']")
WebElement footer;


@FindBy(css="select[name='SelectID']")
public WebElement DLstateDropdown;

@FindBy(id="stateissued")
public WebElement IDstate;

@FindBy(css="input[name='number']")
public WebElement stateNumber;

@FindBy(css="label[for='stateissued']")
public WebElement Dlstateheader;

@FindBy(xpath="//div[@for='firstname']")
public WebElement requiredFirstName;

@FindBy(xpath="//div[@for='lastname']")
public WebElement requiredLastName;

@FindBy(xpath="//div[@for='email']")
public WebElement requiredEmail;

@FindBy(xpath="//div[@for='phone']")
public WebElement requiredPhone;

@FindBy(xpath="//div[@for='address']")
public WebElement requiredStreet;

@FindBy(xpath="//div[@for='city']")
public WebElement requiredCity;

@FindBy(xpath="//div[@for='state']")
public WebElement requiredState;

@FindBy(xpath="//div[@for='zip']")
public WebElement requiredZip;

@FindBy(xpath="//div[@for='stateissued']")
public WebElement requiredIdState;

@FindBy(xpath="//div[@for='number']")
public WebElement requiredIDNumber;

@FindBy(xpath="//div[@for='dateofbirth']")
public WebElement requiredDOB;

@FindBy(xpath="//div[@for='Createpin']")
public WebElement requiredPIN;

@FindBy(xpath="//div[@for='term']")
public WebElement requiredTerm;

@FindBy(xpath="(//a[contains(text(),'sign in')])[1]")
public WebElement signInLink;

@FindBy(xpath="(//span[@class='d-inline-block'])[2]")
public WebElement PartnerPhoneNumber;

@FindBy(xpath="//a[contains(text(),'Term')]")
public WebElement TermsLink;

@FindBy(xpath="//a[contains(text(),'Notification')]")
public WebElement NotificationLink;

@FindBy(xpath="//button[@class='picker__button--clear']")
public WebElement clearDOB;

public String emailString;


public void addFirstname(String fName) {
	firstname.sendKeys(fName);
}

public void addLastname(String LName) {
	lastname.sendKeys(LName);		
}

public void addEmail(String emailId) {
	email.sendKeys(emailId);		
}
public void addStreetAddress(String streetname) {
	street.sendKeys(streetname);		
}
public void addPhone(String phoneNumber) {
	partnerPhone.sendKeys(phoneNumber);		
}
public void addSuite (String SuiteName ) {
	suite.sendKeys(SuiteName);		
}
public void addCity(String City) {
	city.sendKeys(City);		
}
public void addState(String State) {
	selState = new Select(state);
	selState.selectByValue(State);
	
}
public void addID(String IDType,String IDStateValue,String IdNumber,String DLflag ) 
{
	
	if(DLflag.equalsIgnoreCase("1"))
	{
		Select selDL = new Select(DLstateDropdown);
		selDL.selectByValue(IDType);
		Select selDLState= new Select(IDstate);
		selDLState.selectByValue(IDStateValue);
		stateNumber.sendKeys(IdNumber);
		
	}		
}

public void addZip(String Zip) throws InterruptedException {
	//Thread.sleep(3000);
	//Thread.sleep(4000);
	//scrollToBottom();
	zip.sendKeys(Keys.PAGE_DOWN);
	zip.sendKeys(Zip);		
}


public void addDOB() throws InterruptedException {
	
	
	Thread.sleep(2000);
	dateofbirth.click();
	Thread.sleep(2000);
	presentday.click();
	
	
}
public void addPIN(String PIN) throws InterruptedException {

	
	Createpin.sendKeys(PIN);
	Thread.sleep(4000);
	
}
public void submitTerms() throws InterruptedException {
	//waitForWebElementToClickable(term);
	//scrollToBottom();
	term.click();		
}




/*
 * public void sendInputs(String DLflag) throws InterruptedException,
 * IOException, ParseException { Map<String, String> excelReadData =
 * readExcelData();
 * 
 * 
 * lastname.sendKeys(excelReadData.get("Last_Name")); String uuid =
 * UUID.randomUUID().toString(); emailString ="automation21"
 * +uuid.substring(0,5)+"@automation.com"; email.sendKeys(emailString);
 * //email.sendKeys(excelReadData.get("Email"));
 * 
 * phone.sendKeys(excelReadData.get("Phone"));
 * 
 * address.sendKeys(excelReadData.get("Street"));
 * city.sendKeys(excelReadData.get("City")); Select se = new Select(state);
 * se.selectByValue(excelReadData.get("State"));
 * zip.sendKeys(excelReadData.get("ZIP"));
 * 
 * 
 * if(DLflag.equalsIgnoreCase("1")) { Select selDL = new
 * Select(DLstateDropdown); selDL.selectByValue("DL"); Select selDLState= new
 * Select(DLstate); selDLState.selectByValue(excelReadData.get("DLState"));
 * stateNumber.sendKeys(excelReadData.get("DLNumber")); }
 * //scrollToElement(term); Createpin.sendKeys(excelReadData.get("PIN"));
 * Thread.sleep(2000);
 * 
 * dateofbirth.click(); Thread.sleep(2000); presentday.click();
 * scrollToBottom(); waitForWebElementToAppear(term); Thread.sleep(3000);
 * //scrollToElement(term); term.click(); }
 */
/*
 * public void Name(String firstName,String lastName) {
 * firstname.sendKeys(firstName); lastname.sendKeys(lastName); }
 * 
 * public void Phone(String phoneNo) { phone.sendKeys(phoneNo); } public void
 * PIN(String pin) { Createpin.sendKeys(pin); }
 * 
 * public void Address(String street, String cityName , String stateName ,
 * String zipcode) { address.sendKeys(street); city.sendKeys(cityName); Select
 * se = new Select(state); se.selectByValue(stateName); zip.sendKeys(zipcode); }
 * public void DOB(String street) throws InterruptedException {
 * waitForWebElementToAppear(dateofbirth); dateofbirth.click();
 * Thread.sleep(2000); presentday.click(); }
 */

public PlasticScreenClass submitEnroll() throws InterruptedException {

	btnEnroll.click();
	waitForWebElementToDisAppear(enrollHeader);
	//Thread.sleep(5000);
	PlasticScreenClass plasticobject = new PlasticScreenClass(driver);
	return plasticobject;
}
public BankingIntroScreenClass continueWithoutPlasticScreen() throws InterruptedException {
	btnEnroll.click();
	waitForWebElementToDisAppear(enrollHeader);
	//Thread.sleep(6000);
	BankingIntroScreenClass intro = new BankingIntroScreenClass(driver);
	return intro;
}

public IAVScreenClass continueWithoutIntroScreen() throws InterruptedException {
	btnEnroll.click();
	waitForWebElementToDisAppear(enrollHeader);
	Thread.sleep(6000);
	IAVScreenClass iavclass = new IAVScreenClass(driver);
	return iavclass;
}
public void ElementValidationCheck(WebElement element) {
	element.clear();
	btnEnroll.click();
}
public void validationOfDOB(WebElement DOB) throws InterruptedException 
{
	dateofbirth.click();
	Thread.sleep(1500);
	clearDOB.click();
	waitForWebElementToDisAppear(clearDOB);
	btnEnroll.click();
}

public void validationOfState() 
{
	selState = new Select(state);
	selState.selectByVisibleText("Select State");
	btnEnroll.click();
}

public void validationOfIDStateAndNumber() 
{
	Select selDLState= new Select(IDstate);
	selDLState.selectByVisibleText("Select State");
	stateNumber.clear();
	btnEnroll.click();
}

public String termsLinkTab() {
	TermsLink.click();
	getNewWindow();
	String termURL= driver.getCurrentUrl();
	driver.switchTo().defaultContent();
	return termURL;
}

public String notificatoinLinkTab() {
	NotificationLink.click();
	getNewWindow();
	String notificationURL= driver.getCurrentUrl();
	driver.switchTo().defaultContent();
	return notificationURL;
}

public void click_Button_functionality() {
	btnEnroll.click();
	waitForWebElementToAppear(paceLoaderActive);
}
}
