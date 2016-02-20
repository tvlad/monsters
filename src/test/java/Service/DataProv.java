package Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;


public class DataProv {
	
	@DataProvider (name = "textFromFile")
	public static List<String> readText (){
		List<String> list = new ArrayList<String>();
		File file = new File("textMessLorem.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while (s != null) {
				list.add(s);
				s = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

//	-------------------------------------------------------------------
	public static String prop(String property) {
		Properties prop = new Properties();
		InputStream input = null;
		String ghj = null;
		
		try {
			 
			input = new FileInputStream("config.properties");
	
			// load a properties file
			prop.load(input);
	
			// get the property value and print it out
			ghj = prop.getProperty(property);
		
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 		
		return ghj;
	}

}
