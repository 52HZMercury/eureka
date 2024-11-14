package hot100;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-11-14 11:21
 **/
public class mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for(ListNode list : lists){
            res = merge(list,res);
        }
        return res;
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return pre.next;
    }

    public static ListNode buildList(ArrayList<Integer> list, int index) {
        // 如果已经处理完所有的元素，则返回null
        if (index >= list.size()) {
            return null;
        }
        // 创建一个新的节点，并且递归地为下一个节点调用此方法
        ListNode node = new ListNode(list.get(index), buildList(list, index + 1));
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //几条链表
        int n = sc.nextInt();
        ListNode[] lists = new ListNode[n];
        for (int i = 0; i < n; i++){
            int m = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++){
                list.add(sc.nextInt());
            }
            ListNode head = buildList(list, 0);
            lists[i] = head;
        }
        mergeKLists mergeKLists = new mergeKLists();
        ListNode result = mergeKLists.mergeKLists(lists);
        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
