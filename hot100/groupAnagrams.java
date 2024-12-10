package hot100;

import java.util.*;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-12-09 16:28
 **/
public class groupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] array =  str.toCharArray();
            Arrays.sort(array);//没有返回值
            String key = Arrays.toString(array);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        //eat tea tan ate nat bat
        //[["bat"],["nat","tan"],["ate","eat","tea"]]
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一组字符串，用空格分隔:");
        String input = scanner.nextLine();
        String[] strs = input.split(" ");

        System.out.println(groupAnagrams.groupAnagrams(strs));
        scanner.close();
    }
}
