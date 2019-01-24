package topic7.interfaces;

import topic7.exceptions.EmptyHeapException;
import topic7.exceptions.NotComparableException;

/**
 * This class delivers methods for the Binary heap
 */
public interface Heap<E> extends BasicCollection<E> {

	/**
	 * Insert an E {@code element} in the heap and reorder it by a upheap.
	 *
	 * @param element
	 *            Inserted element
	 */
	public void insertElement(E element) throws NotComparableException;

	/**
	 * Removes the smallest Element of the heap and reorders the heap order by a
	 * downheap and returns this element
	 */
	public E removeMin() throws EmptyHeapException;

	/**
	 * Returns the smallest element (no removal)
	 */
	public E minElement() throws EmptyHeapException;

}
