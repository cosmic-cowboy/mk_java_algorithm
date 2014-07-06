package com.slgerkamp.mkjavaalgorithm.sort;

/**
 * クイックソート<br>
 * 各グループに対して枢軸を設定し、分割を繰り返す
 * すべてのグループが1個になるとソート完了
 */
public class QuickSort {

	private static int counter = 0;

	/**
	 * @param targetArray
	 * @return
	 */
	public static SortResult quickSort(int [] targetArray){

		counter = 0;
		
		quickSort_reclusive(targetArray, 0, targetArray.length - 1);
		
		System.out.println();
		
		return new SortResult(targetArray, counter);
	}

	private static void quickSort_reclusive(
			int[] targetArray, int left, int right) {
		// 配列の先頭
		int pl = left;
		// 配列の最後尾
		int pr = right;
		// 基準軸
		int axis = targetArray[(left + right) / 2];
		
		do{
			// 基準軸より大きい値が見つかるまで
			while(targetArray[pl] < axis){
				pl++;
				System.out.println("left:" + left + ", pl:" + pl + ", pr:" + pr );
			}
			// 基準軸より小さい値が見つかるまで
			while(targetArray[pr] > axis){
				pr--;
				System.out.println("right:" + right + ", pl:" + pl + ", pr:" + pr );
			}
			if(pl <= pr){
				int temp = targetArray[pl];
				targetArray[pl++] = targetArray[pr];
				targetArray[pr--] = temp;				
				counter++;
				System.out.println("left:" + left + ", right:" + right + ", pl:" + pl + ", pr:" + pr );
			}
		}while(pl <= pr);
		
		if(pl < right){
			System.out.println("quickSort pl:" + pl + ",right:" + right );
			quickSort_reclusive(targetArray, pl, right);
		}
		if(pr > left){
			System.out.println("quickSort left:" + left + ",pr:" + pr );
			quickSort_reclusive(targetArray, left, pr);
		}
	}
}
