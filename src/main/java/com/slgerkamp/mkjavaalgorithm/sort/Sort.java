package com.slgerkamp.mkjavaalgorithm.sort;

/**
 * ソート
 *
 */
public class Sort {

	public static enum ORDER {ASCENDING, DESCENDING}
	
	/**
	 * 単純交換ソート(バブルソート) <br>
	 * 要素数nの配列に対してn-1回の比較・交換を行うと、最小要素が先頭に移動<br>
	 * 引き続き、配列の2番目以降の要素に対して比較。<br>
	 * 
	 * @param targetArray ソートされていないランダムな配列
	 * @param order 並び順
	 * @return ソートされたランダムな配列
	 */
	public static int[] bubbleSort(int [] targetArray, ORDER order){
		
		// 配列の末尾
		int lastElementNum = targetArray.length - 1;
		// 配列の末尾からどこまでを比較するかを決定
		for(int i = 0; i < lastElementNum; i++){

			// 配列の末尾から順番に並んだ２つの値を取得し
			// 後方の配列の値が前方の配列の値より小さい場合
			// ２つの配列の順番を交換する
			// それを配列数 - 1 すると最小値が配列の先頭にくる
			// 次に配列の中で２番目に小さい値を求める
			for(int j = lastElementNum; j > i; j--){
				int old_num = targetArray[j];
				int new_num = targetArray[j - 1];
				switch(order){
					case ASCENDING:
						ascendingOrder(targetArray, j, old_num, new_num);
						break;
					case DESCENDING:
						descendingOrder(targetArray, j, old_num, new_num);
						break;
					default :
						break;
				}
			}
		}
		return targetArray;
	}

	/**
	 * 昇順の比較
	 * @param targetArray 対象の配列
	 * @param j 比較対象の配列番号
	 * @param old_num 比較される側
	 * @param new_num 比較する側
	 */
	private static void ascendingOrder(int[] targetArray, int j, int old_num,
			int new_num) {
		if(old_num < new_num){
			targetArray[j - 1] = old_num;
			targetArray[j] = new_num;
		}
	}
	
	/**
	 * 降順の比較
	 * @param targetArray 対象の配列
	 * @param j 比較対象の配列番号
	 * @param old_num 比較される側
	 * @param new_num 比較する側
	 */
	private static void descendingOrder(int[] targetArray, int j, int old_num,
			int new_num) {
		if(old_num > new_num){
			targetArray[j - 1] = old_num;
			targetArray[j] = new_num;
		}
	}
}
