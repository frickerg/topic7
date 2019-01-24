package topic7.main;

import topic7.interfaces.Comparator;

/**
 * This class compares Double values, so it can be used to build an descending
 * Double heap in {@link LinkedTreeHeap}.
 *
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class DescendingDoubleComparator implements Comparator<Double> {

	/**
	 * Checks if value {@code d} is a Double
	 *
	 * @param d
	 *            value that is testet wether he is a Double or not
	 *
	 * @return {@code true} if {@code d} is a Double, {@code false} if {@code d} is
	 *         not a Double
	 */
	@Override
	public boolean isComparable(Double d) {
		return (d != null && !Double.isNaN(d));
	}

	/**
	 * Checks if the Double values {@code e} and {@code d} are equal.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} only if {@code e} and {@code d} are equal, {@code false}
	 *         if {@code e} and {@code d} are not equal.
	 */
	@Override
	public boolean isEqualTo(Double d, Double e) {
		return Double.compare(e, d) == 0;
	}

	/**
	 * Checks if the Double value {@code e} is greather than the Double value
	 * {@code d}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if {@code e} is greater than {@code d}, {@code false} if
	 *         {@code e} is smaller or equal to {@code d}.
	 */
	@Override
	public boolean isGreaterThan(Double d, Double e) {
		return Double.compare(e, d) > 0;
	}

	/**
	 * Checks if the Double value {@code e} is greather than or equal to the Double
	 * value of {@code d}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if {@code e} is greater or equal than {@code d},
	 *         {@code false} if {@code e} is less than {@code d}.
	 */
	@Override
	public boolean isGreaterThanOrEqualTo(Double d, Double e) {
		return Double.compare(e, d) >= 0;
	}

	/**
	 * Checks if the Double value {@code e} is is less than the Double value of
	 * {@code d}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if the value of {@code e} is less than the value of
	 *         {@code d}, {@code false} if the value of {@code e} is greater or
	 *         equal than the value of {@code d}
	 */
	@Override
	public boolean isLessThan(Double e, Double d) {
		return Double.compare(d, e) < 0;
	}

	/**
	 * Checks if the Double {@code e} is is less than or equal to the Double
	 * {@code d}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if the value of {@code e} is less or equal than the
	 *         value of {@code d}, {@code false} if {@code e} is greater than
	 *         {@code d}.
	 */
	@Override
	public boolean isLessThanOrEqualTo(Double d, Double e) {
		return Double.compare(e, d) <= 0;
	}

}
