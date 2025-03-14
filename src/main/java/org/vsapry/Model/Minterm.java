package org.vsapry.Model;

public class Minterm {
	protected int numberOfCharsInMinterm;
	protected int[] term;

	public Minterm(String binaryString) {
		term = new int[binaryString.length()];
		for (int i = 0; i < binaryString.length(); i++) {
			switch (binaryString.charAt(i)) {
			case '0':
				term[numberOfCharsInMinterm++] = 0;
				break;
			case '1':
				term[numberOfCharsInMinterm++] = 1;
				break;
			case '_':
				term[numberOfCharsInMinterm++] = -1;
				break;
			}
		}
	}

	public String toString() {
		StringBuilder mintermAsStringBuffer = new StringBuilder(numberOfCharsInMinterm);
		for (int i = 0; i < numberOfCharsInMinterm; i++) {
			switch (term[i]) {
			case 0:
				mintermAsStringBuffer.append('0');
				break;
			case 1:
				mintermAsStringBuffer.append('1');
				break;
			case -1:
				mintermAsStringBuffer.append('_');
				break;
			}
		}
		return mintermAsStringBuffer.toString();
	}

	public boolean isSame(Minterm minterm) {
		if (numberOfCharsInMinterm != minterm.numberOfCharsInMinterm)
			throw new IllegalArgumentException("Minterms need to be the same length of characters to compare");
		for (int i = 0; i < numberOfCharsInMinterm; i++) {
			if (term[i] != minterm.term[i])
				return false;

		}
		return true;
	}

	public int numberOfDifferencesBetweenMinterms(Minterm minterm){
		if (numberOfCharsInMinterm != minterm.numberOfCharsInMinterm)
			throw new IllegalArgumentException("Minterms are differing lengths");
		int numberOfDifferencesBetweenMinterms = 0;
		for (int i = 0; i < numberOfCharsInMinterm; i++) {
			if (term[i] != minterm.term[i])
				numberOfDifferencesBetweenMinterms++;
		}
		return numberOfDifferencesBetweenMinterms;
	}

	public static Minterm combine(Minterm a, Minterm b) {
		StringBuilder combinedTermsBuffer = new StringBuilder(a.numberOfCharsInMinterm);
		for (int i = 0; i < a.numberOfCharsInMinterm; i++) {
			if (a.term[i] != b.term[i])
				combinedTermsBuffer.append('_');
			else
				combinedTermsBuffer.append(a.toString().charAt(i));
		}
		return new Minterm(combinedTermsBuffer.toString());
	}
}
