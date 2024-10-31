package JD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-09-02 11:08
 **/
public class quan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }
        int[][] bc = new int[m][2];
        for(int i = 0;i < m;i++){
            bc[i][0] = sc.nextInt();
            bc[i][1] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(a);
        Arrays.sort(bc,(o1, o2) -> o2[1] - o1[1]);
        int ans = 0;
        boolean[] used = new boolean[n];
        for(int i = n - 1;i >= 0;i--){
            boolean flag = false;
            for(int j = 0;j < m;j++){
                if (!used[j] && a[i] >= bc[j][0]){
                    ans += a[i] - bc[j][1];
                    used[j] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans += a[i];
            }
        }
        System.out.println(ans);
    }
}
