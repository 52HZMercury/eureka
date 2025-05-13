package LeetCodehot;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-02-26 13:06
 **/
public class subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    public static void dfs(int[] nums, int start, Deque<Integer> path, List<List<Integer>> res) {
        if(path.size() >= nums.length){
            return ;
        }
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }
}
