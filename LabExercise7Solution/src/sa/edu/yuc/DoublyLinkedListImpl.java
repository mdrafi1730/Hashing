package sa.edu.yuc;
public class DoublyLinkedListImpl<T extends Comparable<T>> implements DoublyLinkedList<T> {
	private Node head;
	private Node tail;
	private int size;
	public class Node {
		T value;
		Node next;
		Node prev;
		public Node (T value) {
			this.value  = value;
		}
	}
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}
	@Override
	public boolean insertFirst(T item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
		return true;
	}
	@Override
	public boolean insertLast(T item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
		return true;
	}
	@Override
	public T removeFirst() {
		if(isEmpty())
			return null;
		else if(size == 1){
			T temp = head.value;
			head.next = null;
			head.prev = null;
			size--;
			return temp;
		}else{
			T temp = head.value;
			head = head.next;
			head.prev = null;
			size--;
			return temp;
		}
	}
	@Override
	public T removeLast() {
		if(isEmpty())
			return null;
		else{
			T temp = tail.value;
			tail = tail.prev;
			tail.next = null;
			size--;
			return temp;
		}
	}
	@Override
	public boolean insertAtPosition(int position, T item) {
		Node newNode = new Node(item);
		if (position == 1){
			insertFirst(item);
			return true;
		}
		else if (position <= size ){
			int count = 0;
			Node temp = null;
			Node current = head;
			while(count != (position - 1)){
				temp = current;
				current = current.next;
				count++;
			}
			newNode.next = temp.next;
			newNode.prev = temp;
			temp.next.prev = newNode;
			temp.next = newNode;
			size++;
			return true;
		}else if(position == size + 1){
			insertLast(item);
			return true;
		}else
			return false;
	}
	@Override
	public T removeAtPosition(int position) {
		T removevalue = null;
		if (position == 1){
			removevalue = removeFirst();
			return removevalue;
		}
		else if (position < size ){
			Node temp = null;
			Node current = head;
			int count = 0;
			while(count != (position - 1)){
				temp = current;
				current = current.next;
				removevalue = current.value;
				count++;
			}
			temp.next = current.next;
			current.next.prev = temp;
			size--;
			return removevalue;
		}else if(position == size){
			removevalue = removeLast();
			return removevalue;
		}else
			return null;
	}
	public String toString(){
		String temp = "";
		Node  current = head;
		while(current != null){
			temp += current.value;
			current = current.next;
		}
		return temp;
	}
	@Override
	public T search(T item) {
		Node current = head;
		while(current != null){
			if(current.value.compareTo(item) == 0)
				return current.value;
			current = current.next;
		}
		return null;
	}
	@Override
	public T getFirst() {
		return head.value;
	} 
}