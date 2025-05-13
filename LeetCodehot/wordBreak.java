package LeetCodehot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-04-15 16:54
 **/
public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> wordDict = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            wordDict.add(sc.nextLine());
        }
        wordBreak wordBreak = new wordBreak();
        System.out.println(wordBreak.wordBreak(s,wordDict));
    }
}
