package com.slgerkamp.mkjavaalgorithm.basicalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * クラスを分ける必要が特にないのでひとつのユーティリティクラスにする
 *
 */
public class BasicAlgorithm {
	
	/** number段のピラミッド
	 * @param number
	 * @return
	 */
	public static List<String> createNumberPyramid(int number){
		
		List<String> list = new ArrayList<String>();

		for(int i = 1 ; i <= number; i++){
			StringBuffer spacer = new StringBuffer("");
			for(int j = 0; j < number - i; j++){
				spacer.append(" ");
			}
			StringBuffer numbers = new StringBuffer("");
			for(int k = 0; k < i*2-1; k++){
				numbers.append(i);
			}
			String base = spacer.toString() + numbers.toString() + spacer.toString();			
			list.add(base);
		}
		
		for(String s : list){
			System.out.println(s);
		}

		return list;
	}
	
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
