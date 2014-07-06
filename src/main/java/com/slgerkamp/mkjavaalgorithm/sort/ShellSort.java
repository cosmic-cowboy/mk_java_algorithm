package com.slgerkamp.mkjavaalgorithm.sort;


/**
 * シェルソート<br>
 * 単純挿入ソートの長所を活かし、短所を補った高速なソートを行うアルゴリズム<br>
 *
 */
public class ShellSort {

	public static SortResult shellSort(int [] targetArray){
		
		// カウンター
		int counter = 0;
		boolean isExchg = false;

		int compareNum = targetArray.length / 2;

		// 比較するグループ分け
		for(; compareNum > 0; compareNum /= 2){
			
			// 比較する回数
			for(int i = compareNum; i < targetArray.length; i++){
				int j;
				
				int tmp = targetArray[i];
				
				// 比較する配列の後ろから２番目の値から比較
				// 配列の後ろの値より前の値が大きいとき、順番を変更する
				for(j = i - compareNum; j >= 0 && targetArray[j] > tmp; j -= compareNum){
					targetArray[j + compareNum] = targetArray[j];
					counter++;
					isExchg = true;
				}
				targetArray[j + compareNum] = tmp;
				
				if(!isExchg){
					counter++;
				};
			}
			
		}
		
		return new SortResult(targetArray, counter);
	}
}
