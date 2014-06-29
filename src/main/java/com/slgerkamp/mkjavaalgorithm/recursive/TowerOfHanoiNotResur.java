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
public class TowerOfHanoiNotResur {

	static String[] names = {"A軸","B軸","C軸"};
	/**
	 * 重ねられた円盤を移すための最短距離
	 * @param num
	 * @return
	 */
	public static int move(int no, int x, int y){
	
		int counter = 0;
		// 開始軸
	    int[] xstk = new int[100];
		// 終了軸
	    int[] ystk = new int[100];
		// 中間軸
	    int[] sstk = new int[100];      // スタック
	    int ptr = 0;               // スタックポインタ
	    int sw = 0;
	
	    while (true) {
	
			// 底の円盤を除いたグループ（no - 1の円盤）を開始軸から中間軸へ
			if (sw == 0 && no > 1) {
				xstk[ptr] = x;
				ystk[ptr] = y;
				sstk[ptr] = sw;
				ptr++;
				no = no - 1;
				y = 6  - x - y;
				continue;
			}
			// 底の円盤を開始軸から目的軸へ
			System.out.printf("[%d]を%d軸から%d軸へ移動\n", no, x, y);
			counter++;
			// 底の円盤を除いたグループ（no - 1の円盤）を中間軸から目的軸へ
			if (sw == 1 && no > 1) {
				xstk[ptr] = x;// xの値をプッシュ
				ystk[ptr] = y;// yの値をプッシュ
				sstk[ptr] = sw;// swの値をプッシュ
				ptr++;
				no = no - 1;
				x = 6  - x - y;
				if (++sw == 2) sw = 0;
				continue;
			}
			do {
				// スタックが空になったら
				if (ptr-- == 0){
					return counter;				
				}
				x  = xstk[ptr];// 値を保存していたxをポップ
				y  = ystk[ptr];// 値を保存していたyをポップ
				sw = sstk[ptr] + 1;// 値を保存していたswをポップ
				no++;
			} while (sw == 2);
		}
	}
}
