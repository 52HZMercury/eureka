package hot100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-04-03 14:38
 **/
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        //考虑特殊情况
        if(len == 0){
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;//即使是一个元素，也可以是一个连续的元素
        int[] dp = new int[len];
        dp[0] = 1;
        for(int cur = 1;cur < len;cur++){
            if(nums[cur] == nums[cur-1] + 1){
                dp[cur] = dp[cur - 1] + 1;
                res = Math.max(res,dp[cur]);//有递增的就加1
            }else if(nums[cur] == nums[cur-1]){
                dp[cur] = dp[cur - 1];//相同不变
            }else{
                dp[cur] = 1;//否则重新计数
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        longestConsecutive solution = new longestConsecutive();
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }
}
