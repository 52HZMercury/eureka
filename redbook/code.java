package redbook;

import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-26 16:33
 **/
public class code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String codeAfter = sc.next();
        StringBuffer codeBefore = new StringBuffer();
        for(int i = 0;i < codeAfter.length();i++){
            if(codeAfter.charAt(i) >= 'd'){
                char ch = (char) (codeAfter.charAt(i) - 3);
                //System.out.println(ch);
                codeBefore.append(ch);
            }else{
                char ch2 = (char) (codeAfter.charAt(i) - 3 + 26);
                codeBefore.append(ch2);
            }
        }
        System.out.println(codeBefore);
    }
}
