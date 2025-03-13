package org.vsapry.Model.BitFactories;

import org.vsapry.Model.MinTerm;

public class FiveBitMinTermFactory implements MinTermFactory {
    @Override
    public MinTerm createMinTerm(int numericValue) {
        if (numericValue < 0 || numericValue > 31) {
            throw new IllegalArgumentException("Input must be 0-31 for 5-bit MinTerms");
        }
        String userInputAsBinaryString = String.format("%5s", Integer.toBinaryString(numericValue)).replace(' ', '0');
        return new MinTerm(userInputAsBinaryString);
    }
}
