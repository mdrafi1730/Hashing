package LinearProbingDictGenric;

import java.util.Scanner;

public class Dictionary {
	public static void main(String[] args) {
		Hash<Word> h = new HashTable<Word>(Word.class, 10000);
		Scanner input = new Scanner(System.in);
		int choice;
		do{
			menu();
			System.out.print("Enter the chocie of operation = ");
			choice = input.nextInt();
			switch(choice){
				case 1:
					Word w = Word.readWord();
					System.out.println(h.put(w.getWord(), w));
					break;
				case 2:
					input.nextLine();
					System.out.print("Enter word to find meaning = ");
					String word = input.nextLine();
					if(h.get(word) == null)
						System.out.println("Word not found");
					else
						System.out.println(h.get(word));
					break;
				case 3:
					System.out.println("All Words and their meanings");
					h.getAll();
					break;
				case 5:
					System.out.println("Thank you");
					break;
				default:
					System.out.println("Invlaid Option");
			}
		}while(choice != 5);
	}
	public static void menu(){
		System.out.println("Dictionary Menu\n"
				+ "1. Put\n"
				+ "2. Get\n"
				+ "3. GetAll\n"
				+ "4. Delete\n"
				+ "5. Exit");
	}
}