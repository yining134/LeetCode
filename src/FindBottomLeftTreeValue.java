import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = root.val;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            result = queue.peek().val;
            for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll();
               if (node.left != null) queue.add(node.left);
               if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }
}
