package sa.edu.yuc;

import java.util.ArrayList;


public class HashTable <T extends Comparable<T>> implements Hash<T> {
	private int size;
	private ArrayList<DoublyLinkedList<T>> ht = new ArrayList<>();
	
	public HashTable(){
		this.size = 100000;
		for(int i = 0; i < this.size; i++){
			ht.add(new DoublyLinkedListImpl<>());
		}
	}
	public HashTable(int size){
		this.size = size;
		for(int i = 0; i < this.size; i++){
			ht.add(new DoublyLinkedListImpl<>());
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
	public boolean put(String word, T meaning) {
		int key = hash2(word);
		ht.get(key).insertLast(meaning);
		return true;
	}

	@Override
	public String get(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
