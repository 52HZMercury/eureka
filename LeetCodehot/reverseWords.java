package LeetCodehot;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-06-23 15:18
 **/
public class reverseWords {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            res.append(str[i]);
            if (i != 0) res.append(" ");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = " the sky is blue ";
        reverseWords rw = new reverseWords();
        System.out.println(rw.reverseWords(s));
    }
}
