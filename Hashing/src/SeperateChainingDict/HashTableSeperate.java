package SeperateChainingDict;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableSeperate implements Hash{
	private int size;
	private ArrayList<LinkedList<String>> ht = new ArrayList<>();
	public HashTableSeperate(){
		this.size = 1000;
		for(int i = 0; i < this.size; i++){
			ht.add(new LinkedList<>());
		}
	}
	public HashTableSeperate(int size){
		this.size = size;
		for(int i = 0; i < this.size; i++){
			ht.add(new LinkedList<>());
		}
	}
	private static int char2int(char ch) {
		return (int)ch - 64;
	}
	public int hash2(String str) {
		int sum = 0;
		int exp = 1;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int num = char2int(ch) * exp;
			sum += num;
			exp = exp * 26;
		}
		return sum % size;
	}
	@Override
	public boolean put(String word, String meaning) {
		int key = hash2(word);
		ht.get(key).add(meaning);
		return true;
	}
	@Override
	public List<String> get(String word) {
		int key = hash2(word);
		LinkedList<String> temp = ht.get(key);
		return temp;
	}
	@Override
	public void getAll() {
		for(int i = 0; i < size; i++){
			if(!(ht.get(i).isEmpty()))
				System.out.println(ht.get(i));
		}
	}
	@Override
	public boolean delete(String word) {
		int index = hash2(word);
		if(ht.get(index).isEmpty())
			return false;
		ht.set(index, new LinkedList<String>());
		return true;
	}
	
	
}
