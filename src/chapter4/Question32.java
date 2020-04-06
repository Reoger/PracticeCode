package chapter4;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 *
 * @link {https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701}
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Question32 {

    @Test
    public void test() {
        Integer[] test1 = {1, 2, 3, 4, 5, 6};
        TreeNode node = TreeNode.getMockTreeNode(test1, 0);
        ArrayList result = PrintFromTopToBottom(node);
        System.out.println(Arrays.toString(new ArrayList[]{result}));

    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            result.add(tempNode.val);
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }

        return result;
    }

}
