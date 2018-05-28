package com.sample.clearTrip.ct.Impl.ctPages;

import com.sample.clearTrip.utils.CommonUtil;
import com.sample.clearTrip.utils.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class FlightsPage {

    Logger logger;
    public FlightsPage(){
        logger = Logger.getLogger(this.getClass());
    }

    public static FlightsPage getInstance() {
        return PageFactory.initElements(Driver.driver, FlightsPage.class);
    }

    //WebElements

    @FindBy (id = "OneWay")
    private WebElement radioBtnOneWay;

    @FindBy (id = "FromTag")
    private WebElement textBoxFrom;

    @FindBy (id = "ToTag")
    private WebElement textBoxTo;

    @FindBy (id = "SearchBtn")
    private WebElement btnSearch;

    @FindBy (xpath = "//*[@id='Home']//li[@class='flightApp']/a[1]")
    private WebElement tabFlights;
    
    @FindBy (id = "DepartDate")
    private WebElement textBoxDate;

    @FindBy (className = "searchSummary")
    private WebElement searchSummary;
    
    @FindBy (xpath = "//span[contains(@title,'Cleartrip')]")
    private WebElement home;

    //Methods

    public boolean searchOneWayFlight (String startingPoint, String destination, String date, Map<String, Integer> passengerList) {
        try {
        	CommonUtil.visibilityOfElementLocated(home);
        	home.click();
        	CommonUtil.visibilityOfElementLocated(tabFlights);
            tabFlights.click();
            logger.info("Flights tab selected successfully");
            
            radioBtnOneWay.click();
            logger.info("Clicked on oneway radio button successfully");

            textBoxFrom.clear();
            textBoxFrom.sendKeys(startingPoint);
            logger.info("Entered Starting point successfully");
            CommonUtil.waitFor(1000);
            List<WebElement> originOptions = CommonUtil.returnWebElements("//*[@id='ui-id-1']/li");
            originOptions.get(0).click();
            logger.info("Selected first item from origin auto complete list");

            textBoxTo.clear();
            textBoxTo.sendKeys(destination);
            logger.info("Entered destination point successfully");
            CommonUtil.waitFor(1000);
            //select the first item from the destination auto complete list
            List<WebElement> destinationOptions = CommonUtil.returnWebElements("//*[@id='ui-id-2']/li");
            destinationOptions.get(0).click();
            logger.info("Selected first item from destination auto complete list");

            CommonUtil.waitFor(1000);
            textBoxDate.clear();
            CommonUtil.waitFor(1000);
            textBoxDate.sendKeys(date);
            logger.info("Entered Date successfully");
            
            if(passengerList!=null) {
            	//TODO
            }
            
            //all fields filled in. Now click on search
            //Assert.assertTrue(CommonUtil.visibilityOfElementLocated(btnSearch), "Search button not found");
            btnSearch.click();
            logger.info("Clicked on Search button successfully");

            //verify that result appears for the provided journey search
            Assert.assertTrue(CommonUtil.visibilityOfElementLocated(searchSummary), "Search result summary not found");
            logger.info("Verified Search summary successfully");
            CommonUtil.waitFor(1000);

        }
        catch (Exception e) {
            logger.info("Search for Oneway Flight Failed!!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
