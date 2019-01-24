package topic7.main;

import topic7.interfaces.Comparator;

/**
 * This class compares the length of a string, so it can be used to build an
 * ascending String length heap in {@link LinkedTreeHeap}.
 *
 * @author besio1, fricg2
 * @version 17-01-2018
 */
public class AscendingStringLengthComparator implements Comparator<String> {

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
	 * Checks if the String length {@code string} and String length {@code string2}
	 * are equal.
	 *
	 * @param string
	 *            First String length to be compared.
	 * @param string2
	 *            Second String length to be compared.
	 *
	 * @return {@code true} only if String length {@code string} and String length
	 *         {@code string2} are equal, {@code false} if String length
	 *         {@code string} and String length {@code string2} are not equal.
	 */
	@Override
	public boolean isEqualTo(String string, String string2) {
		return string.equals(string2);
	}

	/**
	 * Checks if the String length {@code string} is greather than the String length
	 * {@code string2}.
	 *
	 * @param string
	 *            First String length to be compared.
	 * @param string2
	 *            Second String length to be compared.
	 *
	 * @return {@code true} if String length {@code string} is greater than String
	 *         length {@code string2}, {@code false} if String length {@code string}
	 *         is smaller or equal to String length {@code string2}.
	 */
	@Override
	public boolean isGreaterThan(String string, String string2) {
		return string.length() > string2.length();
	}

	/**
	 * Checks if the String length {@code string} is greather than or equal to the
	 * String length of {@code string2}.
	 *
	 * @param string
	 *            First String length to be compared.
	 * @param string2
	 *            Second String length to be compared.
	 *
	 * @return {@code true} if String length {@code string} is greater or equal than
	 *         String length {@code string2}, {@code false} if String length
	 *         {@code string} is less than String length {@code string2}.
	 */
	@Override
	public boolean isGreaterThanOrEqualTo(String string, String string2) {
		return string.length() >= string2.length();
	}

	/**
	 * Checks if the String length {@code string} is less than the String length of
	 * {@code string2}.
	 *
	 * @param string
	 *            First String length to be compared.
	 * @param string2
	 *            Second String length to be compared.
	 *
	 * @return {@code true} if String length {@code string} is less than String
	 *         length {@code string2}, {@code false} if String length {@code string}
	 *         is greater or equal than String length {@code string2}
	 */
	@Override
	public boolean isLessThan(String string, String string2) {
		return string.length() < string2.length();
	}

	/**
	 * Checks if the String length {@code string} is less than or equal to the
	 * String length {@code string2}.
	 *
	 * @param string
	 *            First String length to be compared.
	 * @param string2
	 *            Second String length to be compared.
	 *
	 * @return {@code true} if String length {@code string} is less or equal than
	 *         String length {@code string2}, {@code false} if String length
	 *         {@code string} is greater than String length {@code string2}.
	 */
	@Override
	public boolean isLessThanOrEqualTo(String string, String string2) {
		return string.length() <= string2.length();
	}

}
