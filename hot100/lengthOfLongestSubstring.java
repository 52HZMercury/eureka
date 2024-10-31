package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-17 14:11
 **/
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;

        while(right < s.length()){
            //扩大右边窗口
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0) + 1);

            //有重复了 缩小左边窗口
            while(window.get(c) > 1){
                char d = s.charAt(left);
                left++;
                window.put(d,window.get(d) - 1);
            }
            res = Math.max(res,right -left);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(s + " : " + lengthOfLongestSubstring(s));
    }
}
