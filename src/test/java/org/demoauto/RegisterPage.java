package org.demoauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BaseClass {
@SuppressWarnings("static-access")
public static void main(String[] args) throws IOException, InterruptedException {
	BaseClass c = new BaseClass();
	BaseClass.getDriver();
	c.loadurl("http://demo.automationtesting.in/Register.html");
	
	List<WebElement> list = driver.findElements(By.xpath("//label[@class='col-md-3 col-xs-3 col-sm-3 control-label']"));
	File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Abi\\Selenium\\ExcelProjectsam\\Excel\\update.xls");
	FileInputStream stream = new FileInputStream(f);

	Workbook w = new HSSFWorkbook(stream);

	Sheet s = w.getSheet("Sheet1");
	Row r = s.createRow(0);
	for (int i = 0; i < list.size(); i++) {
		String text = list.get(i).getText();
		Cell cell = r.createCell(i);
		cell.setCellValue(text);//System.out.println(text);
	}
	FileOutputStream o=new FileOutputStream(f);
	w.write(o);
	c.setcelldata(2, "Abinaya", "Karapakkam", "abi4555@gmail.com", "9876987654", "female", "music", "english", "selenium", "india", "india", "03/08/1988", "sad", "sad");
	
	String fName = c.getData(2, 0);
	String add = c.getData(2, 1);
	String emailadd = c.getData(2, 2);	
	String phone = c.getData(2, 3);
	String gender = c.getData(2, 4);
	String hobby = c.getData(2, 5);
	String lang = c.getData(2, 6);
	String skils = c.getData(2, 7);
	String Coun = c.getData(2, 8);
	String selectcountry = c.getData(2, 9);
	String dob = c.getData(2, 10);
	String password = c.getData(2, 11);
	String confirmpswrd = c.getData(2, 12);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement Name = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
	c.send(Name, fName);
	WebElement lName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
	c.send(lName, "Rithu");
	WebElement addr = driver.findElement(By.xpath("//textarea[@rows='3']"));
	c.send(addr, add);
	WebElement eMail = driver.findElement(By.xpath("//input[@type='email']"));
	c.send(eMail, emailadd);
	WebElement phn = driver.findElement(By.xpath("//input[@type='tel']"));
	c.send(phn, phone);
	WebElement btnGender = driver.findElement(By.xpath("//input[@value='FeMale']"));
	c.clickBtn(btnGender);
	WebElement hob = driver.findElement(By.xpath("//input[@id='checkbox2']"));
	c.clickBtn(hob);
	Thread.sleep(3000);
	WebElement language = driver.findElement(By.xpath("//div[@id='msdd']"));
	c.send(language, lang);
	WebElement selSkills = driver.findElement(By.xpath("//select[@id='Skills']"));
	Select sk = new Select(selSkills);
	sk.selectByVisibleText(skils);
	WebElement country = driver.findElement(By.xpath("//select[@id='countries']"));
	Select ss = new Select(country);
	ss.selectByVisibleText(Coun);
	
	
	/*c.send(list.get(0), fName);
		c.send(list.get(1), add);
		c.send(list.get(2), emailadd);
		c.send(list.get(3), phone);
		c.send(list.get(4), gender);
		c.send(list.get(5), hobby);
		c.send(list.get(6), lang);
		c.send(list.get(7), skils);
		c.send(list.get(8), Coun);
		c.send(list.get(9), selectcountry);
		c.send(list.get(10), dob);
		c.send(list.get(11), password);
		c.send(list.get(12), confirmpswrd);*/
		
	
	
}
}

