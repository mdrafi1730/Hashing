package LinearProbingDictGenric;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HashTable<T extends Comparable<T>> implements Hash<T> {
	private int size;
	private String[] word;
	private T[] meaning;
	
	public HashTable(Class<T> cls, int size){
		this.size = size;
		this.word = new String[this.size];
		this.meaning = (T[])Array.newInstance(cls, this.size);	
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
	public boolean put(String word, T meaning) {
		int key = hash2(word);
		if(this.word[key] != null && this.meaning[key].compareTo(meaning) != 0){
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
	public List<T> get(String word) {
		int key = hash2(word);
		ArrayList<T> temp = new ArrayList<T>();
		while(key < this.size && this.word[key]!=null){
			if(this.word[key].compareTo(word) == 0)
				temp.add(this.meaning[key]);
			key++;
		}
		return temp;
	}
	@Override
	public void getAll() {
		for(int i = 0; i < this.size; i++){
			if(this.meaning[i] != null)
			System.out.println("At index = " + i + " =" + this.meaning[i]);
		}
	}
	@Override
	public boolean delete(String word) {
		int key = hash2(word);
		int status = 0;
		while(key < this.size && this.word[key] != null){
			if(this.word[key].compareTo(word) == 0){
				this.word[key] = null;
				this.meaning[key] = null;
				status = 1;
			}
			key++;
		}
		if(status == 1)
			return true;
		else
			return false;
	}
}