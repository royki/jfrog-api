package com.jfrog.base;

import java.io.File;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jfrog.pojo.UserPojo;

import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class Base {

    private static final Logger LOGGER = Logger.getLogger(Base.class);

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String CURRENT_DIR = System.getProperty("user.dir");
    public static final String RESOURCES_DIR = ("/src/test/resources/");
    public static final String TEST_RESOURCES = (CURRENT_DIR + RESOURCES_DIR);
    public static final String TESTData_Dir = (TEST_RESOURCES + "/testdata/");
    
    public RequestSpecification REQUEST;
    static Properties property = new Properties();
    public static String username = getUser().getUsername().toString(); // "jfroguser";
    public static String password = getUser().getPassword().toString(); // "JFr0g123";

	public Base() {
        try {            
            // FileInputStream config = new FileInputStream(TEST_RESOURCES + "config.properties");
            // property.load(config);
            // property.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            RestAssured.baseURI = "http://localhost"; // property.getProperty("url");
            RestAssured.port = 8082; // property.getProperty("port");            

        } catch (Exception e) {
            e.printStackTrace();
        }
        REQUEST = RestAssured.given().auth().basic(username, password).contentType(ContentType.JSON);
        LOGGER.info(REQUEST);
    }

    public static UserPojo getUser() {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        UserPojo user = null; 
        try {
            String userFile = (TESTData_Dir + "users.yml");
            user =  om.readValue(new File(userFile), UserPojo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
