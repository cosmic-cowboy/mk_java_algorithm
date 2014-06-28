package com.slgerkamp.mkjavaalgorithm.recursive;

/**
 * ユークリットの互除法で最大公約数を求める
 *
 */
public class EuclidGCD {

	/**
	 * x, yの最大公約数を求める
	 * @param x
	 * @param y
	 * @return
	 */
	public static int gcd(int x, int y){
		
		if(y == 0){
			return x;
		} else {
			return gcd(y, x % y);
		}
	}

	/**
	 * arrayの最大公約数を求める
	 * @param array
	 * @return
	 */
	public static int gcdArray(int [] array){
		int tester = array[0];
		int testee;
		for(int s : array){
			testee = s;
			tester = gcd(tester, testee);
		}
		return tester;
	}
}
