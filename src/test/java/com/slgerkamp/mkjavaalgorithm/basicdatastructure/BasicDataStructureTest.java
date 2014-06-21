package com.slgerkamp.mkjavaalgorithm.basicdatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Enclosed.class)
public class BasicDataStructureTest {

	@RunWith(Theories.class)
	public static class 素数を求めるテスト{
		@DataPoints
		public static Fixture [] PARAM_1 = 
			{
				new Fixture(12, new ArrayList<Integer>((Arrays.asList(2,3,5,7,11)))),
				new Fixture(36, new ArrayList<Integer>((Arrays.asList(2,3,5,7,11,13,17,19,23,29,31))))
			};
	
		@Theory
		public void 素数を求める(Fixture f){
			System.out.println(f);
			assertThat(BasicDataStructure.primeNumber(f.number), is(f.expected));
		}
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
	

	@RunWith(Theories.class)
	public static class 今日で今年が何日終わったかを求めるテスト{
		@DataPoints
		public static DayInYearFixture [] PARAM_1 = 
			{
				new DayInYearFixture(2009, 3, 15, 74)
			};
	
		@Theory
		public void 今日で今年が何日終わったか(DayInYearFixture f){
			System.out.println(f);
			assertThat(BasicDataStructure.dayInYear(f.year, f.month, f.day), is(f.expected));
		}
	}
	
	static class DayInYearFixture{
		int year;
		int month;
		int day;
		int expected;

		public DayInYearFixture(int year, int month, int day, int expected) {
			super();
			this.year = year;
			this.month = month;
			this.day = day;
			this.expected = expected;
		}

		@Override
		public String toString() {
			return String.format("when value year=%s, month=%s, day=%s, expected=%s", year, month, day, expected);
		}
		
	}

}
