package org.adacin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPage extends HelperClass{
	public SelectPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement button;
	
	

	public WebElement getButton() {
		return button;
	}
	
	@FindBy(id="continue")
	private WebElement ctnbtn;



	public WebElement getCtnbtn() {
		return ctnbtn;
	}
}
