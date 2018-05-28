package com.sample.clearTrip.smokeTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.clearTrip.BaseTest;

public class SignInTest extends BaseTest {
	
	public SignInTest() {
		logger = Logger.getLogger(this.getClass());
	}

    @Test (priority = 1)
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	logger.info("shouldThrowAnErrorIfSignInDetailsAreMissing test started");
    	Assert.assertTrue(navigator.attemptToLoginWithInvalidDetails(null, null));
    	logger.info("shouldThrowAnErrorIfSignInDetailsAreMissing executed successfully");
    }

}
