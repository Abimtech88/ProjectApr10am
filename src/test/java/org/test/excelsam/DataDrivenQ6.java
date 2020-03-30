package org.test.excelsam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataDrivenQ6 extends LibClass{
public static void main(String[] args) throws IOException {
	
	LibClass l = new LibClass();
	l.getDriver();
	l.loadUrl("https://www.facebook.com/");
	
	
	 File floc = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\Register.xls");
		FileInputStream stream = new FileInputStream(floc);
		Workbook w = new HSSFWorkbook(stream);
		Sheet s= w.getSheet("Login");
		Row row = s.getRow(1);
		Cell cell = row.getCell(0);
		String user = cell.getStringCellValue();
		System.out.println(user);
		Cell cell2 = row.getCell(1);
		String pass = cell2.getStringCellValue();
		System.out.println(pass);
		
		WebElement txtusr = driver.findElement(By.id("email"));
		txtusr.sendKeys(user);
		WebElement txtpass = driver.findElement(By.id("pass"));
		txtpass.sendKeys(pass);
		WebElement clkbtn = driver.findElement(By.xpath("//input[@value='Log In']"));
		clkbtn.click();
		l.screenShot();
		WebElement msg = driver.findElement(By.xpath("//span[text()='Log in to Facebook']"));
		String text = msg.getText();
		System.out.println(text);
		
		Row rr = s.createRow(11);
		Cell cell1 = rr.createCell(0);
		cell1.setCellValue(text);
		FileOutputStream o=new FileOutputStream(floc);
		w.write(o);
		System.out.println();
		System.out.println("Inserted one row");
		
	
	
}
}
