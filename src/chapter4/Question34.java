package chapter4;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 二叉树中和为某一个值的路径
 *
 * @link {https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca}
 */


public class Question34 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca?f=discussion
     * 来源：牛客网
     * <p>
     * if(root == null) return listAll;
     * list.add(root.val);
     * target -= root.val;
     * if(target == 0 && root.left == null && root.right == null)
     * listAll.add(new ArrayList<Integer>(list));
     * FindPath(root.left, target);
     * FindPath(root.right, target);
     * list.remove(list.size()-1);
     */

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        int data = target - root.val;
        if (data == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }

        FindPath(root.left, data);
        FindPath(root.right, data);
        list.remove(list.size() - 1);

        return result;
    }


    @Test
    public void test() {
        Integer[] test1 = {1,2,3,4,5,3};
        ArrayList result = FindPath(TreeNode.getMockTreeNode(test1,0),7);
        System.out.println(result);
    }

}
