package LeetCodehot;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-12 15:00
 **/
public class canJump {
    public static boolean canJump(int[] nums) {
        int cover = 0;
        for(int i = 0;i <= cover;i++){
            cover = Math.max(i+nums[i],cover);
            if(cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(canJump.canJump(nums));
    }
}
