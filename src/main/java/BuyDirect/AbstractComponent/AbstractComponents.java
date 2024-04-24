package BuyDirect.AbstractComponent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.Duration;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	static WebDriver driver;
	static WebDriverWait wait;
	ResultSet res;
	//String queryrequest;
	public AbstractComponents(WebDriver driver) {
		AbstractComponents.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(id="buydirectMobileLogo")
public static WebElement partnerlogo;

@FindBy(xpath="//h5[@class='text-center mb-3']")
public WebElement partnerName;

@FindBy(css="input[id='phone']")
public WebElement partnerPhone;

@FindBy(id="main-footer")
public WebElement partnerFooter;


@FindBy(xpath="//div[@class='pace pace-inactive']")
public static WebElement paceLoader;


@FindBy(xpath="//div[@class='pace pace-active']")
public static WebElement paceLoaderActive;	

	public void searchIntoIAV(WebElement element) {
		 Actions a = new Actions(driver);
		 a.sendKeys(element,"chase").build().perform();
	}
	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToAppear(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	public void waitForWebElementToDisAppear(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	public void waitForWebElementToClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	public void loadspinnerDisapper() {
		WebElement toploader = driver.findElement(By.cssSelector("div[class='pace-activity']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.invisibilityOf(toploader));
		
	}
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void scrollToBottom() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	public void pageLoadtime() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	public void getNewWindow() {
		Set<String> windows = driver.getWindowHandles();
		for(String win : windows) 
		{
			driver.switchTo().window(win);
			
		}
	}

	public static Map<String, String> readExcelData() throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\shridhar\\Desktop\\ConsumerData.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("ConsumerData");

        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        Map<String, String> dataMap = new HashMap<>();

        for (int i = 0; i < colCount; i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null) {
                dataMap.put(cell.getStringCellValue(), "");
            }
        }

        int rowCount = sheet.getLastRowNum();
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell headerCell = headerRow.getCell(j);
                Cell cell = row.getCell(j);
                if (cell != null && headerCell != null) {
                    String columnName = headerCell.getStringCellValue();
                    switch (cell.getCellType()) {
                        case STRING:
                            dataMap.put(columnName, cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                dataMap.put(columnName, cell.getDateCellValue().toString());
                            } else {
                                dataMap.put(columnName, String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case BOOLEAN:
                            dataMap.put(columnName, String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case BLANK:
                            dataMap.put(columnName, "");
                            break;
                        default:
                            dataMap.put(columnName, cell.getStringCellValue());
                    }
                }
            }
        }

        workbook.close();
        inputStream.close();
        return dataMap;
    }
	
	
}

