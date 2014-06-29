package com.slgerkamp.mkjavaalgorithm.recursive;

/**
 * 重ねられた円盤を最短の回数で移すためのアルゴリズム
 * ひとつの円盤に対して、３つの走査が入る
 * 1.対象の円盤より小さい円盤を開始軸から中間軸に移動
 * 2.対象の円盤を目的軸に移動
 * 3.対象の円盤より小さい円盤を中間軸から目的軸に移動
 * 
 * この処理を行うために、２つの再帰処理を呼び出している
 * これにより、スタックのような容量で小さい円盤から処理されているように表現することができる
 *
 */
public class TowerOfHanoi {

	/**
	 * 重ねられた円盤を移すための最短距離
	 * @param num
	 * @return
	 */
	public static int move(int no, int x, int y, int counter){
		// 底の円盤を除いたグループ（no - 1の円盤）を開始軸から中間軸へ
		if(no > 1){
			counter = move(no - 1, x, 6 - x - y, counter);
		}
		
		// 底の円盤を開始軸から目的軸へ
		System.out.println("円盤" + no + "を" + x + "から" + y + "へ");
		counter++;
		
		// 底の円盤を除いたグループ（no - 1の円盤）を中間軸から目的軸へ
		if(no > 1){
			counter = move(no - 1, 6 - x - y, y, counter);
		}
		return counter;
	}
}
