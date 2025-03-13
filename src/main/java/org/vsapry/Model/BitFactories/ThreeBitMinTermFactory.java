package org.vsapry.Model.BitFactories;

import org.vsapry.Model.MinTerm;

public class ThreeBitMinTermFactory implements MinTermFactory {
    @Override
    public MinTerm createMinTerm(int numericValue) {
        if (numericValue < 0 || numericValue > 7) {
            throw new IllegalArgumentException("Input must be 0-7 for 3-bit MinTerms");
        }
        String userInputAsBinaryString = String.format("%3s", Integer.toBinaryString(numericValue)).replace(' ', '0');
        return new MinTerm(userInputAsBinaryString);
    }
}