package com.slgerkamp.mkjavaalgorithm.recursive;

/**
 * ループを用いてユークリットの互除法で最大公約数を求める
 *
 */
public class EuclidGCDLoop {

	/**
	 * ループでx, yの最大公約数を求める
	 * @param x
	 * @param y
	 * @return
	 */
	public static int gcd(int x, int y){
		
		int divisor = x;
		int remainder = y;
		while(remainder != 0){
			int old_remainder = remainder;
			remainder = divisor % remainder;
			divisor = old_remainder;
		}
		return divisor;
	}
}
