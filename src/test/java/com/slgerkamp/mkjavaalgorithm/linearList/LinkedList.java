package com.slgerkamp.mkjavaalgorithm.linearList;

import java.util.Comparator;

/**
 * 線形リスト<br>
 *
 * @param <E>
 */
public class LinkedList<E> {

	// 先頭ノード
	private Node<E> head;
	// 着目ノード
	private Node<E> current;
	
	public LinkedList() {
		head = current = null;
	}
	
	// ノード
	static class Node<E> {
		// データ
		private E data;
		// 後続ノードへの参照（後続ポインタ）
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	
	/**
	 * 検索
	 * @param data
	 * @param c
	 * @return
	 */
	public E search(E data, Comparator<? super E> c){
		// リストの先頭ノードを取得
		Node<E> ptr = head;
		
		while(ptr.data != null){
			if(c.compare(data, ptr.data) == 0){
				current = ptr;
				return ptr.data;
			}
			// 後続ノードを取得
			ptr = ptr.next;
		}
		return null;
	}
	
	
	/**
	 * 先頭に要素を追加
	 * @param data
	 */
	public void addFirst(E data){
		// 先頭ノードを取得
		Node<E> tmpData = head;
		// 追加した要素を先頭ノードに、先頭ノードだった要素を次のノードに移動
		// 着目ノードも変更
		head = current = new Node<E>(data, tmpData);
	}
	
	/**
	 * 最後尾に要素を追加
	 * @param data
	 */
	public void addLast(E data){
		if(head == null){
			addFirst(data);
		} else {
			// 先頭ノードを取得
			Node<E> tmpData = head;
			while(tmpData.next != null){
				tmpData = tmpData.next;
			};
			// 最後尾に要素を追加、着目ノードも最後尾に
			tmpData.next = current = new Node<E>(data, null);
		}
	}
	
	/**
	 * 先頭ノードを削除
	 */
	public void removeFirst(){
		if(head != null){
			head = current = head.next;
		}
	}

	/**
	 * 最後尾ノードを削除
	 */
	public void removeLast(){
		// 先頭ノードがない場合
		if(head != null){
			// 先頭ノードのみの場合
			if(head.next == null){
				removeFirst();
			} else {
				Node<E> tmpData = head;
				Node<E> tmpDataPre = head;
				while(tmpData.next != null){
					tmpDataPre = tmpData;
					tmpData = tmpData.next;
				}
				tmpDataPre.next = null;
				current = tmpDataPre;
			}
						
		}
	}
	
	/**
	 * 指定したノードを削除
	 * @param data
	 */
	public void remove(Node<E> data){
		if(head != null){
			if(head == data){
				removeFirst();
			} else {
				Node<E> tmpData = head;
				while(tmpData.next != data){
					tmpData = tmpData.next;
					if(tmpData == null){
						return ;
					}
				}
				tmpData.next = data.next;
				current = tmpData;
			}
		}
	}

	/**
	 * 着目ノードを削除
	 */
	public void removeCurrentNode(){
		remove(current);
	}
	
	/**
	 * 全ノードを削除
	 */
	public void clear(){
		while(head != null){
			removeFirst();
		}
		current = head;
	}
	
	/**
	 * 着目ノードを次に
	 */
	public boolean next(){
		if(head != null && current.next != null){
			current = current.next;
			return true;
		} else {
			return false;
		}
	}
}
