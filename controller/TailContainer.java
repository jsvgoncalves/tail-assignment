/**
 * 
 */

package controller;
import java.util.ArrayList;
import java.util.Collections;


/**
 * @author joao
 *
 */
 public class TailContainer<T> implements Recordible{

	private ArrayList<T> records = new ArrayList<T>();
	
	public TailContainer(TailContainer<T> state) {
		records = new ArrayList<T>(state.getRecords());
	}

	public TailContainer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Sorts the list, if sortable.
	 * @return True after list is sorted; False if unsortable.
	 */
	@SuppressWarnings("unchecked")
	public <E extends Comparable<E>> boolean sort() {
		// TODO Auto-generated method stub
		// quicksort
		Collections.sort((ArrayList<E>) records);
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
