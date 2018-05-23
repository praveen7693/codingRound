package com.sample.clearTrip.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtil {

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        FileInputStream fis = null ;
        try {
            File file = getPropertyFilePath(path);
            fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();
        } catch (Exception e) {
            return null ;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return properties ;
    }

    public static File getPropertyFilePath(String path) throws URISyntaxException {
        URL url = path.getClass().getResource(path);
        File inputFile = new File(url.toURI());
        return inputFile ;
    }

    public static boolean launchBrowser(String url){
        try{

            Driver.driver.get(url);
            Driver.driver.manage().window().maximize();
            implicitWait(30);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void closeTheDriver(){
        Driver.driver.quit();
    }

    public static void implicitWait(int timetowaitInSec){
        Driver.driver.manage().timeouts().implicitlyWait(timetowaitInSec, TimeUnit.SECONDS);
    }

    public static void ExplicitWaitForElement(WebElement element){
        try{
            implicitWait(0);
            WebDriverWait wb=new WebDriverWait(Driver.driver, 90);
            wb.until(ExpectedConditions.visibilityOf(element));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private boolean isElementPresent(String xpath) {
        try {
            Driver.driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static WebElement returnWebElement(String xpath){
        return Driver.driver.findElement(By.xpath(xpath));
    }
    
    public static List<WebElement> returnWebElements(String xpath){
		return Driver.driver.findElements(By.xpath(xpath));
	}

    public static boolean visibilityOfElementLocated(String xpath){
        try{
            implicitWait(0);
            WebDriverWait wb=new WebDriverWait(Driver.driver, 60);
            wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public static boolean visibilityOfElementLocated(WebElement element){
        try{
            implicitWait(0);
            WebDriverWait wb=new WebDriverWait(Driver.driver, 60);
            wb.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception e){
            return false;
        }
        return true;
    }

}
