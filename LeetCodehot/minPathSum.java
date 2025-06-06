package LeetCodehot;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-17 15:35
 **/
public class minPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] dp =  new int[m][n];
        //初始化第一行
        dp[0][0] = grid[0][0];
        for(int j = 1;j < n;j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
        //初始化第一列
        for(int i = 1;i < m;i++) dp[i][0] = dp[i - 1][0] + grid[i][0];

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j],dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathSum(grid));
    }
}
