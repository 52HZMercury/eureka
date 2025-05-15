package LeetCodehot;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-15 15:28
 **/
public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resset = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        for(int num: nums2){
            if(set.contains(num)){
                resset.add(num);
            }
        }

        //方法1：重新来个新数组存储
        int[] resarr = new int[resset.size()];
        int j = 0;
        for(int num : resset){
            resarr[j++] = num;
        }
        return resarr;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        intersection intersection = new intersection();
        int[] res = intersection.intersection(nums1, nums2);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
