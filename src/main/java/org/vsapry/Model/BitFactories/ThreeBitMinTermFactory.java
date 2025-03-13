package org.vsapry.Model.BitFactories;

import org.vsapry.Model.Minterm;

public class ThreeBitMintermFactory implements MintermFactory {
    @Override
    public Minterm createMinterm(int numericValue) {
        if (numericValue < 0 || numericValue > 7) {
            throw new IllegalArgumentException("Input must be 0-7 for 3-bit Minterms");
        }
        String userInputAsBinaryString = String.format("%3s", Integer.toBinaryString(numericValue)).replace(' ', '0');
        return new Minterm(userInputAsBinaryString);
    }
}