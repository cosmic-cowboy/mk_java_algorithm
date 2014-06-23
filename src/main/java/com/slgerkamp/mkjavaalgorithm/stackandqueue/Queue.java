package com.slgerkamp.mkjavaalgorithm.stackandqueue;

/**
 * 先入れ先出し（FIFO / First In First Out）
 *
 */
public class Queue {
	int max;
	int rear;
	int [] queue;
	
	public Queue(int max) {
		super();
		this.max = max;
		this.queue = new int [this.max];
		this.rear = 0;
	}
	
	// Queueの最後尾にデータを追加する
	public int enqueue(int item) throws OverflowIntQueueException{
		if(isFull()){
			throw new OverflowIntQueueException();
		}
		return queue[rear++] = item;
	}

	// Queueの先頭からデータを取り出す
	public int dequeue() throws EmptyIntQueueException{
		if(isEmpty()){
			throw new EmptyIntQueueException();
		}
		// 先頭の値を取り出す
		int front = queue[0];
		// 要素を前につめる
		for(int i = 0; i < rear - 1; i++){
			queue[i] = queue[i+1];
		}
		rear--;
		return front;	
	}
	
	// 覗き見
	public int peek() throws EmptyIntQueueException{
		if(isEmpty()){
			throw new EmptyIntQueueException();
		}
		// 先頭の値を取り出す
		return queue[0];	
	}
	
	// 検索
	public int indexOf(int seacheNum){
		for(int i = 0; i < rear; i++){
			if(queue[i] == seacheNum){
				return i;
			}
		}
		return -1;
	}	
	
	// キュー内をクリア
	public void clear(){
		rear = 0;
	}
	
	// キュー容量
	public int capacity(){
		return max;
	}
	
	// キューされている数
	public int size(){
		return rear;
	}
	
	// キューが空かどうか
	public boolean isEmpty(){
		return rear <= 0;
	}
	
	// キューが満杯かどうか
	public boolean isFull(){
		return rear >= max;
	}

	// ダンプ
	public String dump(){
		StringBuffer sb = new StringBuffer();
		if(isEmpty()){
			sb.append("キューは空です");
		} else {
			for(int i = 0; i < rear; i++){
				sb.append(queue[i]);
				sb.append(",");
			}
		}
		return sb.toString();
	}

	@SuppressWarnings("serial")
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException(){}
	}
	
	@SuppressWarnings("serial")
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException(){}
	}
}
