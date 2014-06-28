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
}
