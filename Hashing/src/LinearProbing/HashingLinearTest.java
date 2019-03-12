package LinearProbing;
public class HashingLinearTest {
	public static void main(String[] args) {
		HashingLinear h = new HashingLinear(13);
		h.put(45);
		h.put(58);
		h.put(67);
		h.put(78);
		h.put(65);
		h.put(85);
		System.out.println(h.get(58));
		System.out.println("Values are");
		h.getAll();
		System.out.println(h.delete(65));
		System.out.println("Values are");
		h.getAll();
		System.out.println(h.delete(100));
	}
}