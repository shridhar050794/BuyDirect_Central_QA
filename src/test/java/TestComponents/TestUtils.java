package TestComponents;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import BuyDirect.AbstractComponent.AbstractComponents;
import BuyDirect.PageobjectClass.EnrollScreenClass;
import BuyDirect.PageobjectClass.WelcomePageClass;
import BuyDirect.Utilities.TestHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtils {
	public WebDriver driver;
	ResultSet res;
	String dbtext;
	public String Partnerid;
	public String enrollmentorigin;
	public static String partner;
	public WelcomePageClass welcome;
	static String text;
	static int count;
	public String DlFlag;
	public EnrollScreenClass enrollclass;
	public String imagelink;
	public static TestHelper testhelper;
	public String requiredFooter;
	public Properties prop;
	ChromeOptions chromeopt;
	EdgeOptions edgeopt;
	String browserName ;
	
	public WebDriver browserInvoke() throws IOException {
		 
        //go to page
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\BuyDirect\\resource\\GlobalData.properties");
		prop.load(fis);
		partner = prop.getProperty("PartnerID");
		Partnerid = Base64.getEncoder()
				.encodeToString(partner.getBytes());
		enrollmentorigin=prop.getProperty("enrollmentorigin");
		//to get the browser name from properties
		//browserName=prop.getProperty("browser");
		
		//now to get the broeser name from console of maven and if it is null we need to get it from propertie file
		browserName= System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) 
		{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(handleAutoSaveForChrome());
		}
		if(browserName.equalsIgnoreCase("edge")) 
		{
			
			//System.setProperty("webdriver.edge.driver", "C:\\New folder\\Selenium\\msedgedriver.exe");
			
			System.setProperty("webdriver.edge.driver", "C:\\New folder\\Selenium\\msedgedriver.exe");
			//driver = new EdgeDriver();
			
			driver= new EdgeDriver(handleAutoSaveForEdge());
			}
	    driver.manage().window().maximize(); 
        return driver;
		
	}
public ChromeOptions handleAutoSaveForChrome() {
	
		chromeopt = new ChromeOptions();
		
		  Map<String, Object> prefs = new HashMap<String, Object>();
		  prefs.put("autofill.profile_enabled", false);
		  chromeopt.setExperimentalOption("prefs", prefs);
		  chromeopt.addArguments("force-device-scale-factor=0.80");
		  chromeopt.addArguments("high-dpi-support=0.80");
		 
		chromeopt.addArguments("--guest");
		//if we want to run browser in headless , use below option
		//chromeopt.addArguments("headless");
		return chromeopt;
	
	}

public EdgeOptions handleAutoSaveForEdge() {
	
	edgeopt = new EdgeOptions();
	edgeopt.addArguments("--guest");
	return edgeopt;

}
@BeforeMethod
public WelcomePageClass launchApp() throws IOException {
	driver = browserInvoke();
	welcome = new WelcomePageClass(driver);
	welcome.goTo(Partnerid,enrollmentorigin);
	return welcome;
	
}
@AfterMethod
public void tearDown() {
	driver.quit();
}

//DB Connection

public  ResultSet dbConnect(String queryToExecute) {
	Connection connection;
	String connectionUrl = "jdbc:sqlserver://bimservicesdb-qa.database.windows.net;databaseName=BimSys";
	String userName="bimx05dbqa";
	String pass="jVs4xpUsVd35eyr5";
	try {
		
		connection = DriverManager.getConnection(connectionUrl,userName,pass);
		System.out.println("Success!You connected to BimSys DataBase");
		String query =queryToExecute;
		//Statement statement= connection.createStatement();
		if(queryToExecute.contains("update")) {
			connection.createStatement().executeUpdate(query);
		}
		else {
		res=connection.createStatement().executeQuery(query);
		}
	} catch (SQLException e) {
		System.out.println("Oops, connection error");
		e.printStackTrace();

	}
return res;
}
public String queryExecutionMethod(String queryToExecute) {
	//String queryrequest ="select Is_Plastics_Page_Displayed from Partner_BuyDirect_Settings where Partner_id=127";
	dbConnect(queryToExecute);
	count=0;
	try {
		while(res.next()){
			
			text= res.getString(1);
			//System.out.println(text);
			count++;	
			//System.out.printf("Consumer_data"+count+" --"+Consumer_id+"--"+name);
			
				
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
	return text;
} 
public String plasticAbilityQuery() {
	String queryrequest ="select Is_Plastics_Page_Displayed from Partner_BuyDirect_Settings where Partner_id="+partner+"";
	dbtext =queryExecutionMethod(queryrequest);
	return dbtext;
	}

public String bankInroQuery() {
	String queryrequest ="select Is_Banking_Intro_Page_Displayed from partner_buydirect_settings where Partner_ID ="+partner+"";
	dbtext =queryExecutionMethod(queryrequest);
	return dbtext;
}
public String DLRequired() {
	String queryrequest ="select IsDLrequired from partner_buydirect_settings where Partner_ID ="+partner+"";
	dbtext =queryExecutionMethod(queryrequest);
	return dbtext;
}
public String updateDLRequiredToFalse() {
	String queryrequest ="update partner_buydirect_settings set IsDLrequired=0 where Partner_ID ="+partner+"";
	dbConnect(queryrequest);
	String DLInitial = DLRequired();
	return DLInitial;
	
}

public String updateDLRequiredToTrue() {
	String queryrequest = "update partner_buydirect_settings set IsDLrequired=1 where Partner_ID = 127";
	dbConnect(queryrequest);
	String DLInitial = DLRequired();
	return DLInitial;

}
public int imageorLinkStatus(String imagelink) throws IOException {
	
	 URL url = new URL(imagelink);

     //Now we will be creating url connection and getting the response code
     HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
     httpURLConnect.setConnectTimeout(5000);
     httpURLConnect.connect();
     return httpURLConnect.getResponseCode();
    
	}
public void sendDataToEnrollScreen() throws InterruptedException, IOException {
	//String DLrequired = DLRequired();
	enrollclass =new EnrollScreenClass(driver);
	Map<String, String> excelReadData =ConsumerDataClass.ExcelDataReader();
	enrollclass.addFirstname(excelReadData.get("First_Name"));
	enrollclass.addLastname(excelReadData.get("Last_Name"));
	enrollclass.addPhone(excelReadData.get("Phone"));
	String uuid = UUID.randomUUID().toString();
	String emailString ="automation21" +uuid.substring(0,5)+"@automation.com";
	enrollclass.addEmail(emailString);
	enrollclass.addStreetAddress(excelReadData.get("Street"));
	enrollclass.addCity(excelReadData.get("City"));
	enrollclass.addState(excelReadData.get("State"));
	enrollclass.addZip(excelReadData.get("ZIP"));
	
	DlFlag = DLRequired();
	enrollclass.addID(excelReadData.get("ID_Type"), excelReadData.get("ID_State"), excelReadData.get("ID_Number"), DlFlag);
	enrollclass.addDOB();
	enrollclass.addPIN(excelReadData.get("PIN"));
	enrollclass.submitTerms();
}
public void ClearElementInputAndScroll(WebElement element) {
	element.clear();
	element.sendKeys(Keys.DOWN);
}
public List<String> queryExecution_For_MultipleData_In_Column_Values(String queryToExecute,String name1 , String name2) {
    List<String> strings = new ArrayList<>();
    ResultSet resultSet = dbConnect(queryToExecute);
    try {
        while (resultSet.next()) {
        	strings.add(resultSet.getString(name1)); // Add plasticBodyMain to the list
            strings.add(resultSet.getString(name2));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return strings;
}

public void PartnerPropertiesTest() throws IOException{
	testhelper = new TestHelper();
	enrollclass =new EnrollScreenClass(driver);
    imagelink=AbstractComponents.partnerlogo.getAttribute("src");
    String[] column= {"Product_Name","Partner_contact_number"};
   // List<String> partnerProp=queryExecution_For_MultipleData_In_Column_Values(testhelper.partner_Prop_Query,"Product_Name","Partner_contact_number");
    List<String> partnerProp=queryExecutionMethodForMultipleDataInColumns(testhelper.partner_Prop_Query,column);
 
	requiredFooter= "Please contact the " + partnerProp.get(0) + " Support Team at " + partnerProp.get(1) + " with any questions.";
	

	}
public List<String> queryExecutionMethodForMultipleDataInColumns(String queryToExecute, String[] columnNames) {
    List<String> result = new ArrayList<>();
    ResultSet resultSet = dbConnect(queryToExecute);
    
    try {
        while (resultSet.next()) {
           // List<String> row = new ArrayList<>();
            for (String columnName : columnNames) {
            	result.add(resultSet.getString(columnName));
            }
           // result.add(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    return result;
}

public List<String> db_Value_Extractor(String query , String[] columns) {
	//String[] columns = {"plasticBodyMain", "plasticBodySub"};
	List<String> texts = queryExecutionMethodForMultipleDataInColumns(query, columns);

	// Iterate over the result to access the fetched values
	for (String row : texts) {
	    
	    System.out.println();
	}
	return texts;
	
}
}	