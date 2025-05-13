package LeetCodehot;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-26 13:31
 **/


public class removeNthFromEnd {
    public static ListNode buildList(ArrayList<Integer> list, int index) {
        // 如果已经处理完所有的元素，则返回null
        if (index >= list.size()) {
            return null;
        }
        // 创建一个新的节点，并且递归地为下一个节点调用此方法
        ListNode node = new ListNode(list.get(index), buildList(list, index + 1));
        return node;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length  = getlength(head);

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = pre;
        //寻找倒数第几个进行删除，需要找到前一个进行操作
        for(int i = 0;i < length - n;i++){
            cur = cur.next;
        }
        //进行删除
        cur.next = cur.next.next;
        return pre.next;
    }

    public static int getlength(ListNode head){
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            list.add(scanner.nextInt());
        }
        ListNode listNode = buildList(list,0);

        //删除倒数第几个
        int target = scanner.nextInt();
        listNode = removeNthFromEnd(listNode,target);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
