package org.vsapry.Model;

import java.util.Set;
import java.util.TreeSet;

public class MintermList {

    static Set<String> setOfStringsToBeConvertedToMinterms = new TreeSet<String>();

    public void setMintermList(String userStringInputForMintermValue) {

        setOfStringsToBeConvertedToMinterms.add(userStringInputForMintermValue);

    }


    public static Set<String> getMintermList() {
        return setOfStringsToBeConvertedToMinterms;
    }

}





