package com.slgerkamp.mkjavaalgorithm.tree;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.slgerkamp.mkjavaalgorithm.tree.BinarySearchTree.Node;

/**
 * ２分探索木テスト
 *
 * @param <K>
 * @param <V>
 */
@RunWith(Enclosed.class)
public class BinarySearchTreeTest {

//	@RunWith(Theories.class)
//	public static class 削除テスト{
//
//		@DataPoints
//		public static 削除Fixture[] FIXTURES = {
//			new 削除Fixture(1,2,1),
//			new 削除Fixture(2,3,null),
//			new 削除Fixture(1,4,1),
//			new 削除Fixture(3,5,3),
//			new 削除Fixture(-1,2,-1)
//		};
//		
//		@Theory
//		public void 削除(削除Fixture f){
//
//			BinarySearchTree<Integer, Integer> tree = 
//					new BinarySearchTree<Integer, Integer>();
//			tree.add(2, 2);
//			assertThat(tree.add(f.key, f.data), is(f.expecedIndex));
//			
//			
//		}
//
//		static class 削除Fixture{
//			Integer key;
//			Integer data;
//			Node<Integer, Integer> expecedIndex;
//			
//			public 削除Fixture(Integer key, Integer data, Node<Integer, Integer> expecedIndex) {
//				super();
//				this.key = key;
//				this.data = data;
//				this.expecedIndex = expecedIndex;
//			}
//		
//			@Override
//			public String toString() {
//				return String.format("when key =%s, data=%s, expecedIndex=%s", key, data, expecedIndex);
//			}
//		}
//	
//	}
	
	@RunWith(Theories.class)
	public static class 新規追加テスト{

		@DataPoints
		public static 追加Fixture[] FIXTURES = {
			new 追加Fixture(1,2,1),
			new 追加Fixture(2,3,2),
			new 追加Fixture(1,4,1),
			new 追加Fixture(3,5,3),
			new 追加Fixture(-1,2,-1)
		};
		
		@Theory
		public void 新規追加(追加Fixture f){
			BinarySearchTree<Integer, Integer> tree = 
					new BinarySearchTree<Integer, Integer>();
			assertThat(tree.add(f.key, f.data), is(f.expecedIndex));
		}
	}
	
	@RunWith(Theories.class)
	public static class 追加テスト{

		@DataPoints
		public static 追加Fixture[] FIXTURES = {
			new 追加Fixture(2,2,2),
			new 追加Fixture(1,3,null),
			new 追加Fixture(2,4,2),
			new 追加Fixture(4,5,4),
			new 追加Fixture(7,2,7)
		};
		
		@Theory
		public void 追加(追加Fixture f){
			BinarySearchTree<Integer, Integer> tree = 
					new BinarySearchTree<Integer, Integer>();
			tree.add(9, 9);
			tree.add(5, 5);
			tree.add(8, 8);
			tree.add(11, 11);
			tree.add(13, 13);
			tree.add(3, 3);
			tree.add(1, 1);
			assertThat(tree.add(f.key, f.data), is(f.expecedIndex));			
		}
	}
	
	static class 追加Fixture{
		Integer key;
		Integer data;
		Integer expecedIndex;
		
		public 追加Fixture(Integer key, Integer data, Integer expecedIndex) {
			super();
			this.key = key;
			this.data = data;
			this.expecedIndex = expecedIndex;
		}			
	
		@Override
		public String toString() {
			return String.format("when key =%s, data=%s, expecedIndex=%s", key, data, expecedIndex);
		}
	}
	
	@RunWith(Theories.class)
	public static class 探索テスト{

		@Theory
		public void 探索(){
			BinarySearchTree<Integer, Integer> tree = 
					new BinarySearchTree<Integer, Integer>();
			tree.add(1, 1);
			assertThat(tree.search(1), is(1));
			assertThat(tree.search(2), nullValue());
		}
		
		static class 探索Fixture{
			Integer key;
			Integer data;
			Integer expecedIndex;
			
			public 探索Fixture(Integer key, Integer data, Integer expecedIndex) {
				super();
				this.key = key;
				this.data = data;
				this.expecedIndex = expecedIndex;
			}			
		
			@Override
			public String toString() {
				return String.format("when key =%s, data=%s, expecedIndex=%s", key, data, expecedIndex);
			}
		}
	}
	
	
}
