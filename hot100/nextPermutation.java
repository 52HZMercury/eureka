package hot100;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-11-26 15:55
 **/
public class nextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 1, j = i, k = n - 1;
        while(i > 0 && nums[i] <= nums[i - 1]){
            i--;
        }
        if(i > 0){
            while(j > i && nums[j] <= nums[i - 1]){
                j--;
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
        }
        while(i < k){
            int temp = nums[i];
            nums[i++] = nums[k];
            nums[k--] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        nextPermutation(nums);
        for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
