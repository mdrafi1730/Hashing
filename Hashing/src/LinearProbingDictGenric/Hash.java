package LinearProbingDictGenric;
import java.util.List;
public interface Hash<T> {
	public abstract boolean put(String word, T meaning);
	public abstract List<T> get(String word);
	public abstract void getAll();
	public abstract boolean delete(String word);
}