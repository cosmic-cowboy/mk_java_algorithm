package com.slgerkamp.mkjavaalgorithm.recursive;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * 重ねられた円盤を最短の回数で移すためのアルゴリズムのテスト
 *
 */
@RunWith(Theories.class)
public class TowerOfHanoiTest {

	@DataPoints
	public static Fixture [] FIXTURES = {
		new Fixture(2, 1, 3, 0, 3),
		new Fixture(3, 1, 3, 0, 7)
	};
	
	@Theory
	public void 重ねられた円盤を移すための最短距離を求める(Fixture f){
		assertThat(TowerOfHanoi.move(f.no, f.depature, f.distination, f.counter) ,is(f.expected));
	}
	
	static class Fixture{
		int no;
		int depature;
		int distination;
		int counter;
		int expected;
		
		public Fixture(int no, int depature, int distination, int counter,
				int expected) {
			super();
			this.no = no;
			this.depature = depature;
			this.distination = distination;
			this.counter = counter;
			this.expected = expected;
		}
		
		@Override
		public String toString() {
			// TODO 自動生成されたメソッド・スタブ
			return String.format("when no =%s, depature =%s, depature =%s, expected=%s", no, depature,depature, expected);
		}
		
	}
}
