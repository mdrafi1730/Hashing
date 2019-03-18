package sa.edu.yuc;

public interface Hash<T> {
	public abstract boolean put(String word, T meaning);
	public abstract String get(String word);
	public abstract void getAll();
	public abstract boolean delete(String word);
	

}
