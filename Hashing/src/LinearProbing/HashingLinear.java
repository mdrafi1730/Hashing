package LinearProbing;
public class HashingLinear implements Hash{
	private int size;
	private int arr[];
	public HashingLinear() {
		this.size = 10000;
		this.arr = new int[size];
	}
	public HashingLinear(int size) {
		this.size = size;
		this.arr = new int[this.size];
	}
	public int hash(int key){
		return key % this.arr.length;
	}
	@Override
	public boolean put(int value) {
		int index = hash(value);
		if(arr[index] != 0 && arr[index] != value){
			for(int i=0; i<this.size; i++){
				int j = (i + index) % this.size;
				if(arr[j] == 0){
					arr[j] = value;
					return true;
				}	
			}
		}else{
			arr[index] = value;
			return true;
		}
		return false;
	}
	@Override
	public int get(int value) {
		int index = hash(value);
		while(index < this.arr.length){
			if(this.arr[index] == value)
				return this.arr[index];
			index++;
		}
		return 0;
	}
	@Override
	public void getAll() {
		for(int i = 0; i < this.arr.length; i++){
			System.out.print("Values[" + i + "] "
					+ "= " + this.arr[i] + "\n");
		}
	}

	@Override
	public boolean delete(int value) {
		int index = hash(value);
		while(index < this.arr.length){
			if(this.arr[index] == value){
				this.arr[index] = 0;
				return true;
			}
			index++;
		}
		return false;
	}
}