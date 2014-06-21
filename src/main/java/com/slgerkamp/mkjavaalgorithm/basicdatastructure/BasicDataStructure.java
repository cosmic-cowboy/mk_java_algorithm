package com.slgerkamp.mkjavaalgorithm.basicdatastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class BasicDataStructure {

	/**
	 * 素数を求める
	 * @param number
	 * @return
	 */
	public static List<Integer>  primeNumber(int number){
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		for(int i = 3; i < number; i+=2){
			boolean isPrime = true;
			for(int j : list){
				if(i % j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				list.add(i);
			}
		}
		
		return list;
	}
}
