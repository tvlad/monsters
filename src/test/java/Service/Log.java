package Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
	
	public static void logToFile(String text, String fileName) throws IOException {
		
//		fileName = "my-logs/log-" + Help.CurDateString() + ".txt" ;
//		System.out.println(fileName);
		FileWriter fstream = new FileWriter(fileName, true);
		BufferedWriter out = new BufferedWriter(fstream);
		
		out.newLine();
		out.write(text);
		out.newLine();
		out.close();

	}

}
