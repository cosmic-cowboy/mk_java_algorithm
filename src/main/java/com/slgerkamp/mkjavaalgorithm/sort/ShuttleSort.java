package com.slgerkamp.mkjavaalgorithm.sort;

/**
 * 単純挿入ソート（shuttle sort）
 *
 */
public class ShuttleSort {

	/**
	 * 単純挿入ソート（shuttle sort）
	 * 
	 * @param targetArray ソートされていないランダムな配列
	 * @return ソートされたランダムな配列
	 */
	public static SortResult shuttleSort(int [] targetArray){
		
		// 比較回数
		int counter = 0;

		// 配列の先頭から順番に比較
		// 比較しながら、ひとつずつ比較対象範囲を広げる
		// 対象の値を設定（２つ目の値から最後へ）
		for(int i = 1; i < targetArray.length; i++){
			
			int targetNum = targetArray[i];
			int j;
			boolean isExchg = false;
			// 対象の値より小さい値はすでにソート済みなので、
			// 現在の値とひとつ前の値を比較し、小さければ交換をする
			// 現在の値のひとつ前の値が小さくなければ、それより前の値はもっと小さいので走査を終了する
			for(j = i; j > 0 && targetNum < targetArray[j - 1]; j--){
				targetArray[j] = targetArray[j - 1];
				counter++;
				isExchg = true;
			}
			
			// 内側のforループを通らない場合のカウント
			if(!isExchg){
				counter++;
			}
			// 走査が行われた一番小さい数字に値を代入する
			// 走査が最初で終われば元の配列の番号に対象の値を代入することになる
			targetArray[j] = targetNum;
		}
		
		return new SortResult(targetArray, counter);
	}
}
