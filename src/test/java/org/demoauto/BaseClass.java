package org.demoauto;

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

public class BaseClass {
	 public static WebDriver driver;
public static void getDriver() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\driver\\chromedriver79.exe");
	driver=new ChromeDriver();
	
}

public static void loadurl(String url) {
	driver.get(url);

}

public static void send(WebElement e, String name) {
	e.sendKeys(name);

}

public String getData(int rowNum,int cellNum) throws IOException {
	File loc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\update.xls");
	FileInputStream stream = new FileInputStream(loc);
	Workbook w = new HSSFWorkbook(stream);
	Sheet s = w.getSheet("Sheet1");
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
public void clickBtn(WebElement clk) {
	clk.click();
}
public void setcelldata(int i,String name,String add,String emailadd,String phone,String gender,String hobby,String lang,String skils,String Coun, String selectcountry, String dob,String password,String confirmpswrd) throws IOException {
	File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\update.xls");
	FileInputStream stream = new FileInputStream(f);

	Workbook w = new HSSFWorkbook(stream);

	Sheet s = w.getSheet("Sheet1");
	Row r = s.createRow(i);
	r.createCell(0).setCellValue(name);
	r.createCell(1).setCellValue(add);
	r.createCell(2).setCellValue(emailadd);
	r.createCell(3).setCellValue(phone);
	r.createCell(4).setCellValue(gender);
	r.createCell(5).setCellValue(hobby);
	r.createCell(6).setCellValue(lang);
	r.createCell(7).setCellValue(skils);
	r.createCell(8).setCellValue(Coun);
	r.createCell(9).setCellValue(selectcountry);
	r.createCell(10).setCellValue(dob);
	r.createCell(11).setCellValue(password);
	r.createCell(12).setCellValue(confirmpswrd);
	
	FileOutputStream o=new FileOutputStream(f);
	w.write(o);
	}

	
	

}


