package com.slgerkamp.mkjavaalgorithm.recursive;


import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 指定された個数のマス目に配置可能な組み合わせのテスト
 *
 */
@RunWith(Enclosed.class)
public class QueenTest {

	@RunWith(Theories.class)
	public static class 各行_各列に１個の王妃を配置する組み合わせテスト {
		
		@DataPoints
		public static Fixture [] FIXTURES = {
			new Fixture(2, 2),
			new Fixture(3, 6),
			new Fixture(4, 24),
			new Fixture(5, 120),
			new Fixture(6, 720),
			new Fixture(7, 5040),
			new Fixture(8, 40320)
		};
		
		@Theory
		public void 各行_各列に１個の王妃を配置する組み合わせ(Fixture f){
			assertThat(new QueenBB(f.num).set(), is(f.expected));
		}
		
	}

	@RunWith(Theories.class)
	public static class 指定された個数のマス目に配置可能な組み合わせのテスト {
		
		@DataPoints
		public static Fixture [] FIXTURES = {
			new Fixture(8, 16777216),
			new Fixture(2, 4),
			new Fixture(3, 27)
		};
		
		@Theory
		public void 指定された個数のマス目に配置可能な組み合わせ(Fixture f){
			assertThat(new QueenB(f.num).set(), is(f.expected));
		}
		
	}
	
	static class Fixture{
		int num;
		int expected;
		public Fixture(int num, int expected) {
			super();
			this.num = num;
			this.expected = expected;
		}
	}

}
