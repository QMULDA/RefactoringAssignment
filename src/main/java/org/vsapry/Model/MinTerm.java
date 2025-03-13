package org.vsapry.Model;

public class MinTerm {
	// input data representation
	public static final char NOT_CH = '0';
	public static final char SET_CH = '1';
	public static final char ANY_CH = '_';
	// internal data representation
	protected static final int NOT = 0;
	protected static final int SET = 1;
	protected static final int ANY = -1;
	// attribute
	protected int numberOfCharsInMinTerm;
	protected int[] term;

	// constructing & reading
	public MinTerm(String str) {
		term = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case NOT_CH:
				term[numberOfCharsInMinTerm++] = NOT;
				break;
			case SET_CH:
				term[numberOfCharsInMinTerm++] = SET;
				break;
			case ANY_CH:
				term[numberOfCharsInMinTerm++] = ANY;
				break;
			}
		}
	}

	// converted to string

	public String toString() {
		StringBuffer buf = new StringBuffer(numberOfCharsInMinTerm);
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			switch (term[i]) {
			case NOT:
				buf.append(NOT_CH);
				break;
			case SET:
				buf.append(SET_CH);
				break;
			case ANY:
				buf.append(ANY_CH);
				break;
			}
		}
		return buf.toString();
	}

	// comparing minterm

	public boolean isSame(MinTerm a) {
		if (numberOfCharsInMinTerm != a.numberOfCharsInMinTerm)
			throw new IllegalArgumentException("MinTerms need to be the same length of characters to compare");
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			if (term[i] != a.term[i])
				return false;

		}
		return true;
	}

	// number of the difference

	public int numberOfDifferencesBetweenMinTerms(MinTerm a){
		if (numberOfCharsInMinTerm != a.numberOfCharsInMinTerm)
			throw new IllegalArgumentException("MinTerms are differing lengths");
		int resCount = 0;
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			if (term[i] != a.term[i])
				resCount++;
		}
		return resCount;
	}

	// combining two minterms

	public static MinTerm combine(MinTerm a, MinTerm b) {
		StringBuffer buf = new StringBuffer(a.numberOfCharsInMinTerm);
		for (int i = 0; i < a.numberOfCharsInMinTerm; i++) {
			if (a.term[i] != b.term[i])
				buf.append(ANY_CH);
			else
				buf.append(a.toString().charAt(i));
		}
		return new MinTerm(buf.toString());
	}
}
