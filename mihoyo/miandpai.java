package mihoyo;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-08-27 20:32
 **/


public class miandpai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        String result = calculateProbability(arr);
        System.out.println(result);
    }

    public static String calculateProbability(int[] arr){
        boolean[] canStart = new boolean[arr.length];
        boolean[] canEnd = new boolean[arr.length];
        for (int i = 0;i < arr.length;i++){
            canStart[i] = true;
            canEnd[i] = true;
            for(int j = i - 1;j >= 0;j--){
                if(arr[j] < arr[i]){
                    canStart[i] = false;
                    break;
                }
            }
            for(int j = i + 1;j < arr.length;j++){
                if(arr[j] > arr[i]){
                    canEnd[i] = false;
                    break;
                }
            }
        }
        int win = 0;
        int lose =  0;
        int draw = 0;
        for(int i = 0;i < arr.length; i++){
            if(canStart[i] && canEnd[i]){
                win++;
            }else if(!canStart[i] && !canEnd[i]){
                lose++;
            }else if(canEnd[i]){
                draw++;
            }
        }

        String result;
        if(win == 0){
            result = "0/1";
        }else if(draw == 0){
            result = "1/1";
        }
        else{
            //System.out.println("...");
            int gcd = gcd(win,win + draw);
            result = (win / gcd) + "/" + ((win + draw) / gcd);
        }
        return result;
    }

    public static int gcd(int a,int b){
        while (b!= 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
