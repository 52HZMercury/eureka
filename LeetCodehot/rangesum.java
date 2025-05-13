package LeetCodehot;
import java.util.*;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-13 16:17
 **/
public class rangesum {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] nums = new int[n+1];
            nums[0] = 0;
            for(int i = 1;i <= n;i++){
                int num = sc.nextInt();
                nums[i] = nums[i - 1] + num;
            }
            while(sc.hasNextInt()){
                int start = sc.nextInt();
                int end = sc.nextInt();
                int res = nums[end+1] - nums[start];
                System.out.println(res);
            }
        }

}
