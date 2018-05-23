package com.sample.clearTrip.ct.Impl.ctPages;

import com.sample.clearTrip.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {

    public static  HotelsPage getInstance() {
        return PageFactory.initElements(Driver.driver, HotelsPage.class);
    }

    //WebElements

    //Methods

}
