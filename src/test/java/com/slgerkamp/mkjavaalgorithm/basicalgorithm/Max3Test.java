package com.slgerkamp.mkjavaalgorithm.basicalgorithm;

import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * ３値の最大値を求めるテストクラス
 * パラメータ化テストを実践
 * Theoriesはパラメータ化されたユニットテストをサポートするテストランナー
 * RunWithで指定する
 */
@RunWith(Theories.class)
public class Max3Test {
	

	// パラメータを定義する（public かつ static）
	@DataPoint
	public static Fixture PARAM_1 = new Fixture(3,2,1,3);
	@DataPoint
	public static Fixture PARAM_2 = new Fixture(3,2,2,3);
	@DataPoint
	public static Fixture PARAM_3 = new Fixture(3,1,2,3);

	// 複数のパラメータをまとめて定義する（public かつ static）
	@DataPoints
	public static Fixture[] FIXTURES = {
		new Fixture(3,2,3,3),
		new Fixture(2,1,3,3),
		new Fixture(3,3,2,3),
		new Fixture(3,3,3,3),
		new Fixture(2,2,3,3),
		new Fixture(2,3,1,3),
		new Fixture(2,3,2,3),
		new Fixture(1,3,2,3),
		new Fixture(2,3,3,3),
		new Fixture(1,2,3,3)
	};

	// パラメータ化テストを行うメソッドは@Testのかわりに@Theoryアノテーションを使用
	// 複数のメソッドがある場合は
	@Theory
	public void 数字３つから最大値を選ぶ(Fixture f){
		// ３つのテストが行われているか確認用
		System.out.println(f);
		assertThat(BasicAlgorithm.maxInt(f.a, f.b, f.c), is(f.expected));

	}
	
	// パラメータをFixtureオブジェクトにまとめる
	static class Fixture {
		// テストデータ
		int a;
		int b;
		int c;
		// 期待値
		int expected;
		
		Fixture(int a, int b, int c, int expected) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
			this.expected = expected;
		}
		
		@Override
		public String toString() {
			return String.format("when value a=%s b=%s, c=%s, expected=%s", a, b, c, expected);
		}
	}
}
