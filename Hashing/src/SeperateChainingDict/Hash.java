package SeperateChainingDict;

import java.util.List;

public interface Hash {
	public abstract boolean put(String word, String meaning);
	public abstract List<String> get(String word);
	public abstract void getAll();
	public abstract boolean delete(String word);
}
