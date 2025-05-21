package client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiKeyProvider {

    public static String getApiKey() {
        try (FileInputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("api.key");

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar config.properties" + e);
        }
    }
}
