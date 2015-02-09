package Testing;

import java.io.FileNotFoundException;
import java.util.HashMap;

import ba.BITCamp.logger.Logger;

public class Test {
	public static void main(String[] args) {
		HashMap<String, String> test = new HashMap<String, String>();
		test.put("application", "application");
		test.put("error", "error");
		test.put("warning", "warning");
		
		try {
			new Logger(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Logger.log("application", "application");
		Logger.log("error", "error");
		Logger.log("warning", "warning");
	}

}
