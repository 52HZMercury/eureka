package meituan;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-18 10:09
 **/
public class catch1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hang = scanner.nextInt();
        int jhang = scanner.nextInt();
        int jlie = scanner.nextInt();
        int[][] en = new int[1000][1000];
        for(int i = 0;i<hang;i++){
            int enhang = scanner.nextInt();
            int enlie  = scanner.nextInt();
            en[enhang][enlie] = 1;
        }

        int curhang = 0;
        int curlie = 0;
        int count = 0;
        int max = 0;
        while(curhang < 1000-(jhang + 1) && curlie<1000-(jlie + 1)){
            max = Math.max(count,max);
            count = 0;
            for(int i = curhang;i <= jhang + 1;i++){
                for (int j = curlie;j <= jlie + 1;j++){
                    if(en[i][j] == 1){
                        count++;
                    }
                }
            }
            curhang++;
            curlie++;
        }
        System.out.println(max);
    }
}
