package LeetCodehot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-21 16:00
 **/
public class threeSum {
    //不可重复 set?
    //三个数互不相等 但是相加等于0
    //双指针？
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();//最终返回的结果
        //特判
        if(nums.length<3){
            return lists;
        }

        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            //特判
            if(nums[i]>0) return lists;
            //去重
            if(i > 0 && nums[i] == nums[i-1]) continue;

            //双指针
            int left = i + 1,right = nums.length - 1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if( sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);//记住这里add的是数字不是下标，淦
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    //去重
                    while(left<right && nums[left] == nums[left+1])  left++;
                    while(left<right && nums[right] == nums[right-1])  right--;
                    left++;
                    right--;
                }else if(sum<0){
                    //和小于零移动左指针，因为右边值更大
                    left++;
                }else{
                    //和大于零移动右指针，因为左边边值更小
                    right--;
                }

            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> result = threeSum(nums);
        //直接打印集合
        System.out.println("结果: " + result);
    }
}
