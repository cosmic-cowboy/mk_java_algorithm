package com.slgerkamp.mkjavaalgorithm.sort;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.slgerkamp.mkjavaalgorithm.sort.BubbleSort.ORDER;

import static com.slgerkamp.mkjavaalgorithm.sort.IsSort.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * ソートテスト
 *
 */
@RunWith(Enclosed.class)
public class BubbleSortTest {

	@RunWith(Theories.class)
	public static class 単純交換ソート_バブルソート_昇順テスト_version3{
		
		@DataPoints
		public static SortFixture[] FIXTURES = {
			new SortFixture(new int [] {3,2,4,1}, new int [] {1,2,3,4}, 6),
			new SortFixture(new int [] {6,4,3,7,1,9,8}, new int [] {1,3,4,6,7,8,9}, 18),
			new SortFixture(new int [] {1,3,4,6,7,9,8}, new int [] {1,3,4,6,7,8,9}, 6)
		};

		@Theory
		public void 単純交換ソート_バブルソート_昇順(SortFixture f){
			assertThat(BubbleSort.bubbleSort_version3(f.targetArray, ORDER.ASCENDING), is(sortOf(f.expecedArray, f.expecedCounter)));
		}
	}

	@RunWith(Theories.class)
	public static class 単純交換ソート_バブルソート_降順テスト_version3{
		
		@DataPoints
		public static SortFixture[] FIXTURES = {
			new SortFixture(new int [] {3,2,4,1}, new int [] {4,3,2,1}, 5),
			new SortFixture(new int [] {6,4,3,7,1,9,8}, new int [] {9,8,7,6,4,3,1}, 18),
			new SortFixture(new int [] {9,8,7,6,4,3,1}, new int [] {9,8,7,6,4,3,1}, 6)
		};

		@Theory
		public void 単純交換ソート_バブルソート_降順(SortFixture f){
			assertThat(BubbleSort.bubbleSort_version3(f.targetArray, ORDER.DESCENDING), is(sortOf(f.expecedArray, f.expecedCounter)));
		}
	}
	@RunWith(Theories.class)
	public static class 単純交換ソート_バブルソート_昇順テスト{
		
		@DataPoints
		public static SortFixture[] FIXTURES = {
			new SortFixture(new int [] {3,2,4,1}, new int [] {1,2,3,4}, 6),
			new SortFixture(new int [] {6,4,3,7,1,9,8}, new int [] {1,3,4,6,7,8,9}, 18),
			new SortFixture(new int [] {1,3,4,6,7,9,8}, new int [] {1,3,4,6,7,8,9}, 11)
		};

		@Theory
		public void 単純交換ソート_バブルソート_昇順(SortFixture f){
			assertThat(BubbleSort.bubbleSort(f.targetArray, ORDER.ASCENDING), is(sortOf(f.expecedArray, f.expecedCounter)));
		}
	}

	@RunWith(Theories.class)
	public static class 単純交換ソート_バブルソート_降順テスト{
		
		@DataPoints
		public static SortFixture[] FIXTURES = {
			new SortFixture(new int [] {3,2,4,1}, new int [] {4,3,2,1}, 5),
			new SortFixture(new int [] {6,4,3,7,1,9,8}, new int [] {9,8,7,6,4,3,1}, 18),
			new SortFixture(new int [] {9,8,7,6,4,3,1}, new int [] {9,8,7,6,4,3,1}, 6)
		};

		@Theory
		public void 単純交換ソート_バブルソート_降順(SortFixture f){
			assertThat(BubbleSort.bubbleSort(f.targetArray, ORDER.DESCENDING), is(sortOf(f.expecedArray, f.expecedCounter)));
		}
	}
}
