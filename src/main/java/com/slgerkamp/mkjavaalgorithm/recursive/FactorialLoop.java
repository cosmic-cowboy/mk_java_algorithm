package com.slgerkamp.mkjavaalgorithm.recursive;

/**
 * ループで階乗値を求める
 *
 */
public class FactorialLoop {

	/**
	 * ループで階乗値を求める
	 * @param i
	 * @return
	 */
	public static int factorial(int i){

		int num = 1;
		while(i > 0){
			 num *= i--;
		}
		return num;
	}
}
