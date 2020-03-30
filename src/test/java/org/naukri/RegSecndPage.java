package org.naukri;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegSecndPage extends UtilClass {
	public RegSecndPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="fname")
	private WebElement name;
	
	@FindBy(id="email")
	private WebElement eMail;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pass;
	
	@FindBy(xpath="//input[@name='number']")
	private WebElement phNo;
	
	@FindBy(xpath="(//input[@name='city'])[1]")
	private WebElement loc;
	


	public WebElement getName() {
		return name;
	}
	
	
	
	
}
