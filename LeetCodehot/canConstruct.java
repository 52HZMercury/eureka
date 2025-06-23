package LeetCodehot;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-05-21 13:48
 **/
public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(char d : ransomNote.toCharArray()){
            map.put(d,map.getOrDefault(d,0) - 1);
        }
        for(char e : map.keySet()){
            if(map.get(e) < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        canConstruct c = new canConstruct();
        System.out.println(c.canConstruct("aa","ab"));
    }
}
