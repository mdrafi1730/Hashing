package LinearProbingDict;
public class HashingLinear implements Hash {
	private String[] word;
	private String[] meaning;
	private int size;
	public HashingLinear() {
		super();
		this.size = 1000000;
		this.word = new String[size];
		this.meaning = new String[size];
	}
	public HashingLinear(int size) {
		super();
		this.size = size;
		this.word = new String[size];
		this.meaning = new String[size];
	}
	public int charToInt(char ch){
		return (int)ch - 64;
	}
	public int hash2(String str){
		int sum = 0;
		int exp = 1;
		for(int i = 0; i < str.length(); i++){
			int temp = charToInt(str.charAt(i)) * exp;
			sum += temp;
			exp *= 26;
		}
		return sum % 10;
	}
	@Override
	public boolean put(String word, String meaning) {
		int key = hash2(word);
		if(this.meaning[key] != null && this.meaning[key].compareTo(meaning) != 0){
			for(int i=0; i<this.size; i++){
				int j = (i + key) % this.size;
				if(this.meaning[j] == null){
					this.word[j] = word;
					this.meaning[j] = meaning;
					return true;
				}	
			}
		}else{
			this.word[key] = word;
			this.meaning[key] = meaning;
			return true;
		}
		return false;
	}
	@Override
	public String get(String word) {
		int index = hash2(word);
		String temp = "";
		while(index < size && this.word[index] != null){
			if(this.word[index].compareTo(word) == 0) 
				temp += this.meaning[index] + "\n";
			index++;
		}
		return temp;
	}
	@Override
	public void getAll() {
		for(int i = 0; i < this.size; i++){
			if(this.meaning[i] != null)
				System.out.print("Word[" + i + "] "
					+ "= " + this.word[i] + " and Meaning =  " + "= " + 
						this.meaning[i] + "\n");
		}
	}
	@Override
	public boolean delete(String word) {
		int index = hash2(word);
		int status = 0;
		while(index < this.size && this.word[index] != null){
			if(this.word[index].compareTo(word) == 0){
				this.word[index] = null;
				this.meaning[index] = null;
				status = 1;
			}
			index++;
		}
		if(status == 1)
			return true;
		else
			return false;
	}
}