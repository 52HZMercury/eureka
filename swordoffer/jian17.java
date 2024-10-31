package swordoffer;

import java.util.ArrayList;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-20 14:34
 **/
public class jian17 {
    public int[] printNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = 0;
        boolean flag = true;
        while(flag){
            list.add(num);
            if(pan(num) > n){
                flag = false;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++) res[i] = list.get(i);
        return res;
    }
    private static int pan(int num) {
        // TODO Auto-generated method stub
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
