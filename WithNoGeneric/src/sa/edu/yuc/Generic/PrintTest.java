package sa.edu.yuc.Generic;

public class PrintTest {

	public static void main(String[] args) {
		PrintInterface pi = new PrintImpl();
		Integer[] arr = {10, 20, 30, 67, 34, 89, 90, 23};
		System.out.println("Printing integer values");
		pi.print(arr);
		Double[] arr1 = {10.23, 20.89, 30.56, 67.45, 34.98, 89.23, 90.12, 23.90};
		System.out.println("\nPrinting double values");
		pi.print(arr1);
		String[] arr2 = {"CS101", "CS102", "CS201", "CS203", "CS024"};
		System.out.println("\nPrinting String values");
		pi.print(arr2);
		Student[] s = new Student[3];
		s[0] = new Student(100, "abc");
		s[1] = new Student(200, "def");
		s[2] = new Student(300, "ghi");
		System.out.println("\nPrinting Student values");
		pi.print(s);
	}

}
