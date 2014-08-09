package com.slgerkamp.mkjavaalgorithm.search;

public class ChainHash<K, V> {

	private int size;
	private Node<K, V> [] table;
	
	public ChainHash(int size) {
		this.size = size;
		// 配列とジェネリックスの代入互換性は異なるので配列はあまり使いたくない
		table = new Node[size];
	}
	
	/**
	 * ハッシュ関数
	 * @param key
	 * @return
	 */
	public int hashValue(Object key){
		return key.hashCode() % size;
	}
	
	/**
	 * ハッシュ表に検索
	 * @param key
	 * @return
	 */
	public V search(K key){
		// 探索するデータのハッシュ値を求める
		int hash = hashValue(key);
		// ハッシュ表からハッシュ値を持つバケットを取得
		Node<K, V> p = table[hash];
		
		// 取得したバケットが検索対象と同じ値か確認する
		while(p != null){
			if(p.getKey().equals(key)){
				return p.getValue();
			}
			p = p.getNext();
		}
		return null;
	}
	
	/** 値を追加
	 * 
	 * 同じキーに異なる値がある場合、値は先頭に追加される。
	 * @param key
	 * @param value
	 * @return
	 */
	public int add(K key, V value){
		// 登録する値のハッシュ値を求める
		int hash = hashValue(key);
		// 求めたハッシュ値に登録されているNodeを取得
		Node<K, V> p = table[hash];
		
		// 登録する値がすでに登録されていないか確認
		while (p != null) {
			if(p.getValue().equals(value)){
				// 登録済
				return 1;
			}
			// nextフィールドを活用して、同じキーを持つすべての値を走査
			p = p.getNext();
		}
		// 登録処理
		// 登録するため、ノードを作成 First In
		Node<K, V> temp = new Node<K, V>(key, value, table[hash]);
		table[hash] = temp;
		return 0;
	}
	
	public int remove(K key, V value){
		// 登録する値のハッシュ値を求める
		int hash = hashValue(key);
		// 求めたハッシュ値に登録されているNodeを取得
		Node<K, V> p = table[hash];
		Node<K, V> beforeNode = null;
		
		// 登録する値がすでに登録されていないか確認
		while (p != null) {
			if(p.getValue().equals(value)){
				// 登録済
				// nextがある場合
				if(beforeNode == null && p.getNext() == null){
					table[hash] = null;
				} else if(beforeNode == null && p.getNext() != null){
					table[hash] = p.getNext();
				} else {
					beforeNode.setNext(p.getNext());
				}
				return 0;
			}
			// nextフィールドを活用して、同じキーを持つすべての値を走査
			beforeNode = p;
			p = p.getNext();
		}
		// 未登録
		return 1;
		
	}
}
