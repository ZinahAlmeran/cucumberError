package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader { // we use it to read the data from the file

    public static  String readProperty(String key){
        File file = new File("configuration.properties");
        Properties properties = new Properties();
        //this object will read the properties file

        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
