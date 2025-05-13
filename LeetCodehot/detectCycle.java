package LeetCodehot;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-04-16 13:49
 **/
public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                flag = true;
                break;
            }
        }
        if(!flag){
            return null;
        }
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
