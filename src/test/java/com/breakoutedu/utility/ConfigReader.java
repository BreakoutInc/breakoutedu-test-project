package com.breakoutedu.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


        private  static Properties properties = new Properties();

        static {
            try {
                FileInputStream in = new FileInputStream(System.getProperty("environment")+".properties");
                properties.load(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
         String environment = System.getProperty("environment"); //read environment name
          ConfigFactory.setProperty("env", environment);
         */

        public static String read(String key){
            return properties.getProperty(key) ;
        }
}
