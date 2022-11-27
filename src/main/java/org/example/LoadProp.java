package org.example;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProp {

    static Properties prop;
    static String propertiesFileLocation = "src/test/java/TestConfig/";
    static String propertiesFileName = "TestData.properties";
    static FileInputStream input;

    public static String getProperty(String key) {
        prop = new Properties();
        try {
//            we are using this way for called file
//           input = new FileInputStream(src/test/java/TestConfig/TestData.properties);
//            in below method we are making file method for making a reusable access from other location as well
            input = new FileInputStream(propertiesFileLocation + propertiesFileName);
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);

    }
//its just for the checking the all provided data is working fine
    @Test
    public void readKeys() {
        System.out.println(getProperty("url"));
        System.out.println(getProperty("FirstName"));
    }

}
