package com.slgerkamp.mkjavaalgorithm.tree;

import java.util.Comparator;

/**
 * ２分探索木
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K, V> {

	// 木構造の根
	private Node<K, V> root;
	// 木構造を構成するためのコンパレータ
	private Comparator<? super K> comparator = null;
	
	/**
	 * キーが持つ自然な順序で木構造を構成する
	 */
	public BinarySearchTree(){
		this.root = null;
	}
	
	/**
	 * 指定されたコンパレータによってキーの順序を比較し、木構造を構成する
	 */
	public BinarySearchTree(Comparator<? super K> comparator){
		this.root = null;
		this.comparator = comparator;
	}

	/**
	 * 比較処理<br/>
	 * コンパレータが設定されていなければ、比較対象が標準で実装している比較処理を使用する<br/>
	 * コンパレータが設定されていれば、　　設定されたコンパレータを使用する<br/>
	 * 
	 * @param key1
	 * @param key2
	 * @return
	 */
	private int compare(K key1 ,K key2){
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
	}
	
	/**
	 * 探索
	 * @param key
	 * @return
	 */
	public V search(K key){
		Node<K, V> pointer = root;
		
		while(pointer != null){
			int compareInt = compare(pointer.getKey(), key);
			
			if(compareInt == 0){
				return pointer.getData();
			} else if (compareInt > 0){
				pointer = pointer.right;
			} else {
				pointer = pointer.left;
			}
		}
		return null;
	}
	
	/**
	 * ノードを追加する
	 * @param key
	 * @param data
	 */
	public K add(K key, V data){
		if(root == null){
			root = new Node<K, V>(key, data, null, null);
			return root.getKey();
		} else {
			return addNode(root, key, data);
		}
	}
	
	/**
	 * ノードを追加する（補助）
	 * @param key
	 * @param data
	 */
	private K addNode(Node<K, V> pointer, K key, V data) {

		// 追加する値を着目ノードと比較
		int compareInt = compare(pointer.getKey(), key);
		
		// 同じなら追加できないのでNULL
		if(compareInt == 0){
			return null;
		} else if(compareInt < 0){
			// 着目ノードより小さければ左下に進む
			// 値がNULLであれば追加
			// NULLでなければ走査を継続
			if(pointer.left == null){
				pointer.left = new Node<K, V>(key, data, null, null);
				return pointer.left.getKey();
			}
			return addNode(pointer.left, key, data);
		} else {
			// 着目ノードより小さければ右下に進む
			// 値がNULLであれば追加
			// NULLでなければ走査を継続
			if(pointer.right == null){
				pointer.right = new Node<K, V>(key, data, null, null);
				return pointer.right.getKey();
			}
			return addNode(pointer.right, key, data);
		}		
	}
	
	/**
	 * ノードの削除
	 * @param key
	 */
	public Node<K, V> remove(K key) {
		
		// 削除されたノードに新しく入ったノード
		Node<K, V> newNode = null;
		// 走査中のノード
		Node<K, V> pointer = root;
		// 走査中のノードの親ノード
		Node<K, V> parent = null;
		// 走査中のノードが親ノードの左側の子ノードか？
		boolean isLeftChild = true;
		
		while (pointer != null) {
			
			int compareInt = compare(pointer.getKey(), key);
			
			// keyが見つかった場合、ループを終了する
			if (compareInt == 0) {
				break;
				
			// keyが走査中のノードより小さい場合
			} else if (compareInt < 0) {
				parent = pointer;
				pointer = pointer.left;
				isLeftChild = true;
				
			// keyが走査中のノードより大きい場合
			} else {
				parent = pointer;
				pointer = pointer.right;
				isLeftChild = false;
			}			
		}
		// keyが存在しないため、終了する
		if (pointer == null) {
			return newNode;
		}
		
		// 削除対象ノード（pointer）の左子ノードがnullの場合
		if(pointer.left == null){

			if(pointer == root){
				newNode = root = pointer.right;
			}
			if(isLeftChild){
				newNode = parent.left = pointer.right;
			} else {
				newNode = parent.right = pointer.right;
			}
			
		// 削除対象ノード（pointer）の右子ノードがnullの場合
		} else if(pointer.right == null){
			if(pointer == root){
				newNode = root = pointer.left;
			}
			if(isLeftChild){
				newNode = parent.left = pointer.left;
			} else {
				newNode = parent.right = pointer.left;
			}
			
		// 削除対象ノード（pointer）の左右に子ノードがある場合
		} else {
			
			Node<K, V> subparent = pointer;
			Node<K, V> subpointer = pointer.left;
			isLeftChild = true;
			while(subpointer.right != null){
				subparent = subpointer;
				subpointer = subpointer.right;
				isLeftChild = false;
			}
			// 削除対象ノードの値を変更
			// 左右の子ノードはそのまま
			pointer.key = subpointer.key;
			pointer.data = subpointer.data;
			
			// 削除対象の位置に移動したノードを削除
			if(isLeftChild){
				newNode = subparent.left = subpointer.left;
			} else {
				newNode = subparent.right = subpointer.left;
			}
		}
		return newNode;
	}


	/**
	 * 木構造に格納されるノード<br/>
	 * 自身のkey, valueに加え、
	 * 木構造の子供、左右につく値を指定する
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Node<K, V>{

		private K key;
		private V data;
		Node<K, V> left;
		Node<K, V> right;

		public Node(K key, V data, Node<K, V> left, Node<K, V> right) {

			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public K getKey() {
			return key;
		}

		public V getData() {
			return data;
		}

		public void print(){
			System.out.println(data);
		}
	}
}
