package LinkedList;

/**
 * @author Yjm
 * @create 2019-08-03 19:49
 */
public class List {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node1 node = new Node1(1 , "zhangsan");
        Node1 node1 = new Node1(2 , "lisi");

        linkedList.add(node);
        linkedList.add(node1);

        linkedList.list();

        linkedList.update(new Node1(1,"lisi"));
        linkedList.list();
    }
}

class LinkedList{

    private Node1 head = new Node1(0,"");

    public Node1 getHead(){
        return head;
    }

    public void update(Node1 node){
        if(head.next == null){
            return;
        }

        Node1 temp = head.next;
        while(true){

            if(temp == null){
                break;
            }

            if(temp.no == node.no){
                temp.name = node.name;
                break;
            }

            temp = temp.next;
        }
    }

    public void del(Node1 node){
        Node1 temp = head;

        while(true){

            if(temp.next == null){
                break;
            }

            if(temp.next.no == node.no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }


    }

    public void add(Node1 node){
        if(node == null){
            return;
        }
        Node1 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }

            temp = temp.next;

        }
        temp.next = node;

    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        Node1 temp = head.next;

        while(true){
            if(temp == null){
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }


    }

}

class Node1{
    public int no;
    public String name;
    public Node1 next;

    public Node1(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Node1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}