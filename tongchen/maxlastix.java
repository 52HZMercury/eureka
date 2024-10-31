package tongchen;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-09-21 19:16
 **/
public class maxlastix {
    public static void main(String[] args) {
        String[] strs = {"flower","tower"};
        System.out.println(fun(strs));
    }

    public  static String fun(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String commonsunffix = new StringBuilder(strs[0]).reverse().toString();;
        for(int i  = 1;i < strs.length; i++){
            if(strs[i] == null){
                return "";
            }
            String reversed = new StringBuilder(strs[i]).reverse().toString();
            while(!reversed.startsWith(commonsunffix)){
                commonsunffix = commonsunffix.substring(0,commonsunffix.length()-1);
                System.out.println(commonsunffix);
                if(commonsunffix.isEmpty()){
                    return "";
                }
            }
        }
        return new StringBuilder(commonsunffix).reverse().toString();
    }
}
