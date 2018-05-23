package com.sample.clearTrip.ct.Impl.ctPages;

import com.sample.clearTrip.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static LoginPage getInstance(){
        return PageFactory.initElements(Driver.driver, LoginPage.class);
    }

    //WebElements

    //Methods

}
