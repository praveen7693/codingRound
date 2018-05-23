package com.sample.clearTrip.utils;

import com.sample.clearTrip.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver driver = browserFactory();

    public static WebDriver browserFactory(){
        String browserType=Config.getValue("BROWSER_TYPE");
        if(browserType.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", Config.getValue("CHROME_DRIVER"));
            driver = new ChromeDriver();
        } else if(browserType.equals("firefox")){
            //TODO
        } else if(browserType.equals("ie")){
			//TODO
        } else if(browserType.equals("safari")){
            //TODO
        }

        return driver;

    }

}
