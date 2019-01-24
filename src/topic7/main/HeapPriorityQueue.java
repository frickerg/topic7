package topic7.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import topic7.entity.Item;
import topic7.exceptions.EmptyPriorityQueueException;
import topic7.exceptions.NotComparableException;
import topic7.interfaces.Comparator;
import topic7.interfaces.Heap;
import topic7.interfaces.PriorityQueue;

public class HeapPriorityQueue<K, E> implements PriorityQueue<K, E> {
	private final Comparator<Item<K, E>> comparator;
	private final Heap<Item<K, E>> priorityHeap;

	/**
	 * The {@code internalMap} is used to store the data of the
	 * {@link PriorityQueue}. The difficulty here was to use a Data Structure, which
	 * would be efficient enough when using big data sets as in the
	 * {@link HeapPriorityQueueTest}.
	 *
	 * Our first implementation of the {@link PriorityQueue} used an ArrayList
	 * instead of a HashMap to be similar to the Java
	 * {@link java.util.PriorityQueue} implementation. Working with an array based
	 * data structure was not efficient enough due its Big-O Notation and therefore
	 * not applicable to our project.
	 *
	 * A Map is by definition automatically sorted by keys (which in our case
	 * represent the priority of the Item) and needs less processing time. The
	 * stored {@link ArrayList} which represent the value of the map are unified to
	 * avoid missing values for non-unique keys.
	 *
	 * This implementation choice was inspired by Google's Guava Multimap (link
	 * below).
	 *
	 * @see https://google.github.io/guava/releases/21.0/api/docs/com/google/common/collect/Multimap.html
	 */
	private final Map<K, List<E>> internalMap = new HashMap<>();

	public HeapPriorityQueue(Comparator<K> comparator) {
		this.comparator = new ItemComparator<>(comparator);
		this.priorityHeap = new LinkedTreeHeap<>(this.comparator);
	}

	@Override
	public int size() {
		return this.priorityHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void insertItem(K key, E element) throws NotComparableException {
		this.priorityHeap.insertElement(new Item<>(key, element));
		if (this.internalMap.containsKey(key)) {
			this.internalMap.get(key).add(element);
		} else {
			final List<E> list = new ArrayList<>();
			list.add(element);
			this.internalMap.put(key, list);
		}
	}

	@Override
	public E removeMin() throws EmptyPriorityQueueException {
		if (this.isEmpty()) {
			throw new EmptyPriorityQueueException();
		}
		final Item<K, E> min = this.priorityHeap.removeMin();
		if (this.internalMap.get(min.getKey()).size() > 1) {
			this.internalMap.get(min.getKey()).remove(0);
		} else {
			this.internalMap.remove(min.getKey());
		}
		return min.getElement();
	}

	@Override
	public K minKey() throws EmptyPriorityQueueException {
		if (this.isEmpty()) {
			throw new EmptyPriorityQueueException();
		}
		return this.priorityHeap.minElement().getKey();
	}

	@Override
	public E minElement() throws EmptyPriorityQueueException {
		if (this.isEmpty()) {
			throw new EmptyPriorityQueueException();
		}
		return this.priorityHeap.minElement().getElement();
	}
}