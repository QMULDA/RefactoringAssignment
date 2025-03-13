package org.vsapry.Model.BitFactories;

import org.vsapry.Model.MinTerm;

public class ThreeBitMinTermFactory implements MinTermFactory {
    @Override
    public MinTerm createMinTerm(int numericValue) {
        if (numericValue < 0 || numericValue > 7) {
            throw new IllegalArgumentException("0..7 only for 3-bit minterms");
        }
        String bits = String.format("%3s", Integer.toBinaryString(numericValue)).replace(' ', '0');
        return new MinTerm(bits);
    }
}