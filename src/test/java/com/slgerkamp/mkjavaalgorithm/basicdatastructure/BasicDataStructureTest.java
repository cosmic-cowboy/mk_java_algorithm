package com.slgerkamp.mkjavaalgorithm.basicdatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Theories.class)
public class BasicDataStructureTest {
	
	@DataPoint
	public static Fixture PARAM_1 = 
		new Fixture(12, new ArrayList<Integer>((Arrays.asList(2,3,5,7,11))));

	@DataPoint
	public static Fixture PARAM_2 = 
		new Fixture(36, new ArrayList<Integer>((Arrays.asList(2,3,5,7,11,13,17,19,23,29,31))));

	@Theory
	public void 素数を求めるテスト(Fixture f){
		System.out.println(f);
		assertThat(BasicDataStructure.primeNumber(f.number), is(f.expected));
	}
	
	static class Fixture{
		int number;
		List<Integer> expected;
		
		public Fixture(int number, List<Integer> expected) {
			super();
			this.number = number;
			this.expected = expected;
		}

		@Override
		public String toString() {
			return String.format("when value =%s, expected=%s", number, expected);
		}
		
	}

}
