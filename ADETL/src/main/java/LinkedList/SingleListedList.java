package LinkedList;
import java.util.Stack;
/**
 * @author Yjm
 * @create 2019-08-03 11:26
 */
public class SingleListedList {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node node = new Node(1 , "zhangsan");
        Node node1 = new Node(2 , "lisi");

        sll.add(node);
        sll.add(node1);

        /* sll.list();

        sll.update(1,"wangwu");

        sll.list();

        reversePrint(sll.getHead());*/

       reverseList(sll.getHead());
       sll.list();

    }
//链表反转输出
    public static  void reversePrint(Node head){
        if(head.next == null){
            return;
        }

        Node temp = head.next;
        Stack<Node> stack = new Stack<>();
        while(true){
            if(temp==null){
                break;
            }

            stack.push(temp);

            temp = temp.next;
        }

        while(!stack.empty()){

            Node node = stack.pop();
            System.out.println(node);
        }



    }

    //反转链表思想很简单
    //原先链表从左向右走,每走一个就把元素放在新的链表前面
    public static void reverseList(Node head){
        if(head.next == null || head.next.next == null){
            return;
        }
        Node cur = head.next;
        Node next = null;
        Node reverseHead = new Node(0,"");
        while(true){

            if(cur == null){
                break;
            }
            next = cur.next;
            cur.next =reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;

    }
}


class SingleLinkedList{

    //初始化头结点
    private Node head = new Node(0 ,"");

    public Node getHead(){
        return head;
    }

    public void add(Node node){
        Node temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = node;

    }

    public void update(int no ,String name){

        if(head.next == null){
            return;
        }

        Node temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                temp.name = name;
                break;
            }

            temp = temp.next;
        }

    }

    public void del(int no){

        Node temp = head;
        while(true){

            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;

        }

    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while(true){
            if(temp== null){
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }

    }




}

class Node{
    public int no ;
    public String name;
    public Node next ;

    public Node(int no , String name ){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString(){

        return "Node: no = " + no +", name = " + name;
    }
}