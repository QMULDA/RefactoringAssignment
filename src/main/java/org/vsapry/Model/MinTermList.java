package org.vsapry.Model;

import java.util.Set;
import java.util.TreeSet;

public class MinTermList {

    static Set<String> setOfStringsToBeConvertedToMinTerms = new TreeSet<String>();

    public void setMinTermList(String userStringInputForMinTermValue) {

        setOfStringsToBeConvertedToMinTerms.add(userStringInputForMinTermValue);

    }


    public static Set<String> getMinTermList() {
        return setOfStringsToBeConvertedToMinTerms;
    }

}





