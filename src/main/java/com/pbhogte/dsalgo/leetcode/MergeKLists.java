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