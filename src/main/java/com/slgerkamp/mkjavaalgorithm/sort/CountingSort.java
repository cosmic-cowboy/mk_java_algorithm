package com.slgerkamp.mkjavaalgorithm.sort;

/**
 * ヒープソート
 *
 */
public class CountingSort {


	// 交換回数
	private static int counter = 0;
	
	public static SortResult countingSort(int [] targetArray){
		
		// クラス変数の初期化
		counter = 0;
		
		// 配列の最大値を求める
		int max = max(targetArray);
		
		// 度数分布表の作成
		// 度数分布表はどの値に要素がいくつあるのか表す。
		// 値は配列のインデックス、いくつあるかは配列の要素を用いて表現している。
		int [] countingGraph = new int [max + 1]; 
		for(int i : targetArray){
			countingGraph[i]++;
		}
		
		// 累積度数分布表の作成
		// 累積度数分布表はどの値までにいくつの要素があるかを表す。
		// 値は配列のインデックス、0から配列のインデックスまでの累積数を配列の要素を用いて表現している。
		for(int i = 1; i < countingGraph.length; i++){
			countingGraph[i] = countingGraph[i] + countingGraph[i-1];
		}
		
		// 目的配列の作成
		// 累積度数分布表が作成されると、その要素を元に、ソートした配列を作成する。
		// 元のソート対象の配列を順番に取得し、要素を累積度数分布表のインデックスに代入。
		// 累積度数分布表のインデックスは0から配列のインデックスまでの累積数を表しているので、
		// 目的配列のインデックス（累積数 - 1）に要素を代入する。
		// 累積度数分布表の対象インデックスの要素数をデクリメントする。
		int [] resultArray = new int [targetArray.length];
		for(int i : targetArray){
			resultArray[--countingGraph[i]] = i;
		}		
		
		return new SortResult(resultArray, counter);
		
	}

	private static int max(int[] targetArray) {
		int max = targetArray[0];
		for(int i : targetArray){
			max = (i > max) ? i : max;
		}
		return max;
	}
	
}
