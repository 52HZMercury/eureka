package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-18 10:45
 **/
public class caidai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = scanner.nextInt();
        }
        System.out.println(caidai(a,k));

    }
    private static int caidai(int[] a,int k){
        Map<Integer,Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0;
        while(right < a.length){
            int c = a[right];
            right++;
            window.put(c,window.getOrDefault(c,0)+1);

            while(window.keySet().size() > k){
                int d = a[left];
                left++;
                window.put(d,window.get(d) - 1);
                if(window.get(d) == 0){
                    window.remove(d);
                }
            }
            res = Math.max(res,right - left);
        }
        return res;
    }
}
