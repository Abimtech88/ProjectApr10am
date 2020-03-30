package org.naukri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UtilClass {
	public static WebDriver driver;
	public WebDriver getDriver() {
	System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\driver\\chromedriver79.exe");
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
	public String getData(int rowNum,int cellNum) throws IOException {
		File loc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\update.xls");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new HSSFWorkbook(stream);
		Sheet s = w.getSheet("Adacin");
		Row r = s.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int type = c.getCellType();
		if(type==1)
		{
			String value = c.getStringCellValue();
			//System.out.print(value +"  " );
			return value;
		}
		if(type==0)
		{
			if(DateUtil.isCellDateFormatted(c))
			{
				Date date = new Date();
				SimpleDateFormat ss= new SimpleDateFormat("dd-MMM-yyyy");
				String format = ss.format(date);
			//	System.out.print(format +" ");
				return format;
			}
			else
			{
				double dd = c.getNumericCellValue();
				long ll = (long)dd;
				String name = String.valueOf(ll);
			//	System.out.print(name +"  ");
				return name;
			}
		}
		return null;
	}
		
		public void chooseByVisibleText(WebElement emnt,String name) {
	    	new Select(emnt).selectByVisibleText(name);
		}
		
		public String getAttribute(WebElement e ) {
			
			String attribute = e.getAttribute("value");
			System.out.println(attribute);
			return attribute;
		}

	public void CreateExc(String sheetName,int i,int j,String name) throws IOException {
		File floc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\aadacin.xls");
		Workbook w = new HSSFWorkbook();
		Sheet s =w.createSheet(sheetName);
		Row r = s.createRow(i);
		Cell c =r.createCell(j);		
		c.setCellValue(name);
		FileOutputStream o = new FileOutputStream(floc);
		w.write(o);

	}
	
	public void writeData(int i,int j,String value) throws IOException {
		File loc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\update.xls");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new HSSFWorkbook(stream);
		Sheet s = w.getSheet("Adacin");
		Row rr = s.createRow(i);
		Cell cell1 = rr.createCell(j);
		cell1.setCellValue(value);
		FileOutputStream o=new FileOutputStream(loc);
		w.write(o);
		System.out.println();
		System.out.println("Inserted one row");
		

	}
	
}
