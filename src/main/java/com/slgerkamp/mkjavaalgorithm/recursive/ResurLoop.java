package com.slgerkamp.mkjavaalgorithm.recursive;

import java.util.List;

/**
 * 末尾再帰の除去して再帰のアルゴリズムの動きを理解する
 *
 */
public class ResurLoop {

	/**
	 * 末尾再帰の除去した再帰のアルゴリズム_vol1
	 * @param i
	 * @param list
	 * @return
	 */
	public static List<Integer> resur(int i, List<Integer> list){
		while(i > 0){
			resur(i - 1, list);
			list.add(i);
			i = i - 2;
		}
		return list;
	}

	/**
	 * 末尾再帰の除去した再帰のアルゴリズム_vol2
	 * @param i
	 * @param list
	 * @return
	 */
	public static List<Integer> resur_2(int i, List<Integer> list){
		while(i > 0){
			resur_2(i - 2, list);
			list.add(i);
			i = i - 1;
		}
		return list;
	}
}
