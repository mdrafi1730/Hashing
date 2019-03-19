package sa.edu.yuc;
import java.util.ArrayList;
import java.util.List;
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
	public List<T> get(String word) {
		int key = hash2(word);
		DoublyLinkedList<T> temp = ht.get(key);
		ArrayList<T> t = new ArrayList<>(); 
		if(!(temp.isEmpty()))
			t.add((T) temp.toString());
		return t;
	}
	@Override
	public void getAll() {
		for(int i = 0; i < this.size; i++){
			if(!(ht.get(i).isEmpty())){
				System.out.print(ht.get(i).toString());
				System.out.println("Null");
			}
		}
	}
	@Override
	public boolean delete(String word) {
		int key = hash2(word);
		DoublyLinkedList<T> temp = ht.get(key);
		if(temp.isEmpty()){
			return false;
		}else{
			ht.set(key, new DoublyLinkedListImpl<T>());
		}
		return true;
	}
}