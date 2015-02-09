package ba.BITCamp.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Creates loggs and saves it in file
 * @warning loger must have folder "logs"
 * @author eminamuratovic
 *
 */
public class Logger {
	private static HashMap<String, FileOutputStream> logs = new HashMap<String, FileOutputStream>();
	
	/**
	 * initialize FileOutputStreams for types of the logs
	 * @param logType HashMap: key: type of log ; value: name of the file
	 * @throws FileNotFoundException
	 */
	public Logger(HashMap<String, String> logType) throws FileNotFoundException {
		String basePath = "." + File.separator + "logs" + File.separator;
		Set<String> k = logType.keySet(); 
		Iterator<String> iterator = k.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			String value = logType.get(key);
			File f = new File(basePath + value + ".txt");
			FileOutputStream fos = new FileOutputStream(f, true); //if we add true then data in the file won't be deleted
			logs.put(key, fos);
			
			
		}
	}

	/**
	 * This method takes message and adds date on it and saves it in a file
	 * @warning if type is not initialized, log is not saved
	 * @param type String type of the log
	 * @param message String message we want to send
	 */
	public static void log(String type, String message) {
		if(!logs.containsKey(type))
			return;
		Date d = new Date();
		message = d.toString() + " " + message + "\n";
		FileOutputStream fos = logs.get(type);
		try {
			fos.write(message.getBytes());
			fos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
