import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
/**
 * The main class. Print out analysis of the 9 required books and the running time of les-mis.txt
 * @author zhenyan
 *
 */
public class MainAnalysis {
	public static void main(String[] args) throws ParseException {
		
		
		TextReader_HashMap AnalyHash = new TextReader_HashMap();
		TextReader_Object AnalyObj = new TextReader_Object();
		TextReader_StopList stopList = new TextReader_StopList();
		DataAnalysis da = new DataAnalysis();
		long hashStartL = 0;
		long hashEndL = 0;
		long hashResL = 0;
		long objStartL = 0;
		long objEndL = 0;
		long objResL = 0;
		long hashStartW = 0;
		long hashEndW = 0;
		long hashResW = 0;
		long objStartW = 0;
		long objEndW = 0;
		long objResW = 0;
		
		
		
		String[] books = {"alice-in-wonderland.txt","christmas-carol.txt","huck-finn.txt","les-mis.txt","metamorphosis.txt",
				"my-man-jeeves.txt","pride-prejudice.txt","tale-of-two-cities.txt","tom-sawyer.txt"};
			
		for(String w: books) {
			System.out.println("the name of the book is " + w);
			
			// HashMap
			System.out.println("hashMap result: ");
			TreeMap<Character, Integer> letterRes = da.letter_Hash(w);
			TreeMap<String, Integer> wordRes = da.word_Hash(w);
			TreeMap<String, Integer> wordFilterRes = da.wordFilter_Hash(w);
			
			for (Character name: letterRes.keySet()){

	            String key = name.toString();
	            String value = letterRes.get(name).toString();  
	            System.out.println(key + "=" + value);  
			} 

			System.out.println();
			
			for (String name: wordRes.keySet()){

	            String key = name.toString();
	            String value = wordRes.get(name).toString();  
	            System.out.println(key + "=" + value);  
			} 
			
			System.out.println();
			
			for (String name: wordFilterRes.keySet()){

	            String key = name.toString();
	            String value = wordFilterRes.get(name).toString();  
	            System.out.println(key + "=" + value);  
			} 

			System.out.println();
			
			
			// object
			System.out.println("object result: ");
			System.out.println();
	     	ArrayList<Text> letterResObj = da.letter_Obj((w));
			ArrayList<TextWord> wordResObj = da.word_Obj((w));
			ArrayList<TextWord> wordFilterResObj = da.wordFilter_Obj((w));
				
			
			for(Text i: letterResObj) {
				System.out.println(i.getLetter() + "=" + i.getCountLetter());
			}
			
			System.out.println();
			
			for(TextWord i: wordResObj) {
				System.out.println(i.getWord() + "=" + i.getCountWord());
			}
			
			System.out.println();
			
			for(TextWord i: wordFilterResObj) {
				System.out.println(i.getWord() + "=" + i.getCountWord());
			}
			
			System.out.println();
		}
		
		
		System.out.println("Test time difference of les-mis.txt: ");
		
		hashStartL = System.currentTimeMillis();
		AnalyHash.ReadLetter("les-mis.txt");
		hashEndL = System.currentTimeMillis();
		hashResL = hashStartL - hashEndL;
		
		hashStartW = System.currentTimeMillis();
		AnalyHash.ReadWord("les-mis.txt");
		hashEndW = System.currentTimeMillis();
		hashResW = hashStartW - hashEndW;
		
		
		objStartL = System.currentTimeMillis();
     	AnalyObj.ReadLetter("les-mis.txt");
     	objEndL = System.currentTimeMillis();
     	objResL = objStartL - objEndL;
     	
     	objStartW = System.currentTimeMillis();
		AnalyObj.ReadWord("les-mis.txt");
		objEndW = System.currentTimeMillis();
		objResW = objStartW - objEndW;
		
		System.out.println("hashmap letter:" + Math.abs(hashResL) + "ms");
		System.out.println("obj letter:" + Math.abs(objResL) + "ms");
		System.out.println("hashmap word:" + Math.abs(hashResW) + "ms");
		System.out.println("obj word:" + Math.abs(objResW) + "ms");			

	}
}
