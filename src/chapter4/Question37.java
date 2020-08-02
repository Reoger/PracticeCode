package chapter4;

import common.TreeNode;
import org.junit.Test;

/**
 * 序列化二叉树
 *
 * @link {https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84}
 */


public class Question37 {

    @Test
    public void test() {
        Integer[] test1 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode node = TreeNode.getMockTreeNode(test1, 0);
        TreeNode root = node;
        String data = Serialize(root);
        root = node;
        TreeNode.printfTree(root);
        System.out.println();
        TreeNode.inOrder(root);

        System.out.println();
        System.out.println(data);

        TreeNode result = Deserialize(data);
        TreeNode.printfTree(result);

    }


    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "null,";
        }

        sb.append(root.val).append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }


    private int index = -1;
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        index = -1;
        return DeserializeCore(str.split(","));
    }

    private TreeNode DeserializeCore(String[] nodes) {
        index++;
        if(nodes.length <= index) {
            return null;
        }

        String val = nodes[index];
        if("null".equals(val)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = DeserializeCore(nodes);
        root.right = DeserializeCore(nodes);

        return root;
    }


}
