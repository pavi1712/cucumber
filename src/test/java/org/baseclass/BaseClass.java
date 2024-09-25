package org.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.DiscreteDomain;

public class BaseClass{
	
	 private static final String FileUtil = null;
	public static WebDriver driver;
	 public static WebElement element;
	 public static Actions a;
	 public static Robot r;
	 public static Alert a1;
	 public static TakesScreenshot tk;
	 public static Select s;
	public static String stringCellValue;

	 
	public static void launchBrowser() {
		 driver=new ChromeDriver();
		 }
	
	public static void togetUrl(String url) {
		driver.get(url);
		}
	public static void toMaximize() {
		driver.manage().window().maximize();
		}
	public static void toCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	}
	public static void toTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		}
	
	public static  void toSendkeys(WebElement element,String userText ) {
	element.sendKeys(userText);
	}
	public static void toClick(WebElement element) {
		element.click();
		}
	public static void toWindowHandle() {
	driver.getWindowHandle();
	}
	
	public static void toWindowHandles() {
	driver.getWindowHandles();
	}
	
	public static void toSwitchTo() {
	driver.switchTo();
	}
	
	public static  void togetAttribute(WebElement element,String value) {
    element.getAttribute(value);
    }
	
	public static void togetText(WebElement element,String text) {
	element.getText();	
	}
	
	public static void toQuit() {
		driver.quit();
		}
	public static void toClose() {
		driver.close();
		}
	
	//Actions
	
	public static void moveToElement(WebElement element) {
		 a=new Actions(driver);
		a.moveToElement(element).perform();
		}
	public static void dragAndDrop(WebElement src,WebElement dest) {
		a.dragAndDrop(src, dest).perform();;
		}
	public static void contectClick(WebElement element) {
		a.contextClick(element).perform();;
		}
	public static void doubleClick(WebElement element) {
		a.doubleClick(element).perform();
		}
	//
	
	//Robot
	
	private void toEnter() throws AWTException {
		Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//Alert
	
	public static  void toAccept() {
		a1.accept();
		}
	public static void toDissmiss() {
		a1.dismiss();
}
	public static void alertGetText() {
		String text = a1.getText();
		System.out.println(text);
		}
	
	//ScreenShot
	public static void toTakeScreenshot(String a) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\USER\\Desktop\\WS\\Maven\\Screenshot");
		FileUtils.copyFile(src,dest);
		}
	
	//Select
	public static  void toSelectByIndex(WebElement element,int index) {
		s=new Select(element);
		s.selectByIndex(index);
		}
	public static  void toSelectByValue(WebElement element,String value) {
		s=new Select(element);
		s.selectByValue(value);
		}
	public static  void toSelectByVisibleText(WebElement element,String visibletext) {
		s=new Select(element);
		s.selectByVisibleText(visibletext);
		}
	
	// DATADRIVEN Read Excel
	
	public static String readExcel(String sheetname,int rowno,int cellno) throws IOException {
		File f=new File("C:\\Users\\USER\\Desktop\\WS\\Maven\\Excel\\Employee.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook book=new XSSFWorkbook(fi);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		
		int cellType = cell.getCellType();
		String value="";
		if(cellType==1) {
			  value = cell.getStringCellValue();
			 System.out.println(value);
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MMM-yyyy");
			value= sim.format(dateCellValue);
			System.out.println(value);
			}
		else {
			double n = cell.getNumericCellValue();
			long l=(long)n;
			 value = String.valueOf(l);
			System.out.println(value);
		}
		return value;
	}

		
	}
	


