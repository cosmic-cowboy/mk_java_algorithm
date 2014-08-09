package com.slgerkamp.mkjavaalgorithm.search;


public class Node<K, V> {

	private final K key ;
	private final V value;
	private Node<K, V> next;
	
	Node (K key, V value, Node<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Node<K, V> getNext() {
		return next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}

	public int hashCode() {
		return key.hashCode();
	}

}