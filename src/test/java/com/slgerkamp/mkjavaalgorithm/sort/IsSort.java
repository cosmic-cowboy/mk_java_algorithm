package com.slgerkamp.mkjavaalgorithm.sort;

import java.util.Arrays;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class IsSort extends BaseMatcher<SortResult> {

	Object actual;
	private final int [] targetArray;
	private final int counter;

	public IsSort(int[] targetArray, int counter) {
		super();
		this.targetArray = targetArray;
		this.counter = counter;
	}

	public static Matcher<SortResult> sortOf(int[] targetArray, int counter){
		return new IsSort(targetArray, counter);
	}
	
	public boolean matches(Object actual) {
		this.actual = actual;
		if(!(actual instanceof SortResult)){
			return false;
		}
		if(! Arrays.equals(targetArray, ((SortResult)actual).getTargetArray())){
			return false;
		}
		if(counter != ((SortResult)actual).getCounter()){
			return false;
		}
		return true;
	}

	public void describeTo(Description desc) {
		desc.appendValue(String.format("when expectedArray=%s, expectedCounter=%s", Arrays.toString(targetArray), counter));
		if(actual != null){
			desc.appendText(" but actual is");
			desc.appendValue(
					String.format("actualArray=%s, actualCounter=%s", 
							Arrays.toString(((SortResult)actual).getTargetArray()), ((SortResult)actual).getCounter())
			);
			
		}
		
	}

}
