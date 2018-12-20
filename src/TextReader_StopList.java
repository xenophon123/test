import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/**
 * this class scans the stop-list.txt and stores the words of the txt in an ArrayList
 * @author zhenyan
 *
 */
public class TextReader_StopList {

	ArrayList<String> ReadLetter(String fileName) throws ParseException {
		
		ArrayList<String> res = new ArrayList<>();
		
		try {
			Scanner scan = new Scanner(new File(fileName)); // file name as needed 

			
			while (scan.hasNextLine()) {
			    String line = scan.nextLine();
			    line.trim();
			    res.add(line);
			     
			    	
			}
			scan.close();
		}
		
		catch(IOException e) {
	    	System.out.println("Error reading file ");
	    	e.printStackTrace();
	    }		
		
		return res;
	}
	
	
}
