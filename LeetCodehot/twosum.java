package LeetCodehot;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-08 15:52
 **/
public class twosum {
//    输入：nums = [2,7,11,15], target = 9
//    输出：[0,1]
//    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //输入部分
        Scanner scanner = new Scanner(System.in);
        // 读取数组长度
        int length = scanner.nextInt();

        // 读取数组元素
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        // 读取目标值
        int target = scanner.nextInt();

        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

}
