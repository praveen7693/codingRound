package com.sample.clearTrip;

import com.sample.clearTrip.ct.Impl.NavigatorImpl;
import com.sample.clearTrip.ct.Navigator;
import com.sample.clearTrip.utils.CommonUtil;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static Navigator navigator = null ;
    protected static boolean isInit = false ;
    protected Logger logger;

    public BaseTest(){
        init();
    }

    public void init(){
        if(isInit){
            return;
        }
        new Config();
        navigator = new NavigatorImpl();
        isInit=true;
    }

    @BeforeSuite
    public void beforeSuite(){
        CommonUtil.launchBrowser(Config.getValue("CT_URL"));
    }

    @AfterSuite
    public void afterSuite() {
        CommonUtil.closeTheDriver();
    }

}
