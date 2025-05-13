package LeetCodehot;

import java.util.*;


/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-24 12:36
 **/
public class LetterCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入字符串
        String digits = scanner.nextLine();

        List<String> combinations = new LetterCombinations().letterCombinations(digits);

        System.out.println("Letter combinations:");
        for (String combination : combinations) {
            System.out.print(combination + " ");
        }

        scanner.close();
    }

    public  List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        Deque<Character> path = new ArrayDeque<>();
        dfs(path, map, digits, 0, res);
        return res;
    }

    private  void  dfs(Deque<Character> path, Map<Character, String> map, String digits, int dept, List<String> res) {
        if (dept == digits.length()) {
            res.add(path.toString().replaceAll("[\\[\\], ]", ""));
            return;
        }

        char digit = digits.charAt(dept);
        String letters = map.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            path.add(letters.charAt(i));
            dfs(path, map, digits, dept + 1, res);
            path.removeLast();
        }
    }
}
