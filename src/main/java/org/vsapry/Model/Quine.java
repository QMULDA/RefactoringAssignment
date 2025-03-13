package org.vsapry.Model;

import javax.naming.LimitExceededException;

public class Quine {
	protected static final int MAX_TERMS = 0xff;
	public Minterm[] terms = new Minterm[MAX_TERMS];
	public int numMintermsInTerm = 0;

	public void addTerm(String str) throws LimitExceededException {
		if (numMintermsInTerm == MAX_TERMS)
			throw new LimitExceededException("Cannot have more than 255 Terms");
		terms[numMintermsInTerm++] = new Minterm(str);
	}

	public String toString() {
		StringBuilder minTermsBuffer = new StringBuilder();
		for (int i = 0; i < numMintermsInTerm; i++) {
			minTermsBuffer.append(terms[i]).append("\n");
		}
		return minTermsBuffer.toString();
	}

	public boolean hasTerm(Minterm minTerm){
		for (int i = 0; i < numMintermsInTerm; i++) {
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
		Minterm[] reducedTerms = new Minterm[MAX_TERMS];
		boolean[] used = new boolean[MAX_TERMS];
		for (int i = 0; i < numMintermsInTerm; i++) {
			for (int j = i + 1; j < numMintermsInTerm; j++) {
				if (terms[i].numberOfDifferencesBetweenMinterms(terms[j]) == 1) {
					reducedTerms[numberOfReductions++] = Minterm.combine(terms[i], terms[j]);
					used[i] = true;
					used[j] = true;
				}
			}
		}

		int totalReduced = numberOfReductions;
		for (int i = 0; i < numMintermsInTerm; i++) {
			if (!used[i]) {
				reducedTerms[totalReduced++] = terms[i];
			}
		}


		numMintermsInTerm = 0;
		for (int i = 0; i < totalReduced; i++) {
			if (!hasTerm(reducedTerms[i]))
				terms[numMintermsInTerm++] = reducedTerms[i];
		}
		return numberOfReductions;
	}
}