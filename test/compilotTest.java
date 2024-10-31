package test;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-04-25 15:49
 **/
public class compilotTest {
    // q:打印从斐波拉契数列
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.print(a + " " + b + " ");
        for(int i = 0; i < 10; i++){
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
