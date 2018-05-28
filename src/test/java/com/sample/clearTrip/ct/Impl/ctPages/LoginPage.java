package com.sample.clearTrip.ct.Impl.ctPages;

import com.sample.clearTrip.utils.CommonUtil;
import com.sample.clearTrip.utils.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	Logger logger;
	public LoginPage(){
        logger = Logger.getLogger(this.getClass());
    }

    public static LoginPage getInstance(){
        return PageFactory.initElements(Driver.driver, LoginPage.class);
    }

    //WebElements
    
    @FindBy (linkText = "Your trips")
    private WebElement dropDownYourTrips;
    
    @FindBy (id = "SignIn")
    private WebElement optionSignIn;
    
    @FindBy (id = "signInButton")
    private WebElement btnSignIn;
    
    @FindBy (id = "errors1")
    private WebElement loginErrorMessage;
    
    @FindBy (id = "close")
    private WebElement closeSignInWidow;

    @FindBy (id = "modal_window")
    private WebElement frameSignIn;
    
    @FindBy (xpath = "//span[contains(@title,'Cleartrip')]")
    private WebElement home;
    
    //Methods
    
    public boolean attemptToLoginWithInvalidDetails (String userName, String password) {
    	try {
    		CommonUtil.visibilityOfElementLocated(home);
    		home.click();
    		CommonUtil.visibilityOfElementLocated(dropDownYourTrips);
    		dropDownYourTrips.click();
    		logger.info("Clicked on Your Trips dropdown successfully");
    		CommonUtil.waitFor(500);
    		CommonUtil.visibilityOfElementLocated(optionSignIn);
        	optionSignIn.click();
        	logger.info("Clicked on Sign-In option from Your trips dropdown");
        	CommonUtil.waitFor(1500);
        	
        	Assert.assertTrue(CommonUtil.switchToFrame(frameSignIn));
        	if (userName!=null) {
        		//TODO
        	}
        	if (password!=null) {
        		//TODO
        	}
        	CommonUtil.visibilityOfElementLocated(btnSignIn);
        	btnSignIn.click();
        	CommonUtil.waitFor(2000);
            String errors1 = loginErrorMessage.getText();
            Assert.assertTrue(errors1.contains("There were errors in your submission"));
            logger.info("Verified Error message successfully");
            CommonUtil.switchtoDefaultFrame();
            CommonUtil.waitFor(500);
            closeSignInWidow.click();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
}
