package com.sample.clearTrip.ct.Impl.ctPages;

import com.sample.clearTrip.utils.CommonUtil;
import com.sample.clearTrip.utils.Driver;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HotelsPage {

	Logger logger;
	public HotelsPage(){
        logger = Logger.getLogger(this.getClass());
    }
	
    public static HotelsPage getInstance() {
        return PageFactory.initElements(Driver.driver, HotelsPage.class);
    }

    //WebElements
    
    @FindBy (xpath = "//*[@id='Home']//li[contains(@class,'hotelApp')]/a[1]")
    private WebElement tabHotels;

    @FindBy(id = "Tags")
    private WebElement textBoxLocality;

    @FindBy(id = "SearchHotelsButton")
    private WebElement BtnSearch;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(id = "CheckInDate")
    private WebElement boxCheckInDate;
    
    @FindBy(id = "CheckOutDate")
    private WebElement boxCheckOutDate;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//a[contains(@class,'nextMonth')]")
    private WebElement moveToNextMonth;
    
    @FindBy (className = "searchSummary")
    private WebElement searchSummary;

    //Methods
    
    public boolean searchHotels (String location, String checkInDate, String checkOutDate, String travellers) {
    	try {
    		CommonUtil.visibilityOfElementLocated(tabHotels);
    		tabHotels.click();
    		logger.info("Clicked on hotels tab successfully");
    		CommonUtil.waitFor(500);
    		textBoxLocality.clear();
    		CommonUtil.waitFor(500);
    		textBoxLocality.sendKeys(location);
    		logger.info("Entered Location details successfully");
    		CommonUtil.waitFor(2000);
    		List<WebElement> locationOptions = CommonUtil.returnWebElements("//*[@id='ui-id-1']//li[text()='Locations']/following-sibling::li");
    		locationOptions.get(0).click();
    		logger.info("Selected first item from locations auto complete list");
    		CommonUtil.waitFor(1000);

    		selectDate(boxCheckInDate, checkInDate);
            logger.info("Selected Chech-In Date successfully");
            CommonUtil.waitFor(1000);
            
            selectDate(boxCheckOutDate, checkOutDate);
            logger.info("Entered Check-Out Date successfully");
            CommonUtil.waitFor(1000);
            
            new Select(travellerSelection).selectByVisibleText(travellers);
            logger.info("Selected rooms successfully");
            CommonUtil.waitFor(500);
            BtnSearch.click();
            logger.info("Clicked on search button successfully");
            CommonUtil.waitFor(1000);
            Assert.assertTrue(CommonUtil.visibilityOfElementLocated(searchSummary), "Unable to verify Search summary");
            logger.info("Verified Search Summary successfully");
    	}
    	catch (Exception e) {
    		logger.info("Search hotel Failed!");
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public void selectDate (WebElement element, String date){
    	String[] dateArr = date.split("-");
    	int d = Integer.parseInt(dateArr[0]);
    	int m = Integer.parseInt(dateArr[1])-1;
    	int y = Integer.parseInt(dateArr[2]);
    	
    	int count = 0;
    	while (count<=12) {
    		
    		try {
    			WebElement wbDate = CommonUtil.returnWebElement("//*[@id='ui-datepicker-div']//td[@data-month='"+m+"' and @data-year='"+y+"']/a[text()='"+d+"']");
    			CommonUtil.visibilityOfElementLocated(wbDate, 2);
    			wbDate.click();
    			break;
    		}
    		catch (Throwable t) {
    			moveToNextMonth.click();
    			++count;
    		}
    	}
    }

}
