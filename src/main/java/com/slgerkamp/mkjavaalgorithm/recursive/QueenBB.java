package com.slgerkamp.mkjavaalgorithm.recursive;

import java.util.Arrays;

/**
 * 各行、各列に１個の王妃を配置する組み合わせ
 *
 */
public class QueenBB {


	// 配置位置を格納する
	private boolean [] flag;
	// 配置位置を格納する
	private int [] pos;
	// 配置可能な組み合わせの数
	private int counter;

	/**
	 * 
	 * @param num : マス目の数
	 */
	public QueenBB(int num) {
		super();
		this.flag = new boolean [num];
		this.pos = new int [num];
		this.counter = 0;
	}
	
	/**
	 * 各行、各列に１個の王妃を配置する組み合わせ
	 * @return 可能な組み合わせの数
	 */
	public int set(){
		set(0, pos.length);
		return counter;
	}
	
	/**
	 * 組み合わせの数を計算
	 * @param init : 現在の行数
	 * @param num : マス目
	 */
	private void set(int init, int num){
		for(int j = 0; j < num; j++){
			if(flag[j] == false){
				pos[init] = j;
				// init が num - 1になるまで再帰処理setが呼び出される
				// つまり、num が 3 の場合
				// j = 0 に対して、* 3 * 3
				// j = 1 に対して、* 3 * 3
				// j = 2 に対して、* 3 * 3
				if(init == num - 1){
					counter++;
//					System.out.println(Arrays.toString(pos));
				} else {
					// 配置済みの行にtrueを代入
					// 再帰処理では配置済みの行を読み込まないようにする
					flag[j] = true;
					set(init + 1, num);
					// 配置済みの行をfalseに戻す
					// 再帰処理以外は関係ないので
					flag[j] = false;
				}
				
			}
		}
	}
}
