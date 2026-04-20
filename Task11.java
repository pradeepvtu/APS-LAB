/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // We use two pointers, slow and fast.
        // slow moves 1 step at a time, fast moves 2 steps.
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list. When fast reaches the end, 
        // slow will be at the exact middle.
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer 1 step
            fast = fast.next.next;     // Move fast pointer 2 steps
        }

        // Return the slow pointer which is now pointing at the middle node.
        return slow;
    }
}
