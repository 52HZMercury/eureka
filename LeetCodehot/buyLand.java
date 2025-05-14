package LeetCodehot;
import java.util.*;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-14 17:46
 **/
public class buyLand {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] value = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                value[i][j] = sc.nextInt();
            }
        }
        //统计每行
        int[] horizon = new int[n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                horizon[i] += value[i][j];
            }
            if(i != 0) horizon[i] = horizon[i] + horizon[i - 1];
        }

        //统计每列
        int[] vertical = new int[m];
        for(int j = 0;j < m;j++){
            for(int i = 0;i < n;i++){
                vertical[j] += value[i][j];
            }
            if(j != 0) vertical[j] = vertical[j] + vertical[j - 1];
        }

        //按行切
        int horizonMin = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            int horizenA = horizon[i];
            int horizenB = horizon[n - 1] - horizon[i];
            horizonMin = Math.min(horizonMin,Math.abs(horizenA - horizenB));
        }

        //按列切
        int verticalMin = Integer.MAX_VALUE;
        for(int j = 0;j < m;j++){
            int verticalA = vertical[j];
            int verticalB = vertical[m - 1] - vertical[j];
            verticalMin = Math.min(verticalMin,Math.abs(verticalA - verticalB));
        }
        System.out.println(Math.min(horizonMin,verticalMin));
    }
}
