package LinearProbingDict;
import java.util.Scanner;
public class Dictionary {
	public static void main(String[] args) {
		HashingLinear hl = new HashingLinear(10000);
		Scanner input = new Scanner(System.in);
		int choice;
		do{
			menu();
			System.out.print("Enter choice of operation = ");
			choice = input.nextInt();
			switch(choice){
				case 1:
					input.nextLine();
					System.out.print("Enter the word = ");
					String word = input.nextLine();
					System.out.print("Enter it's meaning = ");
					String meaning = input.nextLine();
					System.out.println(hl.put(word, meaning));
					break;
				case 2:
					input.nextLine();
					System.out.print("Enter the word to search for meaning = ");
					word = input.nextLine();
					String temp = hl.get(word);
					if(temp == ""){
						System.out.println("No meaning for the word");
					}else{
						System.out.println("Meaning" + "\n" + temp);
					}
					break;
				case 3:
						hl.getAll();
						break;
				case 4:
					input.nextLine();
					System.out.print("Enter the word to delete with meaning = ");
					word = input.nextLine();
					boolean flag = hl.delete(word);
					if(flag == true){
						System.out.println("Word and it's meaning is deleted");
					}else{
						System.out.println("Word does not exist");
					}
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