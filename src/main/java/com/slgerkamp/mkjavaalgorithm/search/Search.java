package com.slgerkamp.mkjavaalgorithm.search;

public class Search {

	public static int binarySearch(int [] intArray, int searchNumber){
		
		// 走査対象の先頭のインデックス
		int lowIndex = 0;
		// 走査対象の最後尾のインデックス
		int highIndex = intArray.length - 1;

		// 各インデックスは加算、減算される
		// lowIndexがhighIndexと同じ、または上回った場合
		// searchNumberは見つからなかったということになる。
		while(lowIndex <= highIndex){
			// 配列の中央から走査をはじめる
			int nowIndex = (lowIndex + highIndex) / 2;
			
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
}
