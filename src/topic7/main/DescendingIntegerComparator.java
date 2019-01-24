package topic7.main;

import topic7.interfaces.Comparator;

/**
 * This class compares Integer values, so it can be used to build an descending
 * Integer heap in {@link LinkedTreeHeap}.
 *
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class DescendingIntegerComparator implements Comparator<Integer> {

	/**
	 * Checks if value {@code x} is an Integer
	 *
	 * @param x
	 *            value that is testet wether he is a Integer or not
	 *
	 * @return {@code true} if {@code x} is a Integer, {@code false} if {@code x} is
	 *         not a Integer
	 */
	@Override
	public boolean isComparable(Integer x) {
		return (x != null && x.intValue() == x);
	}

	/**
	 * Checks if the Integer values {@code x} and {@code y} are equal.
	 *
	 * @param x
	 *            First Integer value to be compared.
	 * @param y
	 *            Second Integer value to be compared.
	 *
	 * @return {@code true} only if {@code x} and {@code y} are equal, {@code false}
	 *         if {@code x} and {@code y} are not equal.
	 */
	@Override
	public boolean isEqualTo(Integer x, Integer y) {
		return Integer.compare(x, y) == 0;
	}

	/**
	 * Checks if the Integer value {@code y} is greather than the Integer value
	 * {@code x}.
	 *
	 * @param x
	 *            First Integer value to be compared.
	 * @param y
	 *            Second Integer value to be compared.
	 *
	 * @return {@code true} if {@code y} is greater than {@code x}, {@code false} if
	 *         {@code y} is smaller or equal to {@code x}.
	 */
	@Override
	public boolean isGreaterThan(Integer x, Integer y) {
		return Integer.compare(y, x) > 0;
	}

	/**
	 * Checks if the Integer value {@code y} is greather than or equal to the
	 * Integer value of {@code x}.
	 *
	 * @param x
	 *            First Integer value to be compared.
	 * @param y
	 *            Second Integer value to be compared.
	 *
	 * @return {@code true} if {@code y} is greater or equal than {@code x},
	 *         {@code false} if {@code y} is less than {@code x}.
	 */
	@Override
	public boolean isGreaterThanOrEqualTo(Integer x, Integer y) {
		return Integer.compare(y, x) >= 0;
	}

	/**
	 * Checks if the Integer value {@code y} is is less than the Integer value of
	 * {@code x}.
	 *
	 * @param x
	 *            First Integer value to be compared.
	 * @param y
	 *            Second Integer value to be compared.
	 *
	 * @return {@code true} if the value of {@code y} is less than the value of
	 *         {@code x}, {@code false} if the value of {@code y} is greater or
	 *         equal than the value of {@code x}
	 */
	@Override
	public boolean isLessThan(Integer x, Integer y) {
		return Integer.compare(y, x) < 0;
	}

	/**
	 * Checks if the Integer {@code y} is less than or equal to the Integer
	 * {@code x}.
	 *
	 * @param x
	 *            First Integer value to be compared.
	 * @param y
	 *            Second Integer value to be compared.
	 *
	 * @return {@code true} if the value of {@code y} is less or equal than the
	 *         value of {@code x}, {@code false} if {@code y} is greater than
	 *         {@code x}.
	 */
	@Override
	public boolean isLessThanOrEqualTo(Integer x, Integer y) {
		return Integer.compare(y, x) <= 0;
	}

}
