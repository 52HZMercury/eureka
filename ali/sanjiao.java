package ali;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-04-24 19:30
 **/
public class sanjiao{
        public static void main(String[] args){
            Scanner sc =  new Scanner(System.in);
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < arr.length; i++){
                for(int j = 0;j <= i; j++){
                    if(j == 0 || j == i){
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i - 1][j -1] + arr[i - 1][j];
                    }
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

