package com.pbhogte.dsalgo.leetcode;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.pbhogte.dsalgo.leetcode.MergeKLists;
import com.pbhogte.utils.ListNode;

public class MergeKListsTest {

	private static MergeKLists sol = new MergeKLists();
	
	@Test
	public void test1() {
		ListNode list1 = new ListNode(1);
		ListNode list11 = new ListNode(3);
		list1.next = list11;
		
		ListNode list2 = new ListNode(2);
		ListNode list21 = new ListNode(4);
		list2.next = list21;
		
		ListNode[] lists = new ListNode[] {list1, list2};
		ListNode result = sol.mergeKLists(lists);
		
		ListNode list3 = new ListNode(1);
		ListNode list31 = new ListNode(2);
		list3.next = list31;
		ListNode list32 = new ListNode(3);
		list31.next = list32;
		ListNode list33 = new ListNode(4);
		list32.next = list33;
		
		list3.print();
		result.print();
		
		if (! result.equals(list3)) {
			fail("Lists did not merge correctly");
		}
	}

	@Test
	public void test2() {
		ListNode list1 = new ListNode(1);
		ListNode list11 = new ListNode(3);
		list1.next = list11;
		
		ListNode list2 = null;
		
		ListNode[] lists = new ListNode[] {list1, list2};
		ListNode result = sol.mergeKLists(lists);
		
		ListNode list3 = new ListNode(1);
		ListNode list31 = new ListNode(3);
		list3.next = list31;
		
		list3.print();
		result.print();
		
		if (! result.equals(list3)) {
			fail("Lists did not merge correctly");
		}
	}
	
	@Test
	public void test3() {
		ListNode list1 = null;
		ListNode list2 = null;
		ListNode[] lists = new ListNode[] {list1, list2};
		ListNode result = sol.mergeKLists(lists);
		if ( result != null ) {
			fail("null result was expected");
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void test4() {
		ListNode list1 = null;
		ListNode list2 = null;
		ListNode[] lists = {};
		sol.mergeKLists(lists);
	}
	
}
