package topic7.interfaces;

import topic7.exceptions.NotComparableException;

/**
 * This interface delivers methods for the comparator classes
 */
public interface Comparator<E> {

	/**
	 * Checks if the first value E is less than the second value E
	 *
	 * @param x
	 *            First value E to compare
	 * @param y
	 *            Second value E to compare
	 *
	 * @return {@code true} if {@code x} is less than {@code y}, {@code false} if
	 *         {@code x} is greater or equal than {@code y}
	 *
	 */
	public boolean isLessThan(E x, E y) throws NotComparableException;

	/**
	 * Checks if the first value E is less than or equal the second value E
	 *
	 * @param x
	 *            First value E to compare
	 * @param y
	 *            Second value E to compare
	 *
	 * @return {@code true} if {@code x} is less or equal than {@code y},
	 *         {@code false} if {@code x} is greater than {@code y}
	 */
	public boolean isLessThanOrEqualTo(E x, E y) throws NotComparableException;

	/**
	 * Checks if the first and second value E are equal
	 *
	 * @param x
	 *            First value E to compare
	 * @param y
	 *            Second value E to compare
	 *
	 * @return {@code true} if {@code x} is equal to {@code y}, {@code false} if it
	 *         is not equal
	 */
	public boolean isEqualTo(E x, E y) throws NotComparableException;

	/**
	 * Checks if the first value E is greater than the second value E
	 *
	 * @param x
	 *            First value E to compare
	 * @param y
	 *            Second value E to compare
	 *
	 * @return {@code true} if {@code x} is greater than {@code y}, {@code false} if
	 *         {@code x} is smaller or equal to {@code y}
	 */
	public boolean isGreaterThan(E x, E y) throws NotComparableException;

	/**
	 * Checks if the first value E is greater than or equal the second value E
	 *
	 * @param x
	 *            First value E to compare
	 * @param y
	 *            Second value E to compare
	 *
	 * @return {@code true} if {@code x} is greater than or equal {@code y},
	 *         {@code false} if {@code x} is smaller to {@code y}
	 */
	public boolean isGreaterThanOrEqualTo(E x, E y) throws NotComparableException;

	/**
	 * Checks if E is comparable.
	 *
	 * @param x
	 *            Value E to be compared
	 * @return {@code true} if {@code x}, {@code false} if is not {@code null}
	 */
	public boolean isComparable(E x);

}
