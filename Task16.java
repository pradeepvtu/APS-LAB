class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. Check if we have at least k nodes to reverse
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, we proceed with reversal
        if (count == k) {
            // 2. Reverse the first k nodes
            ListNode reversedHead = reverseLinkedList(head, k);

            // 3. head is now the tail of the reversed group.
            // Recursively call for the next part and connect it.
            head.next = reverseKGroup(curr, k);

            return reversedHead;
        }

        // If we have fewer than k nodes, leave them as they are
        return head;
    }

    // Helper function to reverse exactly k nodes
    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (k > 0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            k--;
        }
        
        return prev; // New head of the reversed section
    }
}
