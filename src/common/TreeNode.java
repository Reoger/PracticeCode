package common;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 构建二叉树
     */
    public static TreeNode getMockTreeNode(Integer[] array, int index) {
        TreeNode tn;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = getMockTreeNode(array, 2 * index + 1);
            tn.right = getMockTreeNode(array, 2 * index + 2);
            return tn;
        }
        return null;
    }

    public static void printfTree(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " -> ");
            printfTree(root.left);
            printfTree(root.right);
        }
    }

}
