package org.vsapry.Model.BitFactories;

import org.vsapry.Model.Minterm;

public class FiveBitMintermFactory implements MintermFactory {
    @Override
    public Minterm createMinterm(int numericValue) {
        if (numericValue < 0 || numericValue > 31) {
            throw new IllegalArgumentException("Input must be 0-31 for 5-bit Minterms");
        }
        String userInputAsBinaryString = String.format("%5s", Integer.toBinaryString(numericValue)).replace(' ', '0');
        return new Minterm(userInputAsBinaryString);
    }
}
