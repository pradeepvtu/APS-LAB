public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // If a and b have different lengths, then they will stop the loop
        // after second iteration (at most)
        while (a != b) {
            // For the first iteration, we just reset the pointer to the head of the other linkedlist
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;    
        }

        return a;
    }
}
