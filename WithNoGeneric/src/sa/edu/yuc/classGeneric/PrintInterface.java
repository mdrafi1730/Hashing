package sa.edu.yuc.classGeneric;

public interface PrintInterface<T> {
	public abstract boolean insert(T item);
	public abstract void print();
	public abstract boolean search(T item);

}
