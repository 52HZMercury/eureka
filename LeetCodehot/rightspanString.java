package LeetCodehot;
import java.util.*;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-06-24 13:21
 **/
public class rightspanString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        StringBuilder res = new StringBuilder();
        for(int i = s.length() - k;i < s.length();i++){
            char cur = s.charAt(i);
            res.append(cur);
        }
        for(int i = 0;i < s.length() - k;i++){
            char cur = s.charAt(i);
            res.append(cur);
        }
        System.out.println(res.toString());
    }
}
