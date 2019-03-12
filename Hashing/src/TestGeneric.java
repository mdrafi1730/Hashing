
public class TestGeneric {

	public static void main(String[] args) {
		Integer[] arr = {10, 20, 45, 78, 89, 23, 90};
		System.out.println("Integer values");
		WithGeneric.display(arr);
		Double[] arr1 = {10.34, 20.56, 45.23, 78.67, 89.89, 23.12, 90.98}; 
		System.out.println("\nDouble values");
		WithGeneric.display(arr1);
		String[] courses = {"CS101", "CS102", "CS201", "CS203"};
		System.out.println("\nString values");
		WithGeneric.display(courses);
		Student[] st = new Student[3];
		st[0] = new Student(100, "Irfan");
		st[1] = new Student(200, "Hameed");
		st[2] = new Student(300, "Rafi");
		System.out.println("\nStudent values");
		WithGeneric.display(st);
	}

}
