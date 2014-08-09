package com.slgerkamp.mkjavaalgorithm.search;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ChainHashTest {

	@RunWith(Theories.class)
	public static class チェイン法で生成されたハッシュ値から目的の値を取得するテスト {
		
		@DataPoints
		public static Fixture [] PARAM = {
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, 33, 33),
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, 26, null)
		};
		
		@Theory
		public void 探索する(Fixture f){
			System.out.println(f);
			ChainHash<Integer, Integer> hash = 
					new ChainHash<Integer, Integer>(f.tableSize);
			for(int i : f.initData){
				hash.add(i, i);
			}
			assertThat(hash.search(f.searchNum), is(f.expected));
		}
		static class Fixture {
			int tableSize;
			int [] initData;
			int searchNum;
			Integer expected;
			
			/**
			 * 検索用フィクスチャ
			 * 
			 * @param tableSize : 配列数
			 * @param initData : 配列の実データ
			 * @param searchNum : 検索値
			 * @param expected : 期待値
			 */
			public Fixture(int tableSize, int[] initData, int searchNum,
					Integer expected) {
				super();
				this.tableSize = tableSize;
				this.initData = initData;
				this.searchNum = searchNum;
				this.expected = expected;
			}

			@Override
			public String toString() {
				return String.format(
						"when tableSize =%s, searchNum =%s, initData =%s, expected=%s", 
						tableSize, searchNum ,initData, expected);
			}
		}
	}
	
	@RunWith(Theories.class)
	public static class チェイン法でハッシュ値を追加するテスト {
		
		@DataPoints
		public static Fixture [] PARAM = {
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, 14,   14, 1, 14),
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, null, 13, 0, 13),
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, null, 46, 0, 46)
		};
		
		@Theory
		public void 追加する(Fixture f){
			System.out.println(f);
			// 事前準備 
			ChainHash<Integer, Integer> hash = 
					new ChainHash<Integer, Integer>(f.tableSize);
			for(int i : f.initData){
				hash.add(i, i);
			}
			
			// 確認 追加前
			assertThat(hash.search(f.addNum), is(f.beforeComfirmed));
			// 実行
			assertThat(hash.add(f.addNum, f.addNum), is(f.isAdd));
			// 確認 追加後
			assertThat(hash.search(f.addNum), is(f.expected));
		}
		
		static class Fixture {
			int tableSize;
			int [] initData;
			Integer beforeComfirmed;
			int addNum;
			int isAdd;
			Integer expected;
			
			/**
			 * @param tableSize : 配列数
			 * @param initData : 配列の実データ
			 * @param beforeComfirmed : 追加前に値が存在するか確認する値
			 * @param addNum : 追加する値
			 * @param isAdd : 追加されたかどうか
			 * @param expected : 期待値
			 */
			public Fixture(
					int tableSize, int[] initData, Integer beforeComfirmed, 
					int addNum, int isAdd, Integer expected) {
				super();
				this.tableSize = tableSize;
				this.initData = initData;
				this.beforeComfirmed = beforeComfirmed;
				this.addNum = addNum;
				this.isAdd = isAdd;
				this.expected = expected;
			}

			@Override
			public String toString() {
				return String.format(
						"when tableSize =%s, initData =%s, beforeComfirmed =%s, addNum =%s, isAdd =%s, expected=%s", 
						tableSize ,initData, beforeComfirmed, addNum, isAdd, expected);
			}

		}
	}

	@RunWith(Theories.class)
	public static class チェイン法でハッシュ値を削除するテスト {
		
		@DataPoints
		public static Fixture [] PARAM = {
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, 69, 69, 0, null, 17),
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, 17, 17, 0, null, 69),
			new Fixture(13, new int[]{14, 29, 17, 69, 5, 6, 33, 20}, null, 13, 1, null, null)
		};
		
		@Theory
		public void 追加する(Fixture f){
			System.out.println(f);
			// 事前準備 
			ChainHash<Integer, Integer> hash = 
					new ChainHash<Integer, Integer>(f.tableSize);
			for(int i : f.initData){
				hash.add(i, i);
			}
			
			// 確認 削除前
			assertThat(hash.search(f.removeNum), is(f.beforeRemoved));
			// 実行
			assertThat(hash.remove(f.removeNum, f.removeNum), is(f.isRemove));
			// 確認 削除後
			assertThat(hash.search(f.removeNum), is(f.expected));
			// 確認 同じハッシュ値に値がある場合、その値が残っていること
			if(f.sameHashNum != null){
				assertThat(hash.search(f.sameHashNum), is(f.sameHashNum));				
			}
		}
		
		static class Fixture {
			int tableSize;
			int [] initData;
			Integer beforeRemoved;
			int removeNum;
			int isRemove;
			Integer expected;
			Integer sameHashNum;
			
			@Override
			public String toString() {
				return String.format(
						"when tableSize =%s, initData =%s, beforeRemoved =%s, removeNum =%s, isRemove =%s, expected=%s", 
						tableSize ,initData, beforeRemoved, removeNum, isRemove, expected);
			}

			/**
			 * @param tableSize : 配列数
			 * @param initData : 配列の実データ
			 * @param beforeRemoved : 削除前に値が存在するか確認する値
			 * @param removeNum : 削除する値
			 * @param isRemove : 削除作業が実行されたか
			 * @param expected : 値が存在しないことんの確認
			 * @param sameHashNum : 同じハッシュ値の値がある場合、その値が残っていることを確認
			 */
			public Fixture(int tableSize, int[] initData,
					Integer beforeRemoved, int removeNum, int isRemove,
					Integer expected, Integer sameHashNum) {
				super();
				this.tableSize = tableSize;
				this.initData = initData;
				this.beforeRemoved = beforeRemoved;
				this.removeNum = removeNum;
				this.isRemove = isRemove;
				this.expected = expected;
				this.sameHashNum = sameHashNum;
			}

		}
	}

}
