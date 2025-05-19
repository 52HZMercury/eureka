package LeetCodehot;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-19 13:41
 **/
public class isHappy {
    public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            //如果是不为1且还没开始重复
            while(n != 1 && !set.contains(n)){
                set.add(n);
                n = getNextNumber(n);
            }
            //跳出循环，判断是哪个条件跳出了循环
            return n == 1;
    }

    //有点类似于回文数
    public int getNextNumber(int n){
        int sum = 0;
        while(n > 0){
            int temp = n % 10;
            sum += Math.pow(temp,2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new isHappy().isHappy(19));
        System.out.println(3 / 10);
    }
}


