package hot100;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-01-09 19:55
 **/
public class minDistance {
    public static int minDistance(String word1, String word2) {
        //dp[i][j]表示word1前 i 个字母 转化到 word2 前 j 个需要的最少操作数
        int n1 = word1.length()+1;
        int n2 = word2.length()+1;
        int[][] dp = new int[n1][n2];
        //dp[i][0] 给第一列赋值,删除操作，从word1的字符删除到0个字符
        for(int i=0; i<n1; i++){
            dp[i][0] = i;
        }
        //dp[0][j] 给第一行赋值，增加操作，从0个字符增加到word2的字符
        for(int j=0; j<n2; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<n1; i++){
            for(int j=1; j<n2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; //no change
                }else{
                    dp[i][j] =Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1; //add del edit
                }
//                System.out.println(dp[i][j]);
            }
        }
        return dp[n1-1][n2-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        System.out.println(minDistance(word1,word2));
    }
}
