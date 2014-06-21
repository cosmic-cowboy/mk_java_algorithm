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
		
		for(int i = 2; i < number; i++){
			boolean isPrime = true;
			for(int j = 2; j < i; j++){
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
