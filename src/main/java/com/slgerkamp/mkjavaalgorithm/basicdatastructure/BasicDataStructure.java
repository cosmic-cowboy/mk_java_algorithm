package com.slgerkamp.mkjavaalgorithm.basicdatastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class BasicDataStructure {

	
	/**
	 * 今日で今年が何日終わったかを求める
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static int dayInYear(int year, int month, int day){

		int [][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31},
			{31,29,31,30,31,30,31,31,30,31,30,31}
		};
		int yearNum = 0;
		// 閏年判定
		// 4で割り切れる年 かつ 100で割り切れない、もしくは400で割り切れる
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ){
			yearNum = 1;
		}
		
		int resultDay = 0;
		// 日付の計測
		for(int i = 0; i < month-1; i++){
			resultDay += mdays[yearNum][i];
		}
		resultDay += day;
		System.out.println(resultDay);
		return resultDay;
	}
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
