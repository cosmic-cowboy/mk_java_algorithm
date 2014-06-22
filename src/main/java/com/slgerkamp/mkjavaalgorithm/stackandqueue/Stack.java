package com.slgerkamp.mkjavaalgorithm.stackandqueue;

/**
 * 後入れ先出し（LIFO/Last In First Out）
 *
 */
public class Stack {

	private int max;
	private int pointer;
	private int [] stack;
	
	public Stack(int capacity) {
		this.max = capacity;
		this.pointer = 0;
		this.stack = new int [this.max];
	}
	
	/**
	 * アイテムを追加
	 * @param addItem
	 * @return
	 */
	public int push(int addItem){
		if(isFull()){
			throw new OverflowIntStackException();
		}
		return stack[pointer++] = addItem;
	}
	
	/**
	 * アイテムを取得
	 * @return
	 */
	public int pop(){
		if(isEmpty()){
			throw new EmptyIntStackException();
		}
		return stack[--pointer];			
	}

	/**
	 * 覗き見
	 * @return
	 */
	public int peek(){
		if(isEmpty()){
			throw new EmptyIntStackException();
		}
		return stack[pointer - 1];			
	}
	
	/**
	 * 探索
	 * @param searchItem
	 * @return
	 */
	public int indexOf(int searchItem){
		for(int i = pointer - 1; i >= 0; i--){
			if(searchItem == stack[i]){
				return i;
			}
		}
		return -1;
	}
	
	// スタック内をクリア
	public void clear(){
		pointer = 0;
	}

	// スタック容量
	public int capacity(){
		return max;
	}

	// スタックされている数
	public int size(){
		return pointer;
	}
	
	// スタックが空かどうか
	public boolean isEmpty(){
		return pointer <= 0;
	}
	
	// スタックが満杯かどうか
	public boolean isFull(){
		return pointer >= max;
	}

	// ダンプ
	public String dump(){
		StringBuffer sb = new StringBuffer();
		if(isEmpty()){
			sb.append("スタックは空です");
		} else {
			for(int i = 0; i < pointer; i++){
				sb.append(stack[i]);
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	@SuppressWarnings("serial")
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException(){}
	}

	@SuppressWarnings("serial")
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException(){}
	}
}
