package com.slgerkamp.mkjavaalgorithm.linearList;

public class ArrayLinkedList {

	static class Node<E> {
		// データ
		private E data;
		// リストの後続ポインタ
		private int next;
		// フリーリストの後続ポインタ
		private int dnext;
		
		void set(E data, int next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node [] n;
	private int size;
	private int max;
	private int head;
	private int current;
	private int deleted;
	private static final int NULL = -1;
	
	public ArrayLinkedList(int capacity) {
		head = current = deleted = NULL;
		n = new Node[capacity];
		for(int i = 0; i < capacity; i++){
			n[i] = new Node<E>();
		}
		size = capacity;
	}
	
 }
