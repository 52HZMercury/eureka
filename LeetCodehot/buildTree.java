package LeetCodehot;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-25 19:39
 **/
public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 创建哈希表存储中序遍历的值到索引的映射
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            //map建立映射关系，这道题的所有结点的值都不一样，所以作为键
            map.put(inorder[i],i);
        }
        return buildTreeHelper(map,preorder,inorder,0,preorder.length,0,inorder.length);
    }

    private TreeNode buildTreeHelper(Map<Integer,Integer> map,int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd) {
        //递归出口
        if(preStart == preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //找到中序遍历中的头节点位置
        int rootIndex = map.get(rootVal);
        //左边有多少个
        int leftNum = rootIndex - inStart;
        root.left = buildTreeHelper(map,preorder,inorder,preStart + 1,preStart + leftNum + 1,inStart,rootIndex);
        root.right = buildTreeHelper(map,preorder,inorder,preStart + leftNum + 1,preEnd,rootIndex + 1,inEnd);
        return root;
    }
}
