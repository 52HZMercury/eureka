package hot100;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-11 19:18
 **/
public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return dfs(left.right,right.left) && dfs(left.left,right.right);
    }
}
