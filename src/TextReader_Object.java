import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * This class uses ArrayList data structure to read the letters and words of required books 
 * and add letters/words and their corresponding frequencies to the database. 
 * @author zhenyan
 *
 */
public class TextReader_Object {

	// read letter 
	/**
	 * this method reads the letter of the required books
	 * @param fileName
	 * @return an arraylist of letters object and the corresponding frequencies 
	 * @throws ParseException
	 */
		ArrayList<Text> ReadLetter(String fileName) throws ParseException {
			
			ArrayList<Text> res = new ArrayList<>();
			
			try {
				Scanner scan = new Scanner(new File(fileName)); // file name as needed 
				while (scan.hasNextLine()) {
				    String line = scan.nextLine();
				    char[] split = line.toCharArray();
				    
				    for(char i: split) {
				    	if(Character.isLetter(i)) {
				    		boolean exist = false;    		
				    		for(Text j: res) {
				    			if(j.getLetter() == i) {
				    				j.setCountLetter(j.getCountLetter()+1);
				    				exist = true;
				    				break; 
				    			}
				    		}	
				    		
				    		if(exist == false) {
				    			Text txt = new Text();
					    		txt.setLetter(i);
			    				txt.setCountLetter(1);
			    				res.add(txt);
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
	     * @return an arraylist of words object and the corresponding frequencies 
		 * @throws ParseException
		 */
		ArrayList<TextWord> ReadWord(String fileName) throws ParseException {
			
			ArrayList<TextWord> res = new ArrayList<>();

			try {
				Scanner scan = new Scanner(new File(fileName)); // file name as needed 

				
				while (scan.hasNextLine()) {
				    String line = scan.nextLine();
				    String[] split = line.split("[^A-Za-z']");
				    
				    for(String i: split) {
				    	i = i.toLowerCase();
				    	boolean isAMatch = i.matches("^[a-zA-Z].*'.*[a-zA-Z]$");
				    	if(isAMatch) {
			    			int exist = 0;					    		
				    		for(TextWord j: res) {
				    			if(j.getWord().equals(i)) {					    				
				    				j.setCountWord(j.getCountWord()+1);
				    				exist = 1;
				    				break;
				    			}					    			
				    		}
				    		if(exist == 0) {
							    TextWord txtW = new TextWord();
				    			txtW.setWord(i);
				    			txtW.setCountWord(1);
				    			res.add(txtW);					    		
				    		}					    		
				    	}
				    	else {
				    		i = i.replaceAll("[^a-zA-z]", ""); // remove all non-letter elements
				    		i = i.replaceAll("_", "");
				    		
				    		if(!i.equals("")) {
				    			int exist1 = 0;
				    			for(TextWord j: res) {
				    				if(j.getWord().equals(i)) {
					    				j.setCountWord(j.getCountWord()+1);
					    				exist1 = 1;
					    				break;
					    			}	
					    		}
				    			if(exist1 == 0) {
								    TextWord txtW = new TextWord();
					    			txtW.setWord(i);
					    			txtW.setCountWord(1);
					    			res.add(txtW);					    		
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
	     * @return an arraylist of filtered words object and the corresponding frequencies 
		 * @throws ParseException
		 */
		ArrayList<TextWord> ReadWordFilter(String fileName, ArrayList<String> stopList) throws ParseException {
			
			ArrayList<TextWord> res = new ArrayList<>();

			try {
				Scanner scan = new Scanner(new File(fileName)); // file name as needed 

				
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] split = line.split(" ");
				    
				    for(String k: split) {
				    	k = k.toLowerCase();
				    	String[] innerSplit = k.split("-"); 
				    	
				    	for(String i: innerSplit) {
				    		boolean isAMatch = i.matches("^[a-zA-Z].*'.*[a-zA-Z]$");
					    	if(isAMatch) {	
					    		if(!stopList.contains(i)) {
						    		int exist = 0;
						    		for(TextWord j: res) {
						    			if(j.getWord().equals(i)) {
						    				j.setCountWord(j.getCountWord()+1);
						    				exist = 1; 
						    				break; 
						    			}					    			
						    		}
						    		
						    		if(exist == 0) {
									    TextWord txtW = new TextWord();
						    			txtW.setWord(i);
					    				txtW.setCountWord(1);
					    				res.add(txtW);
						    		}
					    		}
					    	}
					    	else {
					    		i = i.replaceAll("[^a-zA-Z]", ""); // remove all non-letter elements
					    		i = i.replaceAll("_", "");
					    		
					    		if(!i.equals("") && !stopList.contains(i)) {
					    			int exist1 = 0; 
						    		for(TextWord j: res) {
						    			if(j.getWord().equals(i)) {
						    				j.setCountWord(j.getCountWord()+1);
						    				exist1 = 1; 
						    				break;
						    			}
						    		}
					    			if(exist1 == 0) {
									    TextWord txtW = new TextWord();
					    				txtW.setWord(i);
					    				txtW.setCountWord(1);
					    				res.add(txtW);
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
