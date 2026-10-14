
import java.util.*;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();

            if (a == null && b == null) {
                continue;
            }

            if (a == null || b == null) {
                return false;
            }

            if (a.val != b.val) {
                return false;
            }

            queue.add(a.left);
            queue.add(b.left);

            queue.add(a.right);
            queue.add(b.right);
        }

        return true;
    }
}
