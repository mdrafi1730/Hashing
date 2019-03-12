package sa.edu.yuc;
public class HashFunctions {
	private final static int SIZE = 10;
	public static int hash1(String key){
		int h = key.charAt(0);
		return h % SIZE;
	}
	public static int hash2(String key){
		int h=0;
		int len = key.length();
		for(int i=0; i<len; i++)
			h += key.charAt(i);
		return h % SIZE;
	}
	public static int hash3 (String key){
		int h=0;
		h = key.charAt(0) + key.charAt(key.length()-1);
		return h % SIZE;
	}
	public static int hash4 (String key){
		int h=0;
		int len = key.length();
		for(int i=0; i<len; i++){
			int j = i+1;
			
			h += key.charAt(i) * Math.pow(31, len-j); 
		}
		return h;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABC";
		System.out.println(s.hashCode());
		System.out.println(hash4(s));
	}
}