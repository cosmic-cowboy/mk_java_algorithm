package com.slgerkamp.mkjavaalgorithm.sort;

/**
 * 単純選択ソート
 *
 */
public class StraightSelectionSort {

	/**
	 * 単純選択ソート
	 * 
	 * @param targetArray ソートされていないランダムな配列
	 * @return ソートされたランダムな配列
	 */
	public static SortResult straightSelectionSort(int [] targetArray){
		
		// カウンター
		int counter = 0;
		
		// 配列の先頭からひとつずつ要素を取り出す
		for(int i = 0; i < targetArray.length; i++){
			
			// 要素、要素の配列番号
			int targetNum = targetArray[i];
			int min = i;
			
			// 要素の配列番号以降の配列を走査
			for(int j = i; j < targetArray.length; j++){
				
				// 要素より小さい配列の値を探す
				// 見つかったらその配列番号を格納
				if(targetNum > targetArray[j]){
					min = j;
				}
				counter++;
			}
			// minがiより大きい
			// つまり要素の配列番号以降の配列を走査でもっと小さい値が見つかった場合、
			// ふたつの要素を交換する
			if(i < min){	
				targetArray[i] = targetArray[min];
				targetArray[min] = targetNum;
			}
		}
		
		return new SortResult(targetArray, counter);
	}
}
