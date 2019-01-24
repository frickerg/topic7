package topic7.main;

import topic7.interfaces.Comparator;

/**
 * This class compares Double values, so it can be used to build an ascending
 * Double heap in {@link LinkedTreeHeap}.
 *
 * @author besio1, fricg2
 * @version 17-01-2018
 */

public class AscendingDoubleComparator implements Comparator<Double> {

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
	 * Checks if the Double values {@code d} and {@code e} are equal.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} only if {@code d} and {@code e} are equal, {@code false}
	 *         if {@code d} and {@code e} are not equal.
	 */
	@Override
	public boolean isEqualTo(Double d, Double e) {
		return Double.compare(d, e) == 0;
	}

	/**
	 * Checks if the Double value {@code d} is greather than the Double value
	 * {@code e}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if {@code d} is greater than {@code e}, {@code false} if
	 *         {@code d} is smaller or equal to {@code e}.
	 */
	@Override
	public boolean isGreaterThan(Double d, Double e) {
		return Double.compare(d, e) > 0;
	}

	/**
	 * Checks if the Double value {@code d} is greather than or equal to the Double
	 * value of {@code e}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if {@code d} is greater or equal than {@code e},
	 *         {@code false} if {@code d} is less than {@code e}.
	 */
	@Override
	public boolean isGreaterThanOrEqualTo(Double d, Double e) {
		return Double.compare(d, e) >= 0;
	}

	/**
	 * Checks if the Double value {@code d} is is less than the Double value of
	 * {@code e}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if the value of {@code d} is less than the value of
	 *         {@code e}, {@code false} if the value of {@code d} is greater or
	 *         equal than the value of {@code e}
	 */
	@Override
	public boolean isLessThan(Double d, Double e) {
		return Double.compare(d, e) < 0;
	}

	/**
	 * Checks if the Double {@code d} is is less than or equal to the Double
	 * {@code e}.
	 *
	 * @param d
	 *            First Double value to be compared.
	 * @param e
	 *            Second Double value to be compared.
	 *
	 * @return {@code true} if the value of {@code d} is less or equal than the
	 *         value of {@code e}, {@code false} if {@code d} is greater than
	 *         {@code e}.
	 */
	@Override
	public boolean isLessThanOrEqualTo(Double d, Double e) {
		return Double.compare(d, e) <= 0;
	}

}
