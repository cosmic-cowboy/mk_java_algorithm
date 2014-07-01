package com.slgerkamp.mkjavaalgorithm.recursive;

import java.util.Arrays;

/**
 * ８王妃問題のための分枝限定操作
 *
 */
public class EightQueen {


	// 各行に王妃が配置済みか
	private boolean [] row_flag;
	// 主対角線に王妃が配置済みか
	private boolean [] main_diagonal_flag;
	// 対角線に王妃が配置済みか
	private boolean [] diagonal_flag;
	// 配置位置を格納する
	private int [] pos;
	// 配置可能な組み合わせの数
	private int counter;

	/**
	 * 
	 * @param num : マス目の数
	 */
	public EightQueen(int num) {
		super();
		this.row_flag = new boolean [num];
		this.main_diagonal_flag = new boolean [num * 2 - 1];
		this.diagonal_flag = new boolean [num * 2 - 1];
		this.pos = new int [num];
		this.counter = 0;
	}
	
	/**
	 * ８王妃問題のための分枝限定操作
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
			if(row_flag[j] == false && 
			   diagonal_flag[init + j] == false &&
			   main_diagonal_flag[init - j + num - 1] == false){
				pos[init] = j;
				// init が num - 1になるまで再帰処理setが呼び出される
				// つまり、num が 3 の場合
				// j = 0 に対して、* 3 * 3
				// j = 1 に対して、* 3 * 3
				// j = 2 に対して、* 3 * 3
				if(init == num - 1){
					counter++;
					System.out.println(Arrays.toString(pos));
				} else {
					// 配置済みの行にtrueを代入
					// 再帰処理では配置済みの行を読み込まないようにする
					row_flag[j] = diagonal_flag[init + j] = main_diagonal_flag[init - j + num - 1] = true;
					set(init + 1, num);
					// 配置済みの行をfalseに戻す
					// 再帰処理以外は関係ないので
					row_flag[j] = diagonal_flag[init + j] = main_diagonal_flag[init - j + num - 1] = false;
				}
				
			}
		}
	}
}
