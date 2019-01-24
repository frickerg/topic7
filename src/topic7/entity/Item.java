package topic7.entity;

/**
 * Item class which can store a key and an element at the same time. The
 * {@link Item} class adopts the structure of a keyset to be stored within a
 * {@link Node}
 *
 * @param <K>
 *            the generic key type
 * @param <E>
 *            the generic element type
 *
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class Item<K, E> {
	private final K key;
	private final E element;

	/**
	 * Constructor. Creates a new {@link Item}
	 *
	 * @param key
	 *            the key
	 * @param element
	 *            the element
	 */
	public Item(K key, E element) {
		this.key = key;
		this.element = element;
	}

	/**
	 * @return key of the {@link Item}
	 */
	public K getKey() {
		return this.key;
	}

	/**
	 * @return element of the {@link Item}
	 */
	public E getElement() {
		return this.element;
	}

	@Override
	public String toString() {
		return this.getKey().toString();
	}
}
