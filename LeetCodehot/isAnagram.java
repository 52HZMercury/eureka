package LeetCodehot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-15 14:18
 **/
public class isAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int j = 0;j < t.length();j++){
            map.put(t.charAt(j),map.getOrDefault(t.charAt(j),0) - 1);
        }
        for(Character key : map.keySet()){
            if(map.get(key) != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(new isAnagram().isAnagram(s,t));
    }
}
