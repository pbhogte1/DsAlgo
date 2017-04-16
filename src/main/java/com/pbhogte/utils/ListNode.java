package com.pbhogte.utils;

/**
 * Helper class
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) { 
		val = x; 
	}

	public void print() {
		System.out.print(val);
		while (next != null) {
			System.out.print("  " + next.val);
			next = next.next;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + val;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		
		ListNode curr = this;
		while (curr != null) {
			if (other == null) {
				System.out.println("other is null");
				return false;
			}
			if (this.val != other.val) {
				System.out.println("diff val " + val + " ," + other.val);
				return false;
			}
			curr = curr.next;
			other = other.next;
		}
		
		if (other != null) {
			return false;
		}
		
		return true;
	}
}
