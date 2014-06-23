package com.slgerkamp.mkjavaalgorithm.stackandqueue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.slgerkamp.mkjavaalgorithm.stackandqueue.RingBufferQueue.EmptyIntRingBufferQueueException;
import com.slgerkamp.mkjavaalgorithm.stackandqueue.RingBufferQueue.OverflowIntRingBufferQueueException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Enclosed.class)
public class RingBufferQueueTest {

	@RunWith(Theories.class)
	public static class キューが空の場合{
		
		public RingBufferQueue emptyRingBufferQueue;
		
		@Before
		public void setUp() throws Exception {
			emptyRingBufferQueue = new RingBufferQueue(5);
		}
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
		
		@Theory
		public void キューに数字の1を追加する(){
			assertThat(emptyRingBufferQueue.enqueue(1), is(1));
			assertThat(emptyRingBufferQueue.enqueue(1), is(1));
			assertThat(emptyRingBufferQueue.enqueue(1), is(1));
			assertThat(emptyRingBufferQueue.enqueue(1), is(1));
			assertThat(emptyRingBufferQueue.enqueue(1), is(1));
		}
				
		@Theory
		public void アイテムを取得することができない(){
			expectedException.expect(EmptyIntRingBufferQueueException.class);
			emptyRingBufferQueue.dequeue();
		}
		
		@Theory
		public void アイテムを覗き見することができない(){
			expectedException.expect(EmptyIntRingBufferQueueException.class);
			emptyRingBufferQueue.peek();
		}
		
		@Theory
		public void キューの容量に数字の2がない(){
			assertThat(emptyRingBufferQueue.indexOf(2), is(-1));
		}
		
		@Theory
		public void キューをクリアする(){
			emptyRingBufferQueue.clear();
			assertThat(emptyRingBufferQueue.size(), is(0));
		}
		
		@Theory
		public void キューの容量が5である(){
			assertThat(emptyRingBufferQueue.capacity(), is(5));
		}
		
		@Theory
		public void キューのポインターが0である(){
			assertThat(emptyRingBufferQueue.size(), is(0));
		}
		
		@Theory
		public void キューが空である(){
			assertTrue(emptyRingBufferQueue.isEmpty());
		}
		
		@Theory
		public void キューが満杯ではない(){
			assertFalse(emptyRingBufferQueue.isFull());
		}
		
		@Theory
		public void キューの状態を出力(){
			assertThat(emptyRingBufferQueue.dump(), is("キューは空です"));
		}		
	}


	@RunWith(Theories.class)
	public static class キューが満杯の場合{
		
		public RingBufferQueue fullRingBufferQueue;
		
		@Before
		public void setUp() throws Exception {
			fullRingBufferQueue = new RingBufferQueue(5);
			fullRingBufferQueue.enqueue(1);
			fullRingBufferQueue.enqueue(2);
			fullRingBufferQueue.enqueue(3);
			fullRingBufferQueue.enqueue(4);
			fullRingBufferQueue.enqueue(5);
		}
		
		@Rule
		public ExpectedException expectedException = ExpectedException.none();
		
		@Theory
		public void キューに数字の1を追加することができない(){
			expectedException.expect(OverflowIntRingBufferQueueException.class);
			assertThat(fullRingBufferQueue.enqueue(1), is(1));
		}
				
		@Theory
		public void アイテムを取得する(){
			assertThat(fullRingBufferQueue.dequeue(), is(1));
			assertThat(fullRingBufferQueue.dequeue(), is(2));
			assertThat(fullRingBufferQueue.dequeue(), is(3));
			assertThat(fullRingBufferQueue.dequeue(), is(4));
			assertThat(fullRingBufferQueue.dequeue(), is(5));
		}
		
		@Theory
		public void アイテムを覗き見する(){
			assertThat(fullRingBufferQueue.peek(), is(1));
		}
		
		@Theory
		public void キューの容量に数字の2がある(){
			assertThat(fullRingBufferQueue.indexOf(2), is(1));
		}
		
		@Theory
		public void キューをクリアする(){
			fullRingBufferQueue.clear();
			assertThat(fullRingBufferQueue.size(), is(0));
		}
		
		@Theory
		public void キューの容量が5である(){
			assertThat(fullRingBufferQueue.capacity(), is(5));
		}
		
		@Theory
		public void キューのポインターが5である(){
			assertThat(fullRingBufferQueue.size(), is(5));
		}
		
		@Theory
		public void キューが空ではない(){
			assertFalse(fullRingBufferQueue.isEmpty());
		}
		
		@Theory
		public void キューが満杯である(){
			assertTrue(fullRingBufferQueue.isFull());
		}
		
		@Theory
		public void キューの状態を出力(){
			assertThat(fullRingBufferQueue.dump(), is("1,2,3,4,5,"));
		}
		
		
	}
}
