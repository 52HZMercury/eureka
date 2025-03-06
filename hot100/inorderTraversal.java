package hot100;


import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-06 12:37
 **/
public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        infixorder(res,root);
        return res;
    }

    public void infixorder(ArrayList<Integer> res,TreeNode cur){
        if(cur == null){
            return;
        }
        infixorder(res,cur.left);
        res.add(cur.val);
        infixorder(res,cur.right);
    }
}
