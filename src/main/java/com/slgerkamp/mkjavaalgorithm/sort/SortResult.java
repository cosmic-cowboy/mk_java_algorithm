package com.slgerkamp.mkjavaalgorithm.sort;

public class SortResult {

	private final int [] targetArray;
	private final int counter;
	
	public SortResult(int[] targetArray, int counter) {
		super();
		this.targetArray = targetArray;
		this.counter = counter;
	}
	
	public int[] getTargetArray() {
		return targetArray;
	}
	public int getCounter() {
		return counter;
	}
}
