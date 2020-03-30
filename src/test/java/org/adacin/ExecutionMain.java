package org.adacin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class ExecutionMain {
	WebDriver driver;
public static void main(String[] args) throws IOException, InterruptedException {

HelperClass h = new HelperClass();	
	WebDriver driver = h.getDriver();
	h.loadUrl("http://adactin.com/HotelApp/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String user = h.getData(5, 0);
		String pass = h.getData(5, 1);
		String sloc = h.getData(8, 0);
		String shotel = h.getData(8, 1);
		String sroomType = h.getData(8, 2);
		String sroomNo = h.getData(8, 3);
		String sdateout = h.getData(8, 4);
		String sdatein = h.getData(8, 5);
		String sadultRoom = h.getData(8, 6);
		String sChildRoom = h.getData(8, 7);
					
		String fName = h.getData(13, 0);
		String lName = h.getData(13, 1);
		String address = h.getData(13, 2);
		String credit = h.getData(13, 3);
		String creditType = h.getData(13, 4);
		String mon = h.getData(13, 5);
		String year = h.getData(13, 6);
		String ccvv = h.getData(13, 7);
		
		LoginPage l = new LoginPage();
		
		h.send(l.getUserName(), user);
		h.send(l.getPassword(), pass);
		h.clickBtn(l.getBtnLogin());
		
		SearchPage sp = new SearchPage();
		
		h.chooseByVisibleText(sp.getSelectLocation(), sloc);
		h.chooseByVisibleText(sp.getSelectHotels(), shotel);
		h.chooseByVisibleText(sp.getSelectRoomType(), sroomType);
		h.chooseByVisibleText(sp.getRooms(), sroomNo);
		h.send(sp.getCheckOut(), sdateout);
		h.send(sp.getCheckIn(), sdatein);
		h.chooseByVisibleText(sp.getAdultsRoom(), sadultRoom);
		h.chooseByVisibleText(sp.getChildRoom(), sChildRoom);
		h.clickBtn(sp.getSearch());
		
		SelectPage ssp = new SelectPage();
		
		h.clickBtn(ssp.getButton());
		h.clickBtn(ssp.getCtnbtn());
		
		Booking bpage = new Booking();
		
		h.send(bpage.getFirstname(), fName);
		h.send(bpage.getLastname(), lName);
		h.send(bpage.getAddress(), address);
		h.send(bpage.getCredit(), credit);
		h.chooseByVisibleText(bpage.getCredittype(), creditType);
		h.chooseByVisibleText(bpage.getMonth(),mon);
		h.chooseByVisibleText(bpage.getYear(),year);
		h.send(bpage.getCcvv(),ccvv);
		h.clickBtn(bpage.getBooknow());
		
		
		String val = h.getAttribute(bpage.getText());
		System.out.println(val);
		
		h.writeData(17, 0, val);
		
		
		
		
		
	
		
	
	
	
}
}
