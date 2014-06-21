package com.slgerkamp.mkjavaalgorithm.basicalgorithm;


/**
 * ３値の最大値を求める
 *
 */
public class Max3 {

	// ３値の最大値を求める
	public static int maxInt(int a, int b, int c){
		int max = a;
		if(max < b) max = b;
		if(max < c) max = c;
		return max;
	}
}
