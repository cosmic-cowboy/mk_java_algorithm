package com.slgerkamp.mkjavaalgorithm.sort;

/**
 * マージソート
 *
 */
public class MergeSort {

	// 一字格納用配列
	private static int [] buff;
	// 交換回数
	private static int counter = 0;
	
	public static SortResult mergeSort(int [] targetArray){
		
		// クラス変数の初期化
		counter = 0;
		buff = new int[targetArray.length];
		
		mergeSort_reclusive(targetArray, 0, targetArray.length - 1);
		
		buff = null;
		
		return new SortResult(targetArray, counter);
		
	}
	
	public static void mergeSort_reclusive(int [] a, int left, int right){
		
		if(left < right){
			int center = (left + right) / 2;
			// a の 配列カーソル
			int i ;
			// buff の 配列サイズ
			int p = 0;
			// buff の 配列カーソル
			int j = 0;
			// マージソートする際のカーソル
			int k = left;
			
			mergeSort_reclusive(a, left, center);
			mergeSort_reclusive(a, center+1, right);
			
			// 比較対象の前半の配列をbuffに格納
			for(i = left; i <= center; i++){
				buff[p++] = a[i];
			}
			// 前半の配列と後半の配列を比較
			while(i <= right && j < p){
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
				counter++;
			}
			// buffの値を登録する前にi<=rightになってしまった場合、
			// 残りのbuffの値をaに配置する
			// j < pの場合はbuffの値はすべて登録され、aの値が残ることになるが、
			// aは元の配列なので、特に配置し直す必要はない
			while(j < p){
				a[k++] = buff[j++];
			}

		}		

	}
}
