package org.test.excelsam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibClass {
	public static WebDriver driver;
	public WebDriver getDriver() {
	System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\SeleiniumConcepts\\Driver\\chromedriver80.exe");
	driver = new ChromeDriver();
	return driver;
	}
	public void loadUrl(String url) {
	driver.get(url);
	}
	public void gettitle(String name) {
	driver.getTitle();
	}
	public void getcurrentUrl(String title) {
	driver.getCurrentUrl();
	}
	public static void maxWin() {
		driver.manage().window().maximize();
	}
	public void send(WebElement we,String name) {
		we.sendKeys(name);
	}
	public void clickBtn(WebElement clk) {
		clk.click();
	}
	public void quitBrowser() {
		driver.quit();
	}
	public void close() {
		driver.close();
	}
	public void clear(WebElement e) {
		e.clear();
    }
	public void getText(WebElement e) {
		String text = e.getText();
		System.out.println(text);
	}
	public void getAttribute(WebElement e ) {
		
		String attribute = e.getAttribute("value");
		System.out.println(attribute);
	}
	public void windowClose() {
		driver.close();
	}
	public void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File s =ts.getScreenshotAs(OutputType.FILE);
		File d =new File("D:\\Abi New Files\\Course\\Framwork\\Screenshot\\abi.bmp");
		FileUtils.copyFile(s,d);
 	}
	public void fndeleme(WebElement element, String name) {
		element.sendKeys(name);
	}
	public void fndelmnts(WebElement element, String name) {
		element.sendKeys(name);
	}
	
	public void readexcel(String name,String value) throws IOException {
		 File floc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\Register.xls");
			FileInputStream stream = new FileInputStream(floc);
			Workbook w = new HSSFWorkbook(stream);
			Sheet s= w.getSheet("Login");
			Row row = s.getRow(0);
			Cell cell = row.getCell(0);
			String user = cell.getStringCellValue();
			Cell cell2 = row.getCell(1);
			String pass = cell2.getStringCellValue();

	}
	
	public void writeExcel(int i,int j,String value) {
		File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\adacin.xls");
		Workbook w = new HSSFWorkbook();
		Sheet s = w.createSheet("Testing");
		Row r = s.createRow(i);
		Cell c = r.createCell(j);
		c.setCellValue(value);
			
	}
}
