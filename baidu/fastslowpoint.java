package baidu;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-08 19:14
 **/
public class fastslowpoint {
    public static void main(String[] args) {

        node root = creatlist();
        node root1 = creatcirlelist();

        node fast = root;
        node slow = root;

        node fast1 = root1;
        node slow1 = root1;

        System.out.println(iscirle(fast,slow));
        System.out.println(iscirle(fast1,slow1));


        if(iscirle(fast1,slow1)){
            fast = root1;
        }

        while(fast!= null&& slow !=null && fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(fast.data);


    }


    private static boolean iscirle(node fast, node slow){
        while(fast.next !=null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    private static node creatlist(){
        node root = new node(0);
        node temp = root;
        for(int i = 1;i < 5;i++){
            node newnode = new node(1);

            temp.next = newnode;
            temp = temp.next;
        }
        return root;
    }

    private static node creatcirlelist(){
        node root = new node(0);
        node temproot = root;
        node temp = root;
        for(int i = 1;i < 6;i++){
            node newnode = new node(1);
            temp.next = newnode;
            temp = temp.next;
        }
        temp.next = temproot;
        return root;
    }
}

class node{
    int data;
    node next;

    public node(int i) {
        this.data = i;
    }
}
