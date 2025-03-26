package hot100;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-26 14:32
 **/
public class flatten {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                //找左子树最右边的结点
                TreeNode cur =  root.left;
                while(cur.right != null){
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                //记得置空左边
                root.left = null;
                root = root.right;
            }
        }
    }
}
