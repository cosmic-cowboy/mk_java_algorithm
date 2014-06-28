package com.slgerkamp.mkjavaalgorithm.recursive;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Theories.class)
public class EuclidGCDTest {

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
}
