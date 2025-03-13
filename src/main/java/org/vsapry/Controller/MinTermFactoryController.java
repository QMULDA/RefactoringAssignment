package org.vsapry.Controller;

import org.vsapry.Model.BitFactories.FiveBitMintermFactory;
import org.vsapry.Model.BitFactories.FourBitMintermFactory;
import org.vsapry.Model.BitFactories.MintermFactory;
import org.vsapry.Model.BitFactories.ThreeBitMintermFactory;


public class MintermFactoryController {

    public static MintermFactory getFactory(int bitCount) {
        switch (bitCount) {
            case 3: return new ThreeBitMintermFactory();
            case 4: return new FourBitMintermFactory();
            case 5: return new FiveBitMintermFactory();
            default: throw new IllegalArgumentException("Unsupported bit count: " + bitCount);
        }
    }
}
