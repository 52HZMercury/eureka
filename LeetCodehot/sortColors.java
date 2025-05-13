package LeetCodehot;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-01-07 16:33
 **/
public class sortColors {
    //也可以直接使用排序算法
    public static void sortColors(int[] nums) {
        int p0 = 0,p2 = nums.length-1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i]==0){
                //和头部交换
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
        for(int i = nums.length - 1;i >= 0;i--){
            if(nums[i]==2){
                //和尾部交换
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
