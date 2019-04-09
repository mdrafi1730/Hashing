package sa.edu.yuc.NoGeneric;
public class PrintImpl implements PrintInterface{
	@Override
	public void print(int[] arr) {
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}	
	}
	@Override
	public void print(double[] arr) {
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
	}
	public void print(String[] arr) {
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
	}
	public void print(Student[] arr) {
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
