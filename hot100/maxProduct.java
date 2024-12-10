package hot100;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-10 16:47
 **/
public class maxProduct {
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i] * max;
            int b = nums[i] * min;
            //max和min也同时起了dp[i - 1]功能
            max = Math.max(Math.max(a, b), nums[i]);
            min = Math.min(Math.min(a, b), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxProduct(nums));
    }
}
