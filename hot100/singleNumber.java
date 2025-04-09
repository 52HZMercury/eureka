package hot100;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-04-09 15:58
 **/
public class singleNumber {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1;i < nums.length;i++){
            ans = ans^nums[i];
        }
        return ans;
    }
}
