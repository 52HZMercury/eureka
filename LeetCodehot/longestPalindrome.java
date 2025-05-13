package LeetCodehot;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-18 11:14
 **/
public class longestPalindrome {
    public static String longestPalindrome(String s) {
        // 特例判断
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        String res = "";

        // 中心拓展
        for (int center = 0; center < 2 * len - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                // 保存最长的子串  substring是左闭右开[
                String substring = s.substring(left, right + 1);
                res = res.length() > substring.length() ? res : substring;
                left--;
                right++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串: ");
        String input = scanner.nextLine();
        System.out.println("最长回文字串为：" + longestPalindrome(input));
        // 解释："bab" 或者 "aba" 都是符合题意的答案。
    }
}
