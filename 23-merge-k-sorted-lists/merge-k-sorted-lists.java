import java.util.*;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of every list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process heap
        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode smallest = pq.poll();

            // Add it to result
            current.next = smallest;
            current = current.next;

            // Add next node from same list
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}