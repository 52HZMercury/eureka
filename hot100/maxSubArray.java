package hot100;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-10 15:51
 **/
public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for(int i = 1;i<nums.length;i++){
            if(dp[i-1]>0){//注意一下这里是dp[i-1]
                dp[i] = dp[i-1]+nums[i];
                max = Math.max(dp[i],max);//在dp过程中就在找最大的值
            }else{
                dp[i] = nums[i];
                max = Math.max(dp[i],max);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        //-2 1 -3 4 -1 2 1 -5 4
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(maxSubArray(nums));
    }
}
