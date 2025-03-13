package org.vsapry.Model.BitFactories;

import org.vsapry.Model.MinTerm;

public class FourBitMinTermFactory implements MinTermFactory {
    @Override
    public MinTerm createMinTerm(int numericValue) {
        if (numericValue < 0 || numericValue > 15) {
            throw new IllegalArgumentException("Input must be 0-15 for 4-bit MinTerms");
        }
        String userInputAsBinaryString = String.format("%4s", Integer.toBinaryString(numericValue)).replace(' ', '0');
        return new MinTerm(userInputAsBinaryString);
    }
}
