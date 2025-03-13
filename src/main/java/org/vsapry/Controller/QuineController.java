package org.vsapry.Controller;

import org.vsapry.Model.Quine;

import javax.naming.LimitExceededException;

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

}
