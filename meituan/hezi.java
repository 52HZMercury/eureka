package meituan;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-08-26 10:39
 **/
public class hezi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] balls = new int[n];
        int count = 0;
        int step = 0;
        for(int i = 0;i < m;i++){
            int t = sc.nextInt();
            int x = sc.nextInt();
            if(t == 1){

                if(balls[x-1] == 0){
                    count++;
                }
                balls[x-1]++;
            } else if (t == 2) {
                for(int j = 0;j < n;j++){
                    if(j != x- 1 && balls[j] == 0){
                        count ++;
                    }
                    if(j != x - 1){
                        balls[j]++;
                    }
                }
            }
            step++;
            if(count == n){
                System.out.println(step);
                return;
            }
        }
        System.out.println(-1);
    }
}
