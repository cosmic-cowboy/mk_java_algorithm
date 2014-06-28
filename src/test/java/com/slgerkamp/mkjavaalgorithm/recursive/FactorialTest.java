package com.slgerkamp.mkjavaalgorithm.recursive;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


@RunWith(Theories.class)
public class FactorialTest {

	@DataPoints
	public static Fixture [] FIXTURES = {
		new Fixture(0, 1),
		new Fixture(1, 1),
		new Fixture(2, 2),
		new Fixture(3, 6),
		new Fixture(4, 24),
		new Fixture(5, 120),
		new Fixture(6, 720),
		new Fixture(7, 5040)
	};

	@Theory
	public void 階乗値を求める(Fixture f){
		assertThat(Factorial.factorial(f.target), is(f.expected));
	}

	static class Fixture{
		int target;
		int expected;
		
		public Fixture(int target, int expected) {
			super();
			this.target = target;
			this.expected = expected;
		}
		
		@Override
		public String toString() {
			return String.format("when target =%s, expected=%s", target, expected);
		}
	}
}
