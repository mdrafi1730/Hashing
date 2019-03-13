package LinearProbingDict;
public interface Hash {
	public abstract boolean put(String word, String meaning);
	public abstract String get(String word);
	public abstract void getAll();
	public abstract boolean delete(String word);
}