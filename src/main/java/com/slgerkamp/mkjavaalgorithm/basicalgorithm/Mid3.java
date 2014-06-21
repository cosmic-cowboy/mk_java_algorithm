package com.slgerkamp.mkjavaalgorithm.basicalgorithm;


/**
 * ３値の中央値を求める
 *
 */
public class Mid3 {

	// ３値の中央値を求める
	public static int midInt(int a, int b, int c){
		
		int mid;
		// まず最大値を出す
		if(a > b){
			// a > b && a > c
			if(a > c){
				if(b > c){
					// a > b && a > c && b > c
					mid = b;					
				} else {
					// a > b && a > c && b <= c
					mid = c;
				}
			} else {
				// a > b && a <= c
				mid = a;
			}
		} else {
			// b => a
			if(b > c){
				if(a > c){
					// b => a && b > c && a > c
					mid = a;					
				} else {
					// b => a && b > c && a <= c
					mid = c;
				}
			// a <= b && b <= c
			} else {
				mid = b;
			}
		}

		
		// 次に中央値を出す
		return mid;
	}
}
