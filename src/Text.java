/**
 * this class creates text object which contains character and its corresponding frequencies.
 * @author zhenyan
 *
 */
public class Text implements Comparable<Text> {
	
	private char letter;
	private int countLetter; 
	
	
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public int getCountLetter() {
		return countLetter;
	}
	public void setCountLetter(int countLetter) {
		this.countLetter = countLetter;
	}
	@Override
	public int compareTo(Text letter) {
		char compareChar = ((Text)letter).getLetter();
		return this.letter - compareChar;
	}
	
	
}
