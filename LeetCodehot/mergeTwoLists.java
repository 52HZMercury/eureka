package LeetCodehot;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-11-07 13:59
 **/
public class mergeTwoLists {
    public static ListNode buildList(ArrayList<Integer> list, int index) {
        // 如果已经处理完所有的元素，则返回null
        if (index >= list.size()) {
            return null;
        }
        // 创建一个新的节点，并且递归地为下一个节点调用此方法
        ListNode node = new ListNode(list.get(index), buildList(list, index + 1));
        return node;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur= cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//链表节点个数
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            list1.add(scanner.nextInt());
        }
        ListNode l1 = buildList(list1,0);

        int m = scanner.nextInt();//链表节点个数
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            list2.add(scanner.nextInt());
        }
        ListNode l2 = buildList(list2,0);

        ListNode result = mergeTwoLists(l1,l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
