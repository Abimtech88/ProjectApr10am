package org.adacin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking extends HelperClass {
	public Booking() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement firstname;
	
	@FindBy(id="last_name")
	private WebElement lastname;
	
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement credit;
	
	@FindBy(xpath="//select[@id='cc_type']")
	private WebElement credittype;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
	private WebElement year;
	
	@FindBy(id="cc_cvv")
	private WebElement ccvv;
	
	@FindBy(id="book_now")
	private WebElement booknow;

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCredit() {
		return credit;
	}

	public WebElement getCredittype() {
		return credittype;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getCcvv() {
		return ccvv;
	}

	public WebElement getBooknow() {
		return booknow;
	}
	
	@FindBy(id="search_hotel")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(id="order_no")
	private WebElement text;

	public WebElement getText() {
		return text;
	}
	
	
	
	
}
