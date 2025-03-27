package hot100;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-03-27 13:42
 **/
public class maxProfit {
    public int maxProfit(int[] prices) {
        //维护一个最小的
        int minprices = prices[0];
        int maxProfit = 0;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < minprices){
                minprices = prices[i];
            }
            maxProfit = Math.max(maxProfit,prices[i] - minprices);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0;i < n;i++){
            prices[i] = sc.nextInt();
        }
        maxProfit maxProfit = new maxProfit();
        System.out.println(maxProfit.maxProfit(prices));
    }
}
