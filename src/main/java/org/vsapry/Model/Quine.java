package org.vsapry.Model;

import javax.naming.LimitExceededException;

public class Quine {
	protected static final int MAX_TERMS = 0xff;
	public MinTerm[] terms = new MinTerm[MAX_TERMS];
	public int numMinTermsInTerm = 0;

	public void addTerm(String str) throws LimitExceededException {
		if (numMinTermsInTerm == MAX_TERMS)
			throw new LimitExceededException("Cannot have more than 255 Terms");
		terms[numMinTermsInTerm++] = new MinTerm(str);
	}

	public String toString() {
		StringBuilder minTermsBuffer = new StringBuilder();
		for (int i = 0; i < numMinTermsInTerm; i++) {
			minTermsBuffer.append(terms[i]).append("\n");
		}
		return minTermsBuffer.toString();
	}

	public boolean hasTerm(MinTerm minTerm){
		for (int i = 0; i < numMinTermsInTerm; i++) {
			if (minTerm.isSame(terms[i]))
				return true;
		}
		return false;
	}

	public void simplify() {
		int numberOfMerges;
		do {
			numberOfMerges = reduce();
		} while (numberOfMerges > 0);
	}

	private int reduce() {
		int numberOfReductions = 0;
		MinTerm[] reducedTerms = new MinTerm[MAX_TERMS];
		boolean[] used = new boolean[MAX_TERMS];
		for (int i = 0; i < numMinTermsInTerm; i++) {
			for (int j = i + 1; j < numMinTermsInTerm; j++) {
				if (terms[i].numberOfDifferencesBetweenMinTerms(terms[j]) == 1) {
					reducedTerms[numberOfReductions++] = MinTerm.combine(terms[i], terms[j]);
					used[i] = true;
					used[j] = true;
				}
			}
		}

		int totalReduced = numberOfReductions;
		for (int i = 0; i < numMinTermsInTerm; i++) {
			if (!used[i]) {
				reducedTerms[totalReduced++] = terms[i];
			}
		}


		numMinTermsInTerm = 0;
		for (int i = 0; i < totalReduced; i++) {
			if (!hasTerm(reducedTerms[i]))
				terms[numMinTermsInTerm++] = reducedTerms[i];
		}
		return numberOfReductions;
	}
}