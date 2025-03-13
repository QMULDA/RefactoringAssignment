package org.vsapry.Controller;

import org.vsapry.Model.BitFactories.FiveBitMinTermFactory;
import org.vsapry.Model.BitFactories.FourBitMinTermFactory;
import org.vsapry.Model.BitFactories.MinTermFactory;
import org.vsapry.Model.BitFactories.ThreeBitMinTermFactory;


public class MinTermFactoryController {

    public static MinTermFactory getFactory(int bitCount) {
        switch (bitCount) {
            case 3: return new ThreeBitMinTermFactory();
            case 4: return new FourBitMinTermFactory();
            case 5: return new FiveBitMinTermFactory();
            default: throw new IllegalArgumentException("Unsupported bit count: " + bitCount);
        }
    }
}
