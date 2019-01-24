package topic7.main;

import topic7.interfaces.Comparator;

/**
 * This class compares String values, so it can be used to build an ascending
 * String heap in {@link LinkedTreeHeap}.
 *
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class AscendingStringComparator implements Comparator<String> {

	/**
	 * Checks if value {@code string} is a String
	 *
	 * @param string
	 *            value that is testet wether he is a String or not
	 *
	 * @return {@code true} if {@code string} is a String, {@code false} if
	 *         {@code string} is not a String
	 */
	@Override
	public boolean isComparable(String string) {
		return (string != null && !string.isEmpty());
	}

	/**
	 * Checks if the String values {@code string} and {@code string2} are equal.
	 *
	 * @param string
	 *            First String value to be compared.
	 * @param string2
	 *            Second String value to be compared.
	 *
	 * @return {@code true} only if {@code string} and {@code string2} are equal,
	 *         {@code false} if {@code string} and {@code string2} are not equal.
	 */
	@Override
	public boolean isEqualTo(String string, String string2) {
		return string.equals(string2);
	}

	/**
	 * Checks if the String value {@code string} is greather than the String value
	 * {@code string2}.
	 *
	 * @param string
	 *            First String value to be compared.
	 * @param string2
	 *            Second String value to be compared.
	 *
	 * @return {@code true} if {@code string} is greater than {@code string2},
	 *         {@code false} if {@code string} is smaller or equal to
	 *         {@code string2}.
	 */
	@Override
	public boolean isGreaterThan(String string, String string2) {
		return string.compareTo(string2) > 0;
	}

	/**
	 * Checks if the String value {@code string} is greather than or equal to the
	 * String value of {@code string2}.
	 *
	 * @param string
	 *            First String value to be compared.
	 * @param string2
	 *            Second String value to be compared.
	 *
	 * @return {@code true} if {@code string} is greater or equal than
	 *         {@code string2}, {@code false} if {@code string} is less than
	 *         {@code string2}.
	 */
	@Override
	public boolean isGreaterThanOrEqualTo(String string, String string2) {
		return string.compareTo(string2) >= 0;
	}

	/**
	 * Checks if the String value {@code string} is less than the String value of
	 * {@code string2}.
	 *
	 * @param string
	 *            First String value to be compared.
	 * @param string2
	 *            Second String value to be compared.
	 *
	 * @return {@code true} if the value of {@code string} is less than the value of
	 *         {@code string2}, {@code false} if the value of {@code string} is
	 *         greater or equal than the value of {@code string2}
	 */
	@Override
	public boolean isLessThan(String string, String string2) {
		return string.compareTo(string2) < 0;
	}

	/**
	 * Checks if the String {@code string} is less than or equal to the String
	 * {@code string2}.
	 *
	 * @param string
	 *            First String value to be compared.
	 * @param string2
	 *            Second String value to be compared.
	 *
	 * @return {@code true} if the value of {@code string} is less or equal than the
	 *         value of {@code string2}, {@code false} if {@code string} is greater
	 *         than {@code string2}.
	 */
	@Override
	public boolean isLessThanOrEqualTo(String string, String string2) {
		return string.compareTo(string2) <= 0;
	}

}
