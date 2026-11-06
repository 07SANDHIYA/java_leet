
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Create a dummy node to handle reversing from position 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move to the node just before the left position
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start reversing from the left position
        ListNode curr = prev.next;

        // Reverse the nodes between left and right
        for (int i = 0; i < right - left; i++) {

            ListNode nextNode = curr.next;

            curr.next = nextNode.next;

            nextNode.next = prev.next;

            prev.next = nextNode;
        }

        return dummy.next;
    }
}
