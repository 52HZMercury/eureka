package hot100;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-20 18:49
 **/
public class maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
