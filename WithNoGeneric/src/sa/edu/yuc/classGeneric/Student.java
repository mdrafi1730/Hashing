package sa.edu.yuc.classGeneric;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Student o) {
		if(this.id > o.id)
			return 1;
		else if (this.id < o.id)
			return -1;
		else
			return 0;
	}
	
	
}
