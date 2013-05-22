/**
 * 
 */

package controller;
import java.util.ArrayList;

/**
 * @author joao
 *
 */
 public class TailContainer<T> implements Recordible{

	private ArrayList<T> records = new ArrayList<T>();
	private boolean order() {
		// TODO Auto-generated method stub
		// quicksort
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> boolean addRecord(E arr) {
		records.add((T) arr);
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T getRecord(int index) {
		return (T)records.get(index);
	}

	public int size() {
		return records.size();
	}

	public boolean isEmpty() {
		return records.isEmpty();
	}

	public T getLast() {
		return records.get(size()-1);
	}

	public T get(int index) {
		return records.get(index);
	}

	public ArrayList<T> getRecords() {
		return records;
	}
}
