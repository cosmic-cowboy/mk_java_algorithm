package com.slgerkamp.mkjavaalgorithm.stackandqueue;

public class GenericsStack<E> {

	private int max;
	private int pointer;
	private E [] stack;
	
	@SuppressWarnings("unchecked")
	public GenericsStack(int capacity) {
		this.max = capacity;
		this.pointer = 0;
		this.stack = (E[]) new Object [this.max];
	}
	
	/**
	 * アイテムを追加
	 * @param addItem
	 * @return
	 */
	public E push(E addItem){
		if(isFull()){
			throw new GenericsOverflowIntStackException();
		}
		return stack[pointer++] = addItem;
	}
	
	/**
	 * アイテムを取得
	 * @return
	 */
	public E pop(){
		if(isEmpty()){
			throw new GenericsEmptyIntStackException();
		}
		return stack[--pointer];			
	}

	/**
	 * 覗き見
	 * @return
	 */
	public E peek(){
		if(isEmpty()){
			throw new GenericsEmptyIntStackException();
		}
		return stack[pointer - 1];			
	}
	
	/**
	 * 探索
	 * @param searchItem
	 * @return
	 */
	public int indexOf(E searchItem){
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
	public static class GenericsEmptyIntStackException extends RuntimeException {
		public GenericsEmptyIntStackException(){}
	}

	@SuppressWarnings("serial")
	public static class GenericsOverflowIntStackException extends RuntimeException {
		public GenericsOverflowIntStackException(){}
	}
}
