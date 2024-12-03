package hot100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-03 16:52
 **/
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums,target);//寻找左边界
        int r = binarySearch(nums,target + 1);//找到有边界右边一个
        //使用二分找两次

        if(l == nums.length || nums[l] != target){
            return new int[]{-1,-1};
        }
        return new int[]{l,r - 1};
    }

    //改进版 用于返回左边界
    public int binarySearch(int[] nums, int target){
        int l = 0,r = nums.length;
        while(l < r){//注意没有等号
            int mid = l + (r - l)/2;
            if(target <= nums[mid]){
                r = mid;
            }else{
                l = mid + 1;;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        searchRange searchRange = new searchRange();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] ints = searchRange.searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
