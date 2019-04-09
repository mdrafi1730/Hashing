package sa.edu.yuc.Generic;
public class PrintImpl implements PrintInterface {
	@Override
	public <T> void print(T[] arr) {
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
	}
}
