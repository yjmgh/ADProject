package com.offer.jianzhi.one;

/**
 * @author Yjm
 * @create 2019-09-22 16:38
 */
public class desuai {
    public static void main(String[] args) {
        DNode head2 = new DNode(8);
        head2.next = new DNode(6);
        head2.next.next = new DNode(5);

        DNode head1 = new DNode(1);
        head1.next = new DNode(7);
        head1.next.next = new DNode(9);

        DNode h = fun(head1 ,head2);
        while (h != null){
            System.out.println(h.value);
            h = h.next;
        }
    }

    public static DNode fun(DNode head1 , DNode head2){
        if(head1 == null && head2 == null) return null;

        if(head1 == null ) {
            return fun2(head2);
        }else if(head2 == null){
            return head1;
        }
        DNode h2=fun2(head2) ;
        DNode head;
        DNode cur;
        if(head1.value < h2.value){
            head = head1;
            head1 = head1.next;
        }else {
            head = h2;
            h2 = h2.next;
        }
        cur=head;
        while (head1 != null && h2 != null){
            if(head1.value < h2.value){
                cur.next = head1;
                head1 = head1.next;
            }else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }

        while (head1 != null){
            cur.next =head1;
            cur = cur.next;
            head1 = head1.next;
        }

        while (h2 != null){
            cur.next =h2;
            cur = cur.next;
            h2 = h2.next;
        }

        return head;
    }

    public static DNode fun2(DNode head2){

        DNode next = head2.next;
        if(next == null) return head2;
        head2.next =null;
        DNode cur ;
        while (next != null){
            cur = next.next;
            next.next = head2;
            head2 = next;
            next = cur;
        }

        return head2;
    }

}


class DNode{

    int value;
    DNode next ;

    public DNode(int value) {
        this.value = value;
        this.next = null;
    }
}