class TreeNode {
    TreeNode left;
    TreeNode right;
}

public class BalanceTree {

    private static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = TreeDepth(root.left);

        int right = TreeDepth(root.right);

        return Math.max(left, right) + 1;

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        TreeNode left1 = new TreeNode();
        TreeNode right1 = new TreeNode();

        root1.left = left1;
        root1.right = right1;

        TreeNode root2 = new TreeNode();
        TreeNode left2 = new TreeNode();
        TreeNode left22 = new TreeNode();

        root2.left = left2;
        left2.left = left22;

        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));
    }

}