package LeetCodehot;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-31 19:36
 **/
public class isValid {
    public boolean isValid(String s) {
        if(s == null){
            return false;
        }
        char[] arr = s.toCharArray();//转变为数组
        Stack<Character> Stack = new Stack<Character>();
        for(char ch:arr){
            if(ch == '(' ||ch == '[' || ch == '{' ){
                Stack.push(ch);//遇到左括号直接入栈
            }else if(!Stack.isEmpty()){//栈不为空，遇到右括号，出栈对比
                char chpop = Stack.pop();
                if(chpop == '(' && ch!=')'){
                    return false;
                }
                if(chpop == '[' && ch!=']'){
                    return false;
                }
                if(chpop == '{' && ch!='}'){
                    return false;
                }
            }else if(Stack.isEmpty()){//栈为空 遇到右括号，不符合，直接返回
                return false;
            }

        }
        return Stack.isEmpty();//判断是否有落单的左括号
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        isValid isValid = new isValid();
        boolean valid = isValid.isValid(s);
        System.out.println(valid);
    }
}
