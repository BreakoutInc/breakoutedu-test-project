package com.breakoutedu.utility;

import io.cucumber.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;

public class EnvironmentTest {


        Environment testEnvironment;

        @Test
        public void functionalTest() {
//            System.out.println(testEnvironment.browser());
//            System.out.println(testEnvironment.getDBHostname());
//            System.out.println(testEnvironment.getDBPassword());
        }

        @Before
        public void beforeTest() {
            String environment = System.getProperty("environment"); //read environment name
            ConfigFactory.setProperty("env", environment); //use environment name for reading proper file
            testEnvironment = ConfigFactory.create(Environment.class); //here we create an instance of the Environment interface & access the property file
        }

}
