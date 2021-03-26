import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Example {


@Test
    public void getData() throws IOException {
        Properties prop= new Properties();
        FileInputStream fis= new FileInputStream("src/test/java/com/freecrm/config/config.properties");
        prop.load(fis);
        String url= prop.getProperty("URL");
        System.out.println(url);
    }
}
