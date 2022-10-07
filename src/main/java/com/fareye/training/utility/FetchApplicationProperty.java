package com.fareye.training.utility;
import org.springframework.stereotype.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@Component
public class FetchApplicationProperty {
    InputStream inputStream;
    public Properties getPropValues() throws IOException {
        Properties prop = null;
        try {
            prop = new Properties();
            String propFileName = "application.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("file:'" + propFileName + "' not found ");
            }

            Iterator hmIterator = prop.entrySet().iterator();

            System.out.println("HashMap after adding bonus marks:");
            while (hmIterator.hasNext()) {

                Map.Entry mapElement = (Map.Entry) hmIterator.next();
                String value = (String) mapElement.getValue();

                System.out.println(mapElement.getKey() + " : " + value);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return prop;
    }
}