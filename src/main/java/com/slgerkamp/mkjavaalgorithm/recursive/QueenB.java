package com.slgerkamp.mkjavaalgorithm.recursive;

/**
 * 指定された個数のマス目に配置可能な組み合わせ
 *
 */
public class QueenB {


	// 配置を格納する
	private int [] pos;
	// 配置可能な組み合わせの数
	private int counter;

	/**
	 * 
	 * @param num : マス目の数
	 */
	public QueenB(int num) {
		super();
		this.pos = new int [num];
		this.counter = 0;
	}
	
	/**
	 * 指定された個数のマス目に配置可能な組み合わせ
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
			pos[init] = j;
			// init が num - 1になるまで再帰処理setが呼び出される
			// つまり、num が 3 の場合
			// j = 0 に対して、* 3 * 3
			// j = 1 に対して、* 3 * 3
			// j = 2 に対して、* 3 * 3
			if(init == num - 1){
				counter++;
//				System.out.println(Arrays.toString(pos));
			} else {
				set(init + 1, num);
			}
		}
	}
}
