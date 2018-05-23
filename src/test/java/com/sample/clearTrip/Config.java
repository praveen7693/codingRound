package com.sample.clearTrip;

import com.sample.clearTrip.utils.CommonUtil;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

public class Config {

    private static boolean isInit = false ;
    private static String path = null ;
    private static Properties prop = null ;

    public Config() {
        if (isInit) {
            return ;
        }
        init();
    }

    private void init() {

        Config.path = "/config.properties" ;
        prop = CommonUtil.loadProperties(Config.path);

        if (prop == null) {
            throw new RuntimeException("Unable to load properties file: " + Config.path);
        }

        initLog4j();
        isInit = true ;

    }
    
    private static void initLog4j() {
		try {
			File file = CommonUtil.getPropertyFilePath("/log4j.xml");
			DOMConfigurator.configure(file.getAbsolutePath());
		} catch (Exception e) {
			RuntimeException fe = new RuntimeException("Couldn't initialize log4j.", e);
			throw fe ;
		}		
	}

    public static String getValue(String key) {
        return prop.getProperty(key);
    }

}
