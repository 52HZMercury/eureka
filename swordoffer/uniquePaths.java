package swordoffer;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-02-25 10:47
 **/
public class uniquePaths {
    public static void main(String[] args) {
        System.out.println(factorial(18));
        System.out.println(uniquePaths(10,10));
    }
    public static int uniquePaths(int m, int n) {
        return  factorial(m + n - 2) / factorial(m - 1) / factorial(n - 1);
    }

    private static int factorial(int number){
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
