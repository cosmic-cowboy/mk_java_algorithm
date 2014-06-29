package com.slgerkamp.mkjavaalgorithm.recursive;

import java.util.List;

import com.slgerkamp.mkjavaalgorithm.stackandqueue.Stack;

/**
 * 再帰を使わず再帰のアルゴリズムの動きを理解する
 *
 */
public class ResurNotResur {

	/**
	 * 再帰を使わない再帰のアルゴリズム_vol1
	 * @param i
	 * @param list
	 * @return
	 */
	public static List<Integer> resur(int i, List<Integer> list){
		
		Stack stack = new Stack(i);
		
		while(true){
			if (i > 0){
				stack.push(i);
				i = i - 1;
				continue;
			}
			if(stack.isEmpty() != true){
				i = stack.pop();
				list.add(i);
				i = i - 2;
				continue;
			}
			break;
		}
		return list;
	}

	/**
	 * 再帰を使わない再帰のアルゴリズム_vol2
	 * @param i
	 * @param list
	 * @return
	 */
	public static List<Integer> resur_2(int i, List<Integer> list){
		
		Stack stack = new Stack(i);
		
		while(true){
			if (i > 0){
				stack.push(i);
				i = i - 2;
				continue;
			}
			if(stack.isEmpty() != true){
				i = stack.pop();
				list.add(i);
				i = i - 1;
				continue;
			}
			break;
		}

		return list;
	}
}
