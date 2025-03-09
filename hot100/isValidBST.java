package hot100;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-09 14:37
 **/
public class isValidBST {
    // 二叉搜索树的中序遍历都是递增的
    public boolean isValidBST(TreeNode root) {
        // integer的默认未初始化是null, int是0
        Integer[] preVal = new Integer[1];
        return infixOrder(root, preVal);
    }

    public boolean infixOrder(TreeNode node, Integer[] preVal) {
        if(node == null){
            return true;
        }
        // 遍历左子树
        boolean left = infixOrder(node.left, preVal);
        if (preVal[0] != null && preVal[0] >= node.val) {
            return false;
        }
        // 更新前一个节点的值为当前节点的值
        preVal[0] = node.val;
        // 遍历右子树
        boolean right = infixOrder(node.right, preVal);

        return left && right;
    }
}
