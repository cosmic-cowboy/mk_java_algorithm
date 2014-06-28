package com.slgerkamp.mkjavaalgorithm.recursive;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Enclosed.class)
public class EuclidGCDTest {

	@RunWith(Theories.class)
	public static class 再帰を使った最大公約数 {
		@DataPoints
		public static Fixture[] FIXTURES = {
			new Fixture(22, 8, 2),
			new Fixture(8, 22, 2),
			new Fixture(13, 11, 1),
		};
		
		@Theory
		public void 最大公約数を求める(Fixture f){
			assertThat(EuclidGCD.gcd(f.x, f.y), is(f.expected));
		}
		
	}

	@RunWith(Theories.class)
	public static class ループを使った最大公約数 {
		@DataPoints
		public static Fixture[] FIXTURES = {
			new Fixture(22, 8, 2),
			new Fixture(8, 22, 2),
			new Fixture(13, 11, 1),
		};
		
		@Theory
		public void 最大公約数を求める(Fixture f){
			assertThat(EuclidGCDLoop.gcd(f.x, f.y), is(f.expected));
		}
		
	}


	@RunWith(Theories.class)
	public static class 複数の要素の最大公約数 {
		@DataPoints
		public static ArrayFixture[] ARRAYFIXTURES = {
			new ArrayFixture(new int [] {22, 8, 4, 2}, 2),
			new ArrayFixture(new int [] {2,4, 8, 22}, 2),
			new ArrayFixture(new int [] {13, 11, 3, 4, 6}, 1),
			new ArrayFixture(new int [] {18,9, 27}, 9)
		};
		
		@Theory
		public void 最大公約数を求める(ArrayFixture f){
			assertThat(EuclidGCD.gcdArray(f.array), is(f.expected));
		}
	}

	static class Fixture{

		public int x;
		public int y;
		public int expected;
		
		public Fixture(int x, int y, int expected) {
			super();
			this.x = x;
			this.y = y;
			this.expected = expected;
		}

		@Override
		public String toString() {
			return String.format("when x =%s, y =%s, expected=%s", x, y, expected);
		}

	}
	

	static class ArrayFixture{

		public int [] array;
		public int expected;
		
		public ArrayFixture(int [] array, int expected) {
			super();
			this.array = array;
			this.expected = expected;
		}

		@Override
		public String toString() {
			return String.format("when array =%s, expected=%s", array, expected);
		}

	}

}
