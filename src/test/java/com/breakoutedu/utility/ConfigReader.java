package com.breakoutedu.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


        private  static Properties properties = new Properties();

        static {
            try {
                Properties props = new Properties();
                props.load(ConfigReader.class.getClassLoader().getResourceAsStream("project.properties"));
                String env = props.getProperty("env");


               FileInputStream in = new FileInputStream(env+".properties");
                //FileInputStream in = new FileInputStream("${env}.properties");
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
