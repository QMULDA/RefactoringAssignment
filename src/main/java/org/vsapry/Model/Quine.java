package org.vsapry.Model;

import org.vsapry.Model.BitFactories.MintermFactory;

import javax.naming.LimitExceededException;
import java.util.Set;

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
		StringBuilder mintermsBuffer = new StringBuilder();
		for (int i = 0; i < numMintermsInTerm; i++) {
			mintermsBuffer.append(terms[i]).append("\n");
		}
		return mintermsBuffer.toString();
	}

	public boolean hasTerm(Minterm minterm){
		for (int i = 0; i < numMintermsInTerm; i++) {
			if (minterm.isSame(terms[i]))
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

	public String parseMinterm(Set<String> setOfStringsToBeConvertedToMinterms, MintermFactory mintermFactory) throws LimitExceededException {
		for (String stringToBeConvertedToMinterm : setOfStringsToBeConvertedToMinterms) {
			this.addTerm(
					mintermFactory.createMinterm(Integer.parseInt(stringToBeConvertedToMinterm))
							.toString()
			);
			System.out.println(stringToBeConvertedToMinterm);
		}

		this.simplify();
		return this.toString();
	}
}