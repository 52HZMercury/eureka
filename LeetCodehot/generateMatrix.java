package LeetCodehot;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-09 17:30
 **/
public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0,startY = 0;
        int loop = 0;
        int offset = 1;
        int count = 1;
        int i,j;
        while(loop < n / 2){
            i = startY;
            j = startX;
            //顶部
            for(; j < n - offset; j++){
                nums[i][j] = count++;
            }
            //右边
            for(; i < n - offset; i++){
                nums[i][j]  = count++;
            }
            //底边
            for(;j > startX; j--){
                nums[i][j] = count++;
            }
            //左边
            for(;i > startY; i--){
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            loop++;
            offset++;
        }
        if(n % 2 == 1){
            nums[startY][startX] = count;
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateMatrix generateMatrix = new generateMatrix();
        int[][] nums = generateMatrix.generateMatrix(n);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
