package JD;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-09-02 10:46
 **/
public class qujian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        int l3 = sc.nextInt();
        int r3 = sc.nextInt();
        sc.close();
        int ans = slove(l1,r1,l2,r2,l3,r3);
        System.out.println(ans);
    }

    public static int slove(int l1,int r1,int l2,int r2,int l3,int r3){
        int max = -1;
        int[][] intervals = {{l1,r1},{l2,r2},{l3,r3}};
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                if(j != i){
                    int left = Math.max(intervals[i][0],intervals[j][0]);
                    int right = Math.min(intervals[i][1],intervals[j][1]);
                    if(left <= right){
                        int sum = right + right;
                        max = Math.max(max,sum);
                    }
                }
            }
        }

        return max;
    }
}
