import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCConfig {
    private static final String PROPERTIES_FILE = "resources/config.properties";

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(input);

            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            System.out.println("JDBC URL: " + url);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}