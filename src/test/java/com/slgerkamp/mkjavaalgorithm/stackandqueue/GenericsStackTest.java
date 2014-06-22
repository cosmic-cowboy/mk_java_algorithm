package com.slgerkamp.mkjavaalgorithm.stackandqueue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.slgerkamp.mkjavaalgorithm.stackandqueue.GenericsStack.GenericsEmptyIntStackException;
import com.slgerkamp.mkjavaalgorithm.stackandqueue.GenericsStack.GenericsOverflowIntStackException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Enclosed.class)
public class GenericsStackTest {

	@RunWith(Theories.class)
	public static class スタックが空の場合{
		
		@DataPoint
		public static GenericsStack<Integer> emptyStack = new GenericsStack<Integer>(5);
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
		
		@Theory
		public void スタックに数字の1を追加する(GenericsStack<Integer> emptyStack){
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
		}
				
		@Theory
		public void アイテムを取得することができない(GenericsStack<Integer> emptyStack){
			expectedException.expect(GenericsEmptyIntStackException.class);
			emptyStack.pop();
		}
		
		@Theory
		public void アイテムを覗き見することができない(GenericsStack<Integer> emptyStack){
			expectedException.expect(GenericsEmptyIntStackException.class);
			emptyStack.peek();
		}
		
		@Theory
		public void スタックの容量に数字の2がない(GenericsStack<Integer> emptyStack){
			assertThat(emptyStack.indexOf(2), is(-1));
		}
		
		@Theory
		public void スタックをクリアする(GenericsStack<Integer> emptyStack){
			emptyStack.clear();
			assertThat(emptyStack.size(), is(0));
		}
		
		@Theory
		public void スタックの容量が5である(GenericsStack<Integer> emptyStack){
			assertThat(emptyStack.capacity(), is(5));
		}
		
		@Theory
		public void スタックのポインターが0である(GenericsStack<Integer> emptyStack){
			assertThat(emptyStack.size(), is(0));
		}
		
		@Theory
		public void スタックが空である(GenericsStack<Integer> emptyStack){
			assertTrue(emptyStack.isEmpty());
		}
		
		@Theory
		public void スタックが満杯ではない(GenericsStack<Integer> emptyStack){
			assertFalse(emptyStack.isFull());
		}
		
		@Theory
		public void スタックの状態を出力(GenericsStack<Integer> emptyStack){
			assertThat(emptyStack.dump(), is("スタックは空です"));
		}		
	}


	@RunWith(Theories.class)
	public static class スタックが満杯の場合{
		
		public GenericsStack<Integer> fullStack;
		
		@Before
		public void setUp() throws Exception {
			fullStack = new GenericsStack<Integer>(5);
			fullStack.push(1);
			fullStack.push(2);
			fullStack.push(3);
			fullStack.push(4);
			fullStack.push(5);
		}
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
		
		@Theory
		public void スタックに数字の1を追加することができない(){
			expectedException.expect(GenericsOverflowIntStackException.class);
			fullStack.push(1);
		}
				
		@Theory
		public void アイテムを取得する(){
			assertThat(fullStack.pop(), is(5));
			assertThat(fullStack.pop(), is(4));
			assertThat(fullStack.pop(), is(3));
			assertThat(fullStack.pop(), is(2));
			assertThat(fullStack.pop(), is(1));
		}
		
		@Theory
		public void アイテムを覗き見する(){
			assertThat(fullStack.peek(), is(5));
		}
		
		@Theory
		public void スタックの容量に数字の2がある(){
			assertThat(fullStack.indexOf(2), is(1));
		}
		
		@Theory
		public void スタックをクリアする(){
			fullStack.clear();
			assertThat(fullStack.size(), is(0));
		}
		
		@Theory
		public void スタックの容量が5である(){
			assertThat(fullStack.capacity(), is(5));
		}
		
		@Theory
		public void スタックのポインターが5である(){
			assertThat(fullStack.size(), is(5));
		}
		
		@Theory
		public void スタックが空ではない(){
			assertFalse(fullStack.isEmpty());
		}
		
		@Theory
		public void スタックが満杯である(){
			assertTrue(fullStack.isFull());
		}
		
		@Theory
		public void スタックの状態を出力(){
			assertThat(fullStack.dump(), is("1,2,3,4,5,"));
		}
	}
		

	@RunWith(Theories.class)
	public static class String型スタックが満杯の場合{
		
		public GenericsStack<String> fullStack;
		
		@Before
		public void setUp() throws Exception {
			fullStack = new GenericsStack<String>(5);
			fullStack.push("Ringo");
			fullStack.push("John");
			fullStack.push("Paul");
			fullStack.push("George");
			fullStack.push("Stuart");
		}
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
		
		@Theory
		public void スタックに数字の1を追加することができない(){
			expectedException.expect(GenericsOverflowIntStackException.class);
			fullStack.push("Pete");
		}
				
		@Theory
		public void アイテムを取得する(){
			assertThat(fullStack.pop(), is("Stuart"));
			assertThat(fullStack.pop(), is("George"));
			assertThat(fullStack.pop(), is("Paul"));
			assertThat(fullStack.pop(), is("John"));
			assertThat(fullStack.pop(), is("Ringo"));
		}
		
		@Theory
		public void アイテムを覗き見する(){
			assertThat(fullStack.peek(), is("Stuart"));
		}
		
		@Theory
		public void スタックの容量に数字の2がある(){
			assertThat(fullStack.indexOf("Paul"), is(2));
		}
		
		@Theory
		public void スタックをクリアする(){
			fullStack.clear();
			assertThat(fullStack.size(), is(0));
		}
		
		@Theory
		public void スタックの容量が5である(){
			assertThat(fullStack.capacity(), is(5));
		}
		
		@Theory
		public void スタックのポインターが5である(){
			assertThat(fullStack.size(), is(5));
		}
		
		@Theory
		public void スタックが空ではない(){
			assertFalse(fullStack.isEmpty());
		}
		
		@Theory
		public void スタックが満杯である(){
			assertTrue(fullStack.isFull());
		}
		
		@Theory
		public void スタックの状態を出力(){
			assertThat(fullStack.dump(), is("Ringo,John,Paul,George,Stuart,"));
		}
		
	}
}
