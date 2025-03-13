package org.vsapry.Model;

public class MinTerm {
	protected int numberOfCharsInMinTerm;
	protected int[] term;

	public MinTerm(String binaryString) {
		term = new int[binaryString.length()];
		for (int i = 0; i < binaryString.length(); i++) {
			switch (binaryString.charAt(i)) {
			case '0':
				term[numberOfCharsInMinTerm++] = 0;
				break;
			case '1':
				term[numberOfCharsInMinTerm++] = 1;
				break;
			case '_':
				term[numberOfCharsInMinTerm++] = -1;
				break;
			}
		}
	}

	public String toString() {
		StringBuilder minTermAsStringBuffer = new StringBuilder(numberOfCharsInMinTerm);
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			switch (term[i]) {
			case 0:
				minTermAsStringBuffer.append('0');
				break;
			case 1:
				minTermAsStringBuffer.append('1');
				break;
			case -1:
				minTermAsStringBuffer.append('_');
				break;
			}
		}
		return minTermAsStringBuffer.toString();
	}

	public boolean isSame(MinTerm minTerm) {
		if (numberOfCharsInMinTerm != minTerm.numberOfCharsInMinTerm)
			throw new IllegalArgumentException("MinTerms need to be the same length of characters to compare");
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			if (term[i] != minTerm.term[i])
				return false;

		}
		return true;
	}

	public int numberOfDifferencesBetweenMinTerms(MinTerm minTerm){
		if (numberOfCharsInMinTerm != minTerm.numberOfCharsInMinTerm)
			throw new IllegalArgumentException("MinTerms are differing lengths");
		int numberOfDifferencesBetweenMinTerms = 0;
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			if (term[i] != minTerm.term[i])
				numberOfDifferencesBetweenMinTerms++;
		}
		return numberOfDifferencesBetweenMinTerms;
	}

	public static MinTerm combine(MinTerm a, MinTerm b) {
		StringBuilder combinedTermsBuffer = new StringBuilder(a.numberOfCharsInMinTerm);
		for (int i = 0; i < a.numberOfCharsInMinTerm; i++) {
			if (a.term[i] != b.term[i])
				combinedTermsBuffer.append('_');
			else
				combinedTermsBuffer.append(a.toString().charAt(i));
		}
		return new MinTerm(combinedTermsBuffer.toString());
	}
}
