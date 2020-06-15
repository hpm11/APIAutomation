package maven.demo.RestAssuredAuto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	
	public static Properties loadConfigFile(String env){
		Properties configproperties = new Properties();
		try{
			configproperties.load(new FileReader("config/" +env+".properties"));
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return configproperties;
	}

}
