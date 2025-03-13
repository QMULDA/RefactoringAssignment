package org.vsapry.Model.BitFactories;

import org.vsapry.Model.Minterm;

public class FourBitMintermFactory implements MintermFactory {
    @Override
    public Minterm createMinterm(int numericValue) {
        if (numericValue < 0 || numericValue > 15) {
            throw new IllegalArgumentException("Input must be 0-15 for 4-bit Minterms");
        }
        String userInputAsBinaryString = String.format("%4s", Integer.toBinaryString(numericValue)).replace(' ', '0');
        return new Minterm(userInputAsBinaryString);
    }
}
