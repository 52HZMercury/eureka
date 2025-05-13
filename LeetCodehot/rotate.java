package LeetCodehot;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-06 14:05
 **/
public class rotate {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for(int i = 0;i < n/2;i++){
            //奇偶有所不同
            for(int j = 0;j < (n+1)/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        rotate r = new rotate();
        r.rotate(matrix);
        System.out.print("[");
        for(int i = 0;i < n;i++){
            System.out.print(Arrays.toString(matrix[i]) + " ");
        }
        System.out.print("]");
    }
}
