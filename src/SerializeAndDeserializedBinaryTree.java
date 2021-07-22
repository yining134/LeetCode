import utils.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class SerializeAndDeserializedBinaryTree {
    String SEP = ",";
    String NULL = "#";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s: data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String val = nodes.removeFirst();
        if (val.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    public String serialize2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                sb.append(root.val).append(SEP);
                stack.push(root);
                root = root.left;
            }
            sb.append(NULL).append(SEP);
            root = stack.pop();
            root = root.right;
        }
        return sb.toString();
    }

    public TreeNode deserialize2(String data) {
        if (data.equals("")) return null;
        LinkedList<String> s = new LinkedList<>();
        for (String str: data.split(SEP)) {
            s.addLast(str);
        }

        Stack<TreeNode> stack = new Stack<>();
        String val = s.removeFirst();
        TreeNode root = new TreeNode(Integer.parseInt(val));
        stack.push(root);
        TreeNode cur = root;
        boolean flag = false;//用于标记当前val为#时，遍历开始转向

        while (!s.isEmpty()) {
            val = s.removeFirst();
            while (!val.equals(NULL)) {
                if (flag) {
                    flag = false;
                    cur.right = new TreeNode(Integer.parseInt(val));
                    cur = cur.right;
                } else {
                    cur.left = new TreeNode(Integer.parseInt(val));
                    cur = cur.left;
                }
                stack.push(cur);
                val = s.removeFirst();
            }

            cur = stack.pop();
            flag = true;
        }
        return root;
    }

    public TreeNode serialize3(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        SerializeAndDeserializedBinaryTree solution = new SerializeAndDeserializedBinaryTree();
        TreeNode root = TreeNode.createTree(new Integer[]{1, 2, 3, null, 4, 5});
        TreeNode.printTree(root);
        String result = solution.serialize(root);
        System.out.println(result);

        String result2 = solution.serialize2(root);
        System.out.println(result2);

        TreeNode node = solution.deserialize2(result2);
        TreeNode.printTree(node);
    }
}
