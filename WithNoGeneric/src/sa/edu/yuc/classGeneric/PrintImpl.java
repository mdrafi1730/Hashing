package sa.edu.yuc.classGeneric;

import java.lang.reflect.Array;

public class PrintImpl<T extends Comparable<T>> implements PrintInterface<T> {
	private T[] arr;
	private int capacity;
	private int size;
		
	public PrintImpl(Class<T> cls, int capacity) {
		super();
		this.capacity = capacity;
		this.arr = (T[]) Array.newInstance(cls, this.capacity);
	}
	@Override
	public void print() {
		for(int i = 0; i < size; i++){
			System.out.print(this.arr[i] + "  ");
		}
	}
	@Override
	public boolean insert(T item) {
		this.arr[size] = item;
		this.size++;
		return true;
	}
	@Override
	public boolean search(T item) {
		for(int i = 0; i < size; i++){
			if(this.arr[i].compareTo(item) == 0);
				return true;
		}
		return false;
	}
}