package sa.edu.yuc.classGeneric;

public class PrintTest {

	public static void main(String[] args) {
		PrintInterface<Integer> i = new PrintImpl<>(Integer.class, 5);
		i.insert(10);
		i.insert(20);
		i.insert(45);
		i.print();
		System.out.println(i.search(20));
		PrintInterface<Student> s = new PrintImpl<Student>(Student.class, 3);
		s.insert(new Student(100, "abc"));
		s.insert(new Student(200, "def"));
		s.insert(new Student(300, "ghi"));
		s.print();
		System.out.println(s.search(new Student(100, "")));
		
	}
	
	public static int iterative(int n){
		int p = 1;
		for(int i = 1; i <= n; i++){
			p *= i;
		}
		return p;
	}
	
	public static int recursive(int n){
		if( n > 1){
			return n * recursive(n - 1);
		}else{
			return 1;
		}
	}
	
	public static int hash1(String s){
		int hash=0;
		String str[] = s.split("-");
		int day = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int year = Integer.parseInt(str[2]);
		hash = day + month + year;
		return hash;
	}

}
