package sa.edu.yuc;
import java.util.Scanner;
public class Word implements Comparable<Word> {
	private String word;
	private String meaning;
	public Word(String word, String meaning) {
		super();
		this.word = word;
		this.meaning = meaning;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	@Override
	public String toString() {
		return "[word=" + word + ", meaning=" + meaning + "]-->";
	}
	public static Word readWord(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the word = ");
		String word = input.nextLine();
		System.out.print("Enter it's meaning = ");
		String meaning = input.nextLine();
		return (new Word(word, meaning));
	}
	@Override
	public int compareTo(Word o) {
		if(this.meaning.compareTo(o.meaning) > 0)
			return 1;
		else if (this.meaning.compareTo(o.meaning) < 0)
			return -1;
		else
			return 0;
	}
}