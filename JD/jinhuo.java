package JD;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-09-02 10:29
 **/
public class jinhuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int netMoney = sc.nextInt();
        int[] a_price = new int[n];
        int[] b_price = new int[n];
        for(int i = 0;i < n;i++){
            a_price[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            b_price[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0;i < n;i++){
            max += Math.min(a_price[i],b_price[i]);
        }
        if(max > netMoney) {
            System.out.println(netMoney);
        }else{
            System.out.println(max);
        }
    }
}
