import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
/**
 * based on the collections of letters, words, and words filtered by stop list passed by 
 * TextReader_HashMap and TextReader_Object, this class computes the top10 most frequently
 * used letters, words, and words filter by stop list using HashMap as well as ArrayList. 
 * @author zhenyan
 *
 */
public class DataAnalysis {
	
	TextReader_HashMap AnalyHash = new TextReader_HashMap();
	TextReader_Object AnalyObj = new TextReader_Object();
	TextReader_StopList stopList = new TextReader_StopList();
	
	
	// hashmap
	/**
	 * Hashmap implementation: top 10 letters 
	 * @param fileName
	 * @return TreeMap of the top 10 letters and their frequencies
	 * @throws ParseException
	 */
	TreeMap<Character, Integer> letter_Hash(String fileName) throws ParseException { 
				HashMap<Character, Integer> letterOutput = AnalyHash.ReadLetter(fileName);
				TreeMap<Character, Integer> res = new TreeMap<>();
 				ArrayList<Integer> mapValueL = new ArrayList<>();
				
				for(Character i: letterOutput.keySet()) {
					mapValueL.add(letterOutput.get(i));
				}
				
				Collections.sort(mapValueL);
				Collections.reverse(mapValueL);
				
				int Top10ValueInMapL= mapValueL.get(9);  // This will return top 10 value in the Hashmap
				
		        for (Entry<Character, Integer> entryL : letterOutput.entrySet()) {  // Itrate through hashmap
		            if (entryL.getValue() >= Top10ValueInMapL) {
		            	res.put(entryL.getKey(), letterOutput.get(entryL.getKey()));


		            }
		        }
		       
		        
		        return res; 
	}
	
	
	/**
	 * Hashmap implementation: top 10 words 
	 * @param fileName
	 * @return treeMap of the top 10 words and their frequencies
	 * @throws ParseException
	 */
	TreeMap<String, Integer> word_Hash(String fileName) throws ParseException {
		        HashMap<String, Integer> wordOutput = AnalyHash.ReadWord(fileName);
		        TreeMap<String, Integer> res = new TreeMap<>();
		        ArrayList<Integer> mapValueW = new ArrayList<>();
				
		     
		        
				for(String i: wordOutput.keySet()) {
					mapValueW.add(wordOutput.get(i));
				}
				
				Collections.sort(mapValueW);
				Collections.reverse(mapValueW);
				
				
				int Top10ValueInMapW= mapValueW.get(9);  // This will return top 10 value in the Hashmap
				
		        for (Entry<String, Integer> entryW : wordOutput.entrySet()) {  // Itrate through hashmap
		            if (entryW.getValue() >= Top10ValueInMapW) {
		            	res.put(entryW.getKey(), wordOutput.get(entryW.getKey()));


		            }
		        }
		        
		        
		        return res;         
	}
	
	
	
	/**
	 * Hashmap implementation: top 10 words filtered by stop list
	 * @param fileName
	 * @return treeMap of the top 10 words filtered by stop list and their frequencies
	 * @throws ParseException
	 */
	TreeMap<String, Integer> wordFilter_Hash(String fileName) throws ParseException {
		HashMap<String, Integer> wordOutput = AnalyHash.ReadWordFilter(fileName, stopList.ReadLetter("stop-list.txt"));
		TreeMap<String, Integer> res = new TreeMap<>();
        ArrayList<Integer> mapValueW = new ArrayList<>();
		
		for(String i: wordOutput.keySet()) {
			mapValueW.add(wordOutput.get(i));
		}
		
		Collections.sort(mapValueW);
		Collections.reverse(mapValueW);
		
		
		int Top10ValueInMapW= mapValueW.get(9);  // This will return top 10 value in the Hashmap
		
        for (Entry<String, Integer> entryW : wordOutput.entrySet()) {  // Itrate through hashmap
            if (entryW.getValue() >= Top10ValueInMapW) {
            	res.put(entryW.getKey(), wordOutput.get(entryW.getKey()));
            }
        }
		
		return res; 
	}
	
	
	
	// object
	/**
	 * ArrayList of object implementation: top 10 letters
	 * @param fileName
	 * @return ArrayList of top 10 letters and their frequencies
	 * @throws ParseException
	 */
	ArrayList<Text> letter_Obj (String fileName) throws ParseException { 
		ArrayList<Text> letterOutput = AnalyObj.ReadLetter(fileName);
		ArrayList<Text> res = new ArrayList<>();
		ArrayList<Integer> mapValueL = new ArrayList<>();
		
		for(Text i: letterOutput) {
			mapValueL.add(i.getCountLetter());
		}
		
		Collections.sort(mapValueL);
		Collections.reverse(mapValueL);
		
		int Top10ValueInMapL= mapValueL.get(9);  // This will return top 10 value
		
        for (Text i: letterOutput) {  // Itrate through ArrayList
            if (i.getCountLetter() >= Top10ValueInMapL) {
            	res.add(i);
            }
        }
        
        Collections.sort(res);
        return res; 
	}
	
	
	/**
	 * ArrayList of object implementation: top 10 words
	 * @param fileName
	 * @return ArrayList of top 10 words and their frequencies
	 * @throws ParseException
	 */
	ArrayList<TextWord> word_Obj (String fileName) throws ParseException { 
		ArrayList<TextWord> wordOutput = AnalyObj.ReadWord(fileName);
		ArrayList<TextWord> res = new ArrayList<>();
		ArrayList<Integer> mapValueL = new ArrayList<>();
		
		for(TextWord i: wordOutput) {
			mapValueL.add(i.getCountWord());
		}
		
		Collections.sort(mapValueL);
		Collections.reverse(mapValueL);
		
		int Top10ValueInMapL= mapValueL.get(9);  // This will return top 10 value 
		
        for (TextWord i: wordOutput) {  // Itrate through ArrayList
            if (i.getCountWord() >= Top10ValueInMapL) {
            	res.add(i);
            }
        }
        Collections.sort(res);
        return res; 
	}
	
	
	/**
	 * ArrayList of object implementation: top 10 words filtered by stop list
	 * @param fileName
	 * @return ArrayList of top 10 words filtered by stop list and their frequencies
	 * @throws ParseException
	 */
	ArrayList<TextWord> wordFilter_Obj (String fileName) throws ParseException { 
		ArrayList<TextWord> wordOutput = AnalyObj.ReadWordFilter(fileName, stopList.ReadLetter("stop-list.txt"));
		ArrayList<TextWord> res = new ArrayList<>();
		ArrayList<Integer> mapValueL = new ArrayList<>();
		
		for(TextWord i: wordOutput) {
			mapValueL.add(i.getCountWord());
		}
		
		Collections.sort(mapValueL);
		Collections.reverse(mapValueL);
		
		int Top10ValueInMapL= mapValueL.get(9);  // This will return top 10 value
		
        for (TextWord i: wordOutput) {  // Itrate through ArrayList
            if (i.getCountWord() >= Top10ValueInMapL) {
            	res.add(i);
            }
        }
        Collections.sort(res);
        return res; 
	}
	
}
