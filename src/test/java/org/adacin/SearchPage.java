package org.adacin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage extends HelperClass{
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='location']")
	private WebElement selectLocation;
	
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement selectHotels;
	
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement selectRoomType;
	
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement rooms;
	
	@FindBy(id="datepick_in")
	private WebElement checkIn;
	
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adultsRoom;
	
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement childRoom;
	
	@FindBy(id="Submit")
	private WebElement search;
	
	public WebElement getSearch() {
		return search;
	}

	public WebElement getSelectLocation() {
		return selectLocation;
	}

	public WebElement getSelectHotels() {
		return selectHotels;
	}

	public WebElement getSelectRoomType() {
		return selectRoomType;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getAdultsRoom() {
		return adultsRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	
	
}
