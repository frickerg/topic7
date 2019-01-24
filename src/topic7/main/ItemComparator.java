package topic7.main;

import topic7.entity.Item;
import topic7.exceptions.NotComparableException;
import topic7.interfaces.Comparator;
/**
 * {@code ItemComparator} is a class to compare the Items
 * 
 * @author besio1, fricg2
 * @version 17-01-2018
 *
 * @param <K>
 * @param <K>
 * @param <E>
 */

public class ItemComparator<K, E> implements Comparator<Item<K, E>> {
	private final Comparator<K> comparator;

	public ItemComparator(Comparator<K> comparator) {
		this.comparator = comparator;
	}

	@Override
	public boolean isComparable(Item<K, E> x) {
		return (x != null && x.getKey() != null && x.getElement() != null && x instanceof Item);
	}

	@Override
	public boolean isLessThan(Item<K, E> x, Item<K, E> y) throws NotComparableException {
		return this.comparator.isLessThan(x.getKey(), y.getKey());
	}

	@Override
	public boolean isLessThanOrEqualTo(Item<K, E> x, Item<K, E> y) throws NotComparableException {
		return this.comparator.isLessThanOrEqualTo(x.getKey(), y.getKey());
	}

	@Override
	public boolean isEqualTo(Item<K, E> x, Item<K, E> y) throws NotComparableException {
		return this.comparator.isEqualTo(x.getKey(), y.getKey());
	}

	@Override
	public boolean isGreaterThan(Item<K, E> x, Item<K, E> y) throws NotComparableException {
		return this.comparator.isGreaterThan(x.getKey(), y.getKey());
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Item<K, E> x, Item<K, E> y) throws NotComparableException {
		return this.comparator.isGreaterThanOrEqualTo(x.getKey(), y.getKey());
	}
}
