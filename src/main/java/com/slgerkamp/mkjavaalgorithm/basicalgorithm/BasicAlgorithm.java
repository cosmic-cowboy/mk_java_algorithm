package com.slgerkamp.mkjavaalgorithm.basicalgorithm;

/**
 * クラスを分ける必要が特にないのでひとつのユーティリティクラスにする
 *
 */
public class BasicAlgorithm {
	
	/**
	 * ３値の最大値を求める
	 * @param a
	 * @param b
	 * @param c
	 * @return ３値の最大値
	 */
	public static int maxInt(int a, int b, int c){
		int max = a;
		if(max < b) max = b;
		if(max < c) max = c;
		return max;
	}
	
	/**
	 * ３値の中央値を求める
	 * @param a
	 * @param b
	 * @param c
	 * @return ３値の中央値
	 */
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
