package ali;

import java.util.Arrays;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-04-24 19:33
 **/

//用1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列，如：512234、412345等，要求："4"不能在第三位，"3"与"5"不能相连。


public class demo3 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5};
        Arrays.sort(nums);
        int count = 0;
        boolean[] used = new boolean[nums.length];
        StringBuilder path  = new StringBuilder();
        dfs(nums,used,path);
    }
    private static void dfs(int[] nums, boolean[] used, StringBuilder path){
        if(path.length() == nums.length){
            if(path.charAt(2) != '4' && !path.toString().contains("35") && !path.toString().contains("53")){
                System.out.println(path);
            }
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            path.append(nums[i]);
            dfs(nums,used,path);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }


}
