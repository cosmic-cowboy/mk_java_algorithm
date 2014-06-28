package com.slgerkamp.mkjavaalgorithm.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Theories.class)
public class ResurTest {

	@DataPoints
	public static Fixture[] FIXTURES = {
		new Fixture(1, Arrays.asList(new Integer [] {1})),
		new Fixture(2, Arrays.asList(new Integer [] {1,2})),
		new Fixture(3, Arrays.asList(new Integer [] {1,2,3,1})),
		new Fixture(4, Arrays.asList(new Integer [] {1,2,3,1,4,1,2}))
	};
	
	@Theory
	public void 再帰テスト(Fixture f){
		assertThat(Resur.resur(f.num, new ArrayList<Integer>()), is(f.expected));
	}
	
	static class Fixture{
		
		int num;
		List<Integer> expected;
		
		public Fixture(int num, List<Integer> expected) {
			super();
			this.num = num;
			this.expected = expected;
		}
		
		@Override
		public String toString() {
			return String.format("when number =%s, expected=%s", num, expected);
		}
	}
}
