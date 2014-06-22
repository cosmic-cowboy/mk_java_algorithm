package com.slgerkamp.mkjavaalgorithm.search;

public class Search {

	/**
	 * ２分探索
	 * @param intArray
	 * @param searchNumber
	 * @return
	 */
	public static int binarySearch(int [] intArray, int searchNumber){
		
		// 走査対象の先頭のインデックス
		int lowIndex = 0;
		// 走査対象の最後尾のインデックス
		int highIndex = intArray.length - 1;
		
		// 配列数の表示
		displayArrayCounter(intArray);

		// 各インデックスは加算、減算される
		// lowIndexがhighIndexと同じ、または上回った場合
		// searchNumberは見つからなかったということになる。
		while(lowIndex <= highIndex){
			// 配列の中央から走査をはじめる
			int nowIndex = (lowIndex + highIndex) / 2;
			
			// 配列の表示			
			displaySearch(intArray, lowIndex, highIndex, nowIndex);
			
			if(intArray[nowIndex] == searchNumber){
				// searchNumberが見つかった場合、インデックスを返却する
				return nowIndex;
			} else if(intArray[nowIndex] < searchNumber){
				// 現在のインデックスの値より検索対象の値が大きい場合
				// 操作対象の先頭インデックスを現在のインデックス + 1にする
				lowIndex  = nowIndex + 1;
			} else {
				// 現在のインデックスの値より検索対象の値が小さい場合
				// 操作対象の最後尾インデックスを現在のインデックス - 1にする
				highIndex = nowIndex - 1;
			}
		}
		
		// ループを抜けてしまった場合
		return -1;
	}

	// 配列数を表示
	private static void displayArrayCounter(int[] intArray) {
		System.out.print("   |");
		for(int i = 0; i < intArray.length; i++){
			System.out.print("  " + i);
		}
		System.out.println();
	}

	// 探索の状況を表示
	private static void displaySearch(int[] intArray, int lowIndex,
			int highIndex, int nowIndex) {
		System.out.print("   |");
		for(int i = 0; i < intArray.length; i++){
			if(i == nowIndex){
				System.out.print("  +");					
			} else if(i == lowIndex){
				System.out.print("<= ");
			} else if(i == highIndex){
				System.out.print(" =>");					
			} else {
				System.out.print("   ");					
			}
		}
		System.out.println();
		System.out.print("  " + nowIndex + "|");
		for(int i : intArray){
			System.out.print("  " + i);
		}
		System.out.println();
	}
}
