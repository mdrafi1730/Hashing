package sa.edu.yuc;
import java.util.Scanner;
public class HashTable {
	private final static int SIZE = 10;
	private static int[] arr = new int[SIZE];
	public static int hash1(int key){
		int h = key % SIZE;
		return h;
	}
	public static int hash2(int key){
		int h = key/3 % SIZE;
		return h;
	}
	public void putLinear(int key){
		int h = hash1(key);
		if(arr[h] != 0 && arr[h] != key){
			for(int i=0; i<SIZE; i++){
				int j = (i + h) % SIZE;
				if(arr[j] == 0){
					arr[j] = key;
					break;
				}	
			}
		}else{
			arr[h] = key;
		}
	}
	public void putQuadratic(int key){
		int h = hash1(key);
		int temp=h;
		int i = 0;
		while(arr[temp] != 0 && arr[temp] != key){
			temp = h;
			temp = (temp + (int)Math.pow(i, 2)) % SIZE;
			i++;
		}
		arr[temp] = key;
	}
	public void putDoubleHashing(int key){
		int h = hash1(key);
		if(arr[h] == 0 || arr[h] == key){
			arr[h] = key;
		}else{
			h = hash2(key);
			if(arr[h] == 0 || arr[h] == key){
				arr[h] = key;
			}else{
				putLinear(key);
			}
		}
	}
	public String toString(){
		String temp = "";
		for(int i=0; i<SIZE; i++)
			temp += "["+i+"]" + "=>" + arr[i] + "\n";
		return temp;
	}
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		Scanner input = new Scanner(System.in);
		int choice;
		do{
			menu();
			System.out.print("Enter choice of operation = ");
			choice = input.nextInt();
			for(int i = 0; i < SIZE; i++){
				arr[i] = 0;
			}
			switch(choice){
				case 1:
						ht.putLinear(41);
						ht.putLinear(21);
						ht.putLinear(34);
						ht.putLinear(7);
						ht.putLinear(18);
						ht.putLinear(57);
						ht.putLinear(17);
						ht.putLinear(77);
						System.out.println("Linear Probing");
						System.out.println(ht);
						break;
				case 2:
						ht.putQuadratic(41);
						ht.putQuadratic(21);
						ht.putQuadratic(34);
						ht.putQuadratic(7);
						ht.putQuadratic(18);
						ht.putQuadratic(57);
						ht.putQuadratic(17);
						//ht.putQuadratic(77);
						System.out.println("Quadratic Probing");
						System.out.println(ht);
						break;
				case 3:
						ht.putDoubleHashing(41);
						ht.putDoubleHashing(21);
						ht.putDoubleHashing(34);
						ht.putDoubleHashing(7);
						ht.putDoubleHashing(18);
						ht.putDoubleHashing(57);
						ht.putDoubleHashing(17);
						ht.putDoubleHashing(77);
						System.out.println("Double Hashing Probing");
						System.out.println(ht);
						break;
				case 4:
						System.out.println("Thank you");
						break;
				default:
						System.out.println("Invalid Option");
			}
		}while(choice != 4);
	}
	public static void menu(){
		System.out.println("collision Techniques\n"
				+ "1. Linear Probing\n"
				+ "2. Quadratic Probing\n"
				+ "3. Double hashing\n"
				+ "4. Exit");
		
	}
}