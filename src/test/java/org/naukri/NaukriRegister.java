package org.naukri;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriRegister extends UtilClass{
public NaukriRegister() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//button[text()='I am a Fresher']")
private WebElement btnPress;

public WebElement getBtnPress() {
	return btnPress;
}


}
