package LeetCodehot;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-20 11:14
 **/
public class fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i : nums1){
            for(int j : nums2){
                // 遍历前两个数组，统计两个数组元素之和，和出现的次数，放到map中
                map.put(i + j , map.getOrDefault(i + j , 0) + 1);
            }
        }

        for(int k : nums3){
            for(int l : nums4){
                //再遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就把map中key对应的value也就是出现次数统计出来。
                count += map.getOrDefault(- k - l, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        fourSumCount fourSumCount = new fourSumCount();
        System.out.println(fourSumCount.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
