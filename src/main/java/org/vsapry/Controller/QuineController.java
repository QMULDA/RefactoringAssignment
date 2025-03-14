package org.vsapry.Controller;

import org.vsapry.Model.BitFactories.MintermFactory;
import org.vsapry.Model.Quine;

import javax.naming.LimitExceededException;
import java.util.Set;

public class QuineController {

    private Quine quine;

    public QuineController(Quine quine) {this.quine = quine;}

    public void addTerm(String str) throws LimitExceededException {
        quine.addTerm(str);
    }

    public String toString(){
        return quine.toString();
    }

    public void simplify(){
        quine.simplify();
    }
    
    public String parseMinterm(Set<String> setOfStringsToBeConvertedToMinterms, MintermFactory mintermFactory) throws LimitExceededException {
        return quine.parseMinterm(setOfStringsToBeConvertedToMinterms, mintermFactory);
    }

}
