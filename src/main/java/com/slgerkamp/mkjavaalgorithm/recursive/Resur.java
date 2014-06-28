package com.slgerkamp.mkjavaalgorithm.recursive;

import java.util.List;

/**
 * 再帰のアルゴリズムの動きを理解する
 *
 */
public class Resur {

	/**
	 * 再帰のアルゴリズム_vol1
	 * @param i
	 * @param list
	 * @return
	 */
	public static List<Integer> resur(int i, List<Integer> list){
		if(i > 0){
			resur(i - 1, list);
			list.add(i);
			System.out.println(i);
			resur(i - 2, list);
		} else {
			System.out.println("death:" + i);			
		}
		return list;
	}

	/**
	 * 再帰のアルゴリズム_vol2
	 * @param i
	 * @param list
	 * @return
	 */
	public static List<Integer> resur_2(int i, List<Integer> list){
		if(i > 0){
			resur_2(i - 2, list);
			list.add(i);
			System.out.println(i);
			resur_2(i - 1, list);
		} else {
			System.out.println("death:" + i);			
		}
		return list;
	}
}
