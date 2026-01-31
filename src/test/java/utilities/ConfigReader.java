package utilities;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	public class ConfigReader {

	    public static Properties prop;

	    public static void loadProperties() {

	       FileInputStream fis;
	       try {
	          fis = new FileInputStream("src/test/resources/config.properties");
	          prop = new Properties();
	          try {
	             prop.load(fis);
	          } catch (IOException e) {
	             e.printStackTrace();
	             throw new RuntimeException("Config properties file not found");
	          }
	       } catch (FileNotFoundException e) {
	          e.printStackTrace();

	       }
	    }

	    public static Properties getProp() {
	       return prop;
	    }
	    
	    public static String getProperty(String key) {
	       if (prop == null) {
	          throw new RuntimeException("Config file is not loaded");
	       }
	       return prop.getProperty(key);
	    }
	    
	    public static void setBrowserType(String browserName) {
	       if (prop == null) {
	          throw new RuntimeException("Config file is not loaded");
	       }
	       prop.setProperty("browser", browserName);
	    }

	}



