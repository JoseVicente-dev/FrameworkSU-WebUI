package co.com.client.webproject.test.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WritePropertiesFile {

    public static void writeFile(String websiteURL) throws IOException {
        String USER_DIR = System.getProperty("user.dir");
        String EVIDENCE_FOLDER_REPOSITORY_PATH = "/src/main/resources/evidence";
        String CONFIG_PROPERTIES_FILE_ABS_PATH =USER_DIR+"/src/main/resources/properties/configuration.properties";

        Properties properties = new Properties();
        FileInputStream input = new FileInputStream(CONFIG_PROPERTIES_FILE_ABS_PATH);
        properties.load(input);
        properties.setProperty("files.evidence",USER_DIR+EVIDENCE_FOLDER_REPOSITORY_PATH);
        properties.setProperty("app.url",websiteURL);
        properties.store(new FileOutputStream(CONFIG_PROPERTIES_FILE_ABS_PATH),null);

    }
    public static void main(String[] args) throws IOException {
        writeFile(Dictionary.WEBSITE_URL);

    }
}
