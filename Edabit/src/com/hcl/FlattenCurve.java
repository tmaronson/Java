package com.hcl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/* The below comment was from a site to give overall directions to an algorithm like this. We will talk
 * about stream() method and functional programming later, but it gives the general idea. So this is kind
 * of how I decided to solve it. It is not difficult, but getting the sample parameter which is the Object array
 * to the flatten() method may be the most difficult thing here!
 * Create an empty list to collect the flattened elements. With the help of forEach loop, 
 * convert each elements of the array into stream and add it to the list. 
 * Now convert this list into stream using stream() method. 
 * Now flatten the stream by converting it into array using toArray() method.
 */

public class FlattenCurve {

	public static void main(String[] args) {
		// flatten(["Tesh", 121317, ["Love", "of", ["my", ["life", ["and", "my", ["world"], "entirely"]]]]])
		Object[] initArray =  
			{"Tesh", 121317, new Object[] {"Love", "of", 
					new Object[] {"my", new Object[] {"life", 
							new Object[] {"and", "my", new Object[] {"world"}, "entirely"}}}}};
		
		// flatten([[[[[["direction"], [372], ["one"], [[[[[["Era"]]]], "Sruth", 3337]]], "First"]]]])
		Object[] initArray2 = {new Object[] {new Object[] {new Object[] {new Object[] {new Object[] {"direction"},
				    new Object[] {372}, new Object[] {"one"}, 
				       new Object[] {new Object[] {new Object[] {new Object[] {new Object[] {new Object[] {"Era"}}}}, 
				    		"Sruth", 3337}}}, "First"}}}};
		Object[] arr1 = flatten(initArray);
		System.out.println(Arrays.asList(arr1));
		Object[] arr2 = flatten(initArray2);
		System.out.println(Arrays.asList(arr2));
	}
	
	static Object[] flatten(Object[] obj) {
		List<Object> finalList = new ArrayList<>();
		for(Object obj3 : obj) {
			if(obj3 instanceof Object[]) {  // no ClassCastException, could use try - catch block also
				List<Object> list1 = Arrays.asList(flatten((Object[]) obj3)); // recursive call
				finalList.addAll(list1);  // add all objects in nested arrays
			}
			else
				finalList.add(obj3); // just add objects like String and wrapper types
		}
		return finalList.toArray(new Object[finalList.size()]); // pop
	}
}
