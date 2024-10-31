package meituan;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-08-26 11:17
 **/
public class meinoGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = slove(arr,k);
        System.out.println(ans);
    }

    public static int slove(int[] arr,int k){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i = arr.length - 1; i >= 0; i--){
                if(count == k){
                    return sum;
                }
                int x = arr[i] * arr[i - 1];
                int y = 1;
                sum += x + y - arr[i] - arr[i - 1];
                arr[i - 1] = x;
                arr[i] = y;
                count++;
        }
        return sum;
    }

}
//5 2
//1 2 3 4 5
//1 2 12 1 5
//1 2 60 1 1
//65

//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0;i < n;i++){
//            arr[i] = sc.nextInt();
//        }
//        int ans = slove(arr,k);
//        System.out.println(ans);
//    }
//
//    public static int slove(int[] arr,int k){
//        int sum = 0;
//        for(int num : arr){
//            sum += num;
//        }
//        int count = 0;
//        for(int i = 0; i < arr.length - 1; i++){
//            for(int j = i + 1; j < arr.length; j++){
//                if(count == k){
//                    return sum;
//                }
//
//                if(isPerfectSquare(arr[i] * arr[j])){
//                    int x = (int)Math.sqrt(arr[i]);
//                    int y = (int)Math.sqrt(arr[j]);
//                    if(x + y > arr[i] + arr[j]){
//                        sum += x + y - arr[i] -arr[j];
//                        arr[i] = x;
//                        arr[j] = y;
//                        count++;
//                    }
//                }
//            }
//        }
//        return sum+50;
//    }
//    public  static boolean isPerfectSquare(int num){
//        if(num < 0){
//            return false;
//        }
//        int root = (int)Math.sqrt(num);
//        return root * root == num;
//    }
//}