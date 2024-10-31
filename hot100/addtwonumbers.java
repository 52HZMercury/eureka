package hot100;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2024-10-18 11:25
 **/

import java.util.ArrayList;
import java.util.Scanner;



public class addtwonumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // 进位标志

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10; // 计算是否需要进位
            current.next = new ListNode(sum % 10); // 新节点保存当前位的结果
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
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

    // 测试函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        String input1 = scanner.nextLine();
        String[] elements1 = input1.split("\\s+");
        for (String element : elements1) {
            list1.add(Integer.parseInt(element));
        }

        String input2 = scanner.nextLine();
        String[] elements2 = input2.split("\\s+");
        for (String element : elements2) {
            list2.add(Integer.parseInt(element));
        }

        scanner.close();

        ListNode l1 = buildList(list1, 0);
        ListNode l2 = buildList(list2, 0);
        ListNode result = addTwoNumbers(l1, l2);

        // 打印结果
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

