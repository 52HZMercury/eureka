package LeetCodehot;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-05 14:08
 **/
public class permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        Deque<Integer> path =  new ArrayDeque<>();
        int[] used = new int[nums.length];
        dfs(res,path,nums,nums.length,used);
        return res;
    }

    public void dfs(List<List<Integer>> res,Deque<Integer> path,int[] nums,int length,int[] used){
        if(path.size() == length){
            res.add(new ArrayList(path));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(used[i] != 1){
                path.add(nums[i]);
                used[i] = 1;
                dfs(res,path,nums,length,used);
                used[i] = 0;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        permute p = new permute();
        List<List<Integer>> lists = p.permute(nums);

        System.out.print("[");
        for(int i = 0;i < lists.size();i++){
            System.out.print(Arrays.toString(lists.get(i).toArray()) + " ");
        }
        System.out.print("]");

    }

}
