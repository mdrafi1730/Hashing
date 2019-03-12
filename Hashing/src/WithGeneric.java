
public class WithGeneric {
	
	public static <V> void display(V[] arr){
		for(V i : arr){
			System.out.print(i + "  ");
		}
	}
}
