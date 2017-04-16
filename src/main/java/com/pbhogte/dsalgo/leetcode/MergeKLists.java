package com.pbhogte.dsalgo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.pbhogte.utils.ListNode;

/**
 * Code's complexity is O(nlogk), n means the total elements and k means the size of list.
 * For a priority queue, insertion takes logK time
 *
 */
public class MergeKLists {
	
	public static void main (String[] args) {
		MergeKLists sol = new MergeKLists();
		ListNode list1 = new ListNode(1);
		ListNode list11 = new ListNode(3);
		list1.next = list11;
		
		ListNode list2 = new ListNode(2);
		ListNode list21 = new ListNode(4);
		list2.next = list21;
		
		ListNode[] lists = new ListNode[] {list1, list2};
		ListNode result = sol.mergeKLists(lists);
		System.out.println(result.val);
		
		ListNode list3 = new ListNode(1);
		ListNode list31 = new ListNode(2);
		list3.next = list31;
		ListNode list32 = new ListNode(3);
		list31.next = list32;
		ListNode list33 = new ListNode(4);
		list32.next = list33;
		System.out.println(list3.val);
		
		list3.print();
		result.print();
		
		if (! list3.equals(result)) {
			System.out.println("Lists did not merge correctly");
		}
		
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
    	
    	if (lists.length == 0) {
    		return null;
    	}
    	
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
                public int compare(ListNode n1, ListNode n2) {
                    if (n1.val == n2.val) return 0;
                    if (n1.val < n2.val) return -1;
                    else return 1;
                }
            } );
            
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        for (int i = 0; i<lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                System.out.println("Adding " + node.val);
                pq.add(node);
            }
        }
        
        while (! pq.isEmpty()) {
            ListNode node = pq.poll();
            System.out.println("Retrieving " + node.val);
            temp.next = node;
            if (node.next != null) {
                System.out.println("Adding " + node.next.val);
                pq.add(node.next);
            }
            temp = temp.next;
        }
        
        return result.next;
    }
    
}