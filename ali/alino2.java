package ali;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-04-12 16:54
 **/
import java.util.Scanner;

public class alino2 {
    public static void main(String[] args) {
        int[] b = new int[32];
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            add(x, b);
        }

        double mid = n / 2.0;
        //找到1和0中位数比较少的那一位，相加起来
        for (int i = 30; i >= 0; i--) {
            if (b[i] > mid) {
                sum += n - b[i];
            } else {
                sum += b[i];
            }
        }

        System.out.println(sum);
    }

    public static void add(int x, int[] b) {
        //计算数组中用二进制表示的数字在各位上的分布情况
        for (int i = 30; i >= 0; i--) {
            int j = x >> i & 1;//右移i位然后再与1 取出二进制位
            if (j == 1) {
                b[i]++;
            }
        }
    }
}

//in  4    9 9 9 9
//out 0

//in  4    9 9 9 8
//out 1
