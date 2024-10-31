package swordoffer;

import java.util.Stack;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-07 13:47
 **/
public class offer6 {
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0;i < stack.size(); i++){
            res[i] = stack.pop();
        }
        return res;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
