package topic7.interfaces;

import topic7.exceptions.EmptyPriorityQueueException;
import topic7.exceptions.NotComparableException;

public interface PriorityQueue<K, E> extends BasicCollection<E> {

	/**
	 * inserts an item with key k and element e
	 * 
	 * @param key
	 *            The key of the element
	 * @param element
	 *            Element to be inserted
	 * @throws NotComparableException
	 *             {@code NotComparableException} is thrown if insert is not
	 *             comparable.
	 */
	public void insertItem(K key, E element) throws NotComparableException;

	/**
	 * removes the item with the smallest key
	 * 
	 * @return element
	 * @throws EmptyPriorityQueueException
	 *             {@code EmptyPriorityQueueException} is thrown if heap is empty.
	 */
	public E removeMin() throws EmptyPriorityQueueException;

	/**
	 * removes the item with the smallest key
	 * 
	 * @return element
	 * @throws EmptyPriorityQueueException
	 *             {@code EmptyPriorityQueueException} is thrown if heap is empty.
	 */
	public K minKey() throws EmptyPriorityQueueException;

	/**
	 * returns the element of an item with smallest key (no removal)
	 * 
	 * @return element
	 * @throws EmptyPriorityQueueException
	 *             {@code EmptyPriorityQueueException} is thrown if heap is empty.
	 */
	public E minElement() throws EmptyPriorityQueueException;

}
