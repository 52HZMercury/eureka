package LeetCodehot;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-04-01 16:45
 **/
public class maxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值，
        // 因为单个节点也可以作为一条路径，因此若为负则不计入，相当于舍弃负的这边
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        // 当前节点作为路径中间节点的总路径和
        int currentPathSum = node.val + left + right;
        maxSum = Math.max(maxSum, currentPathSum);

        // 返回当前节点作为左子树或者右子树的最大贡献值（单边路径）
        return node.val + Math.max(left, right);
    }
}
