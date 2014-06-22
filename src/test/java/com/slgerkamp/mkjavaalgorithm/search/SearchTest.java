package com.slgerkamp.mkjavaalgorithm.search;

import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Enclosed.class)
public class SearchTest {

	@RunWith(Theories.class)
	public static class 探索_２分探索テスト_重複あり{
		@DataPoints
		public static Fixture [] PARAM_1 = {
			new Fixture(new int[]{ 1, 3, 4, 4, 4, 4, 5, 6, 7, 8 },  4, 2),
			new Fixture(new int[]{ 4, 4, 4, 5, 6, 7 },  4, 0),
			new Fixture(new int[]{ 1, 3, 3, 3, 4, 5, 6},  4, 4),
			new Fixture(new int[]{ 1, 3, 4},  4, 2),
			new Fixture(new int[]{ 1, 3},  4, -1),
			new Fixture(new int[]{ 5, 7},  4, -1)
		};
		
		@Theory
		public void 探索_２分探索(Fixture f){
			System.out.println(f);
			assertThat(Search.binarySearchX(f.intArray, f.searchNumber), is(f.expected));
		}
	
		static class Fixture {
			int [] intArray;
			int searchNumber;
			int expected;
			
			public Fixture( int[] intArray, int searchNumber, int expected) {
				super();
				this.intArray = intArray;
				this.searchNumber = searchNumber;
				this.expected = expected;
			}
			
			@Override
			public String toString() {
				return String.format("when searchNumber =%s, intArray =%s, expected=%s", searchNumber,intArray, expected);
			}
		}
	}


	@RunWith(Theories.class)
	public static class 探索_２分探索テスト{
		@DataPoints
		public static Fixture [] PARAM_1 = {
			new Fixture(new int[]{ 1, 3, 4, 5, 6, 7, 8 },  4, 2),
			new Fixture(new int[]{ 1, 3, 4, 5, 6, 7 },  4, 2),
			new Fixture(new int[]{ 1, 3, 4, 5, 6},  4, 2),
			new Fixture(new int[]{ 1, 3, 4},  4, 2),
			new Fixture(new int[]{ 1, 3},  4, -1),
			new Fixture(new int[]{ 5, 7},  4, -1)
		};
		
		@Theory
		public void 探索_２分探索(Fixture f){
			System.out.println(f);
			assertThat(Search.binarySearch(f.intArray, f.searchNumber), is(f.expected));
		}
	
		static class Fixture {
			int [] intArray;
			int searchNumber;
			int expected;
			
			public Fixture( int[] intArray, int searchNumber, int expected) {
				super();
				this.intArray = intArray;
				this.searchNumber = searchNumber;
				this.expected = expected;
			}
			
			@Override
			public String toString() {
				return String.format("when searchNumber =%s, intArray =%s, expected=%s", searchNumber,intArray, expected);
			}
		}
	}
}