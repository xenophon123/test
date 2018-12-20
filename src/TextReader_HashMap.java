import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
/**
 * This class uses HashMap data structure to read the letters and words of required books 
 * and add letters/words and their corresponding frequencies to the database. 
 * @author zhenyan
 *
 */

public class TextReader_HashMap {
	
	
	// read letter 
	/**
	 * this method reads the letter of the required books
	 * @param fileName
	 * @return a hashmap of letters and the corresponding frequencies 
	 * @throws ParseException
	 */
	HashMap<Character, Integer> ReadLetter(String fileName) throws ParseException {
		
	    HashMap<Character, Integer> res = new HashMap<>();
	
		try {
			Scanner scan = new Scanner(new File(fileName)); // file name as needed 		
			while (scan.hasNextLine()) {
			    String line = scan.nextLine();
			    char[] split = line.toCharArray();
			    
			    for(char i: split) {
			    	if(Character.isLetter(i)) {
			    		if(res.containsKey(i)) {
			    			res.put(i, res.get(i)+1);
			    		}
			    		else {
			    			res.put(i, 1);
			    		}
			    	}
			    } 
			    	
			}
			scan.close();
		}
		
		catch(IOException e) {
	    	System.out.println("Error reading file ");
	    	e.printStackTrace();
	    }		
		
		return res;
	}
	
	
	
	
	// read word 
	/**
	 * this method reads the word of the required books
	 * @param fileName
	 * @return a hashmap of words and the corresponding frequencies 
	 * @throws ParseException
	 */
	HashMap<String, Integer> ReadWord(String fileName) throws ParseException {
		
		HashMap<String, Integer> res = new HashMap<>();
		
		
		
		try {
			Scanner scan = new Scanner(new File(fileName)); // file name as needed 
			while (scan.hasNextLine()) {
			    String line = scan.nextLine();
			    String[] split = line.split("[^A-Za-z']");
			    
			    for(String i: split) {
			    	i = i.toLowerCase();
			    	boolean isAMatch = i.matches("^[a-zA-Z].*'.*[a-zA-Z]$");				    	
			    	if(isAMatch) {			    		
			    		if(res.containsKey(i)) {
			    			res.put(i, res.get(i)+1);
			    		}
			    		else {
			    			res.put(i, 1);
			    		}
			    	}

			    	else {
			    		i = i.replaceAll("[^a-zA-Z]", ""); // remove all non-letter elements			    		
			    		if(!i.equals("")){

			    			if(res.containsKey(i)) {
				    			res.put(i, res.get(i)+1);
				    		}
				    		else {
				    			res.put(i, 1);
				    		}
			    		}    		
			    	}
			    	
			    } 	
			}
			scan.close();
		}
		
		catch(IOException e) {
	    	System.out.println("Error reading file ");
	    	e.printStackTrace();
	    }		
		
		return res;
	}

	
	
	// word with stop-list 
	/**
	 * this method reads the filtered word of the required books
	 * @param fileName
	 * @return a hashmap of filtered words and the corresponding frequencies 
	 * @throws ParseException
	 */
	HashMap<String, Integer> ReadWordFilter(String fileName, ArrayList<String> stopList) throws ParseException {
		
		HashMap<String, Integer> res = new HashMap<>();

		try {
			Scanner scan = new Scanner(new File(fileName)); // file name as needed 

			
			while (scan.hasNextLine()) {
			    String line = scan.nextLine();
			    String[] split = line.split(" ");
			    
			    for(String j: split) {
			    	j = j.toLowerCase();
			    	j = j.toLowerCase();
			    	String[] innerSplit = j.split("-"); 
			    	
			    	for(String i: innerSplit) {
			    		boolean isAMatch = i.matches("^[a-zA-Z].*'.*[a-zA-Z]$");
				    	if(isAMatch) {				    		        
				    		if(!stopList.contains(i)) {
				    				if(res.containsKey(i)) {
						    			res.put(i, res.get(i)+1);
						    		}
						    		else {
						    			res.put(i, 1);
						    		}
				    		}

				    	}
				    	else {
				    		i = i.replaceAll("[^a-zA-Z]", ""); // remove all non-letter elements
				    		i = i.replaceAll("_", "");
				    		if(!i.equals("")) {
				    			if(!stopList.contains(i)) {
					    			
				    				if(res.containsKey(i)) {
					    			res.put(i, res.get(i)+1);
				    				}
				    				else {
					    			res.put(i, 1);
				    				}
				    			}
				    		}
				    	}
			    	}	    	
			    }
			    	
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
