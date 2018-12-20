/**
 * this class creates textWord object which contains string and its corresponding frequencies.
 * @author zhenyan
 *
 */
public class TextWord implements Comparable<TextWord>{
	
	private String word;
	private int countWord;
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCountWord() {
		return countWord;
	}
	public void setCountWord(int countWord) {
		this.countWord = countWord;
	}
	@Override
	public int compareTo(TextWord txtWord) {
	    String compareStr = ((TextWord)txtWord).getWord();
		return this.word.compareTo(compareStr);
	}
	
	
}
