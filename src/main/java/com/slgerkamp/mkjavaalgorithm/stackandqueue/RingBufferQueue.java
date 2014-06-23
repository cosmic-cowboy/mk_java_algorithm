package com.slgerkamp.mkjavaalgorithm.stackandqueue;

/**
 * 先入れ先出し（FIFO / First In First Out）
 *
 */
public class RingBufferQueue {

	int max;
	int front;
	int rear;
	int num;
	int [] queue;
	
	public RingBufferQueue(int max) {
		super();
		this.max = max;
		this.queue = new int [this.max];
		this.front = 0;
		this.rear = 0;
	}
	
	// Queueの最後尾にデータを追加する
	public int enqueue(int item){
		if(isFull()){
			throw new OverflowIntRingBufferQueueException();
		}
		int data = queue[rear++] = item;
		num++;
		rear = counter(rear);
		return data;
	}

	// Queueの先頭からデータを取り出す
	public int dequeue(){
		if(isEmpty()){
			throw new EmptyIntRingBufferQueueException();
		}
		// 先頭の値を取り出す
		int data = queue[front++];
		num--;
		front = counter(front);
		return data;	
	}
	
	// 覗き見
	public int peek(){
		if(isEmpty()){
			throw new EmptyIntRingBufferQueueException();
		}
		// 先頭の値を取り出す
		return queue[front];	
	}
	
	// 検索
	public int indexOf(int seacheNum){
		for(int i = 0; i < num; i++){
			if(queue[(i + front)% max] == seacheNum){
				return i;
			}
		}
		return -1;
	}	
	
	// キュー内をクリア
	public void clear(){
		front = 0;
		rear = 0;
		num = 0;
	}
	
	// キュー容量
	public int capacity(){
		return max;
	}
	
	// キューされている数
	public int size(){
		return num;
	}
	
	// キューが空かどうか
	public boolean isEmpty(){
		return num <= 0;
	}
	
	// キューが満杯かどうか
	public boolean isFull(){
		return num >= max;
	}

	// ダンプ
	public String dump(){
		StringBuffer sb = new StringBuffer();
		if(isEmpty()){
			sb.append("キューは空です");
		} else {
			for(int i = 0; i < num; i++){
				sb.append(queue[(i + front)% max]);
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 循環を考慮した加算
	 * @param num
	 * @return
	 */
	private int counter(int num){	
		if(num >= max){
			return 0;
		}
		return num;
	}


	@SuppressWarnings("serial")
	public class EmptyIntRingBufferQueueException extends RuntimeException{
		public EmptyIntRingBufferQueueException(){}
	}
	
	@SuppressWarnings("serial")
	public class OverflowIntRingBufferQueueException extends RuntimeException{
		public OverflowIntRingBufferQueueException(){}
	}
}
