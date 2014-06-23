package com.slgerkamp.mkjavaalgorithm.stackandqueue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.slgerkamp.mkjavaalgorithm.stackandqueue.Queue.EmptyIntQueueException;
import com.slgerkamp.mkjavaalgorithm.stackandqueue.Queue.OverflowIntQueueException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Enclosed.class)
public class QueueTest {

	@RunWith(Theories.class)
	public static class キューが空の場合{
		
		public Queue emptyQueue;
		
		@Before
		public void setUp() throws Exception {
			emptyQueue = new Queue(5);
		}
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
				
		@Theory
		public void アイテムを取得することができない(){
			expectedException.expect(EmptyIntQueueException.class);
			emptyQueue.dequeue();
		}
		
		@Theory
		public void アイテムを覗き見することができない(){
			expectedException.expect(EmptyIntQueueException.class);
			emptyQueue.peek();
		}
		
		@Theory
		public void キューの容量に数字の2がない(){
			assertThat(emptyQueue.indexOf(2), is(-1));
		}
		
		@Theory
		public void キューをクリアする(){
			emptyQueue.clear();
			assertThat(emptyQueue.size(), is(0));
		}
		
		@Theory
		public void キューの容量が5である(){
			assertThat(emptyQueue.capacity(), is(5));
		}
		
		@Theory
		public void キューのポインターが0である(){
			assertThat(emptyQueue.size(), is(0));
		}
		
		@Theory
		public void キューが空である(){
			assertTrue(emptyQueue.isEmpty());
		}
		
		@Theory
		public void キューが満杯ではない(){
			assertFalse(emptyQueue.isFull());
		}
		
		@Theory
		public void キューの状態を出力(){
			assertThat(emptyQueue.dump(), is("キューは空です"));
		}		
	}


	@RunWith(Theories.class)
	public static class キューが満杯の場合{
		
		public Queue fullQueue;
		
		@Before
		public void setUp() throws Exception {
			fullQueue = new Queue(5);
			fullQueue.enqueue(1);
			fullQueue.enqueue(2);
			fullQueue.enqueue(3);
			fullQueue.enqueue(4);
			fullQueue.enqueue(5);
		}
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
		
		@Theory
		public void キューに数字の1を追加することができない(){
			expectedException.expect(OverflowIntQueueException.class);
			fullQueue.enqueue(1);
		}
				
		@Theory
		public void アイテムを取得する(){
			assertThat(fullQueue.dequeue(), is(1));
			assertThat(fullQueue.dequeue(), is(2));
			assertThat(fullQueue.dequeue(), is(3));
			assertThat(fullQueue.dequeue(), is(4));
			assertThat(fullQueue.dequeue(), is(5));
		}
		
		@Theory
		public void アイテムを覗き見する(){
			assertThat(fullQueue.peek(), is(1));
		}
		
		@Theory
		public void キューの容量に数字の2がある(){
			assertThat(fullQueue.indexOf(2), is(1));
		}
		
		@Theory
		public void キューをクリアする(){
			fullQueue.clear();
			assertThat(fullQueue.size(), is(0));
		}
		
		@Theory
		public void キューの容量が5である(){
			assertThat(fullQueue.capacity(), is(5));
		}
		
		@Theory
		public void キューのポインターが5である(){
			assertThat(fullQueue.size(), is(5));
		}
		
		@Theory
		public void キューが空ではない(){
			assertFalse(fullQueue.isEmpty());
		}
		
		@Theory
		public void キューが満杯である(){
			assertTrue(fullQueue.isFull());
		}
		
		@Theory
		public void キューの状態を出力(){
			assertThat(fullQueue.dump(), is("1,2,3,4,5,"));
		}
		
		
	}
}
