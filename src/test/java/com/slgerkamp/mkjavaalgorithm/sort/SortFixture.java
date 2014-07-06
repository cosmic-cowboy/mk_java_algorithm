package com.slgerkamp.mkjavaalgorithm.sort;

import java.util.Arrays;

class SortFixture{
	int [] targetArray;
	int [] expecedArray;
	int expecedCounter;
	
	public SortFixture(int[] targetArray, int[] expecedArray, int expecedCounter) {
		super();
		this.targetArray = targetArray;
		this.expecedArray = expecedArray;
		this.expecedCounter = expecedCounter;
	}
	
	@Override
	public String toString() {
		return String.format("when targetArray =%s, expectedArray=%s, expectedCounter=%s", Arrays.toString(targetArray), Arrays.toString(expecedArray), expecedCounter);
	}
}