package org.vsapry.Model;

import java.util.Set;
import java.util.TreeSet;

public class MinTermList {

	static Set<String> set=new TreeSet<String>();
	
	public void setMinList(String x){
	
		set.add(x);
		
	}


public static Set<String> getMin(){
	return set;
}
	
}





