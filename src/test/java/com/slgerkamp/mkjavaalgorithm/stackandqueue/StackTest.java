package com.slgerkamp.mkjavaalgorithm.stackandqueue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.slgerkamp.mkjavaalgorithm.stackandqueue.Stack.EmptyIntStackException;
import com.slgerkamp.mkjavaalgorithm.stackandqueue.Stack.OverflowIntStackException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Enclosed.class)
public class StackTest {

	@RunWith(Theories.class)
	public static class スタックが空の場合{
		
		@DataPoint
		public static Stack emptyStack = new Stack(5);
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
		
		@Theory
		public void スタックに数字の1を追加する(Stack emptyStack){
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
			assertThat(emptyStack.push(1), is(1));
		}
				
		@Theory
		public void アイテムを取得することができない(Stack emptyStack){
			expectedException.expect(EmptyIntStackException.class);
			emptyStack.pop();
		}
		
		@Theory
		public void アイテムを覗き見することができない(Stack emptyStack){
			expectedException.expect(EmptyIntStackException.class);
			emptyStack.peek();
		}
		
		@Theory
		public void スタックの容量に数字の2がない(Stack emptyStack){
			assertThat(emptyStack.indexOf(2), is(-1));
		}
		
		@Theory
		public void スタックをクリアする(Stack emptyStack){
			emptyStack.clear();
			assertThat(emptyStack.size(), is(0));
		}
		
		@Theory
		public void スタックの容量が5である(Stack emptyStack){
			assertThat(emptyStack.capacity(), is(5));
		}
		
		@Theory
		public void スタックのポインターが0である(Stack emptyStack){
			assertThat(emptyStack.size(), is(0));
		}
		
		@Theory
		public void スタックが空である(Stack emptyStack){
			assertTrue(emptyStack.isEmpty());
		}
		
		@Theory
		public void スタックが満杯ではない(Stack emptyStack){
			assertFalse(emptyStack.isFull());
		}
		
		@Theory
		public void スタックの状態を出力(Stack emptyStack){
			assertThat(emptyStack.dump(), is("スタックは空です"));
		}		
	}


	@RunWith(Theories.class)
	public static class スタックが満杯の場合{
		
		public Stack fullStack;
		
		@Before
		public void setUp() throws Exception {
			fullStack = new Stack(5);
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
			expectedException.expect(OverflowIntStackException.class);
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
}
