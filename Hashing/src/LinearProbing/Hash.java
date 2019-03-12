package LinearProbing;
public interface Hash {
	public abstract boolean put(int value);
	public abstract int get(int value);
	public abstract void getAll();
	public abstract boolean delete(int value);
}
