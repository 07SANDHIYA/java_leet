
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // If the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the length of the linked list
        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Remove unnecessary rotations
        k = k % length;

        // If k becomes 0, no rotation is needed
        if (k == 0) {
            return head;
        }

        // Step 3: Connect the last node to the first node
        temp.next = head;

        // Step 4: Find the new last node
        int steps = length - k;
        ListNode newLast = head;

        for (int i = 1; i < steps; i++) {
            newLast = newLast.next;
        }

        // Step 5: Update the new head
        ListNode newHead = newLast.next;

        // Step 6: Break the circular linked list
        newLast.next = null;

        return newHead;
    }
}
