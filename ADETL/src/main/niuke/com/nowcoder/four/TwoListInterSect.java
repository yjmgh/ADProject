package com.nowcoder.four;
import java.util.HashSet;

/**
 * @author Yjm
 * @create 2019-08-21 23:15
 */
//判断两个链表是否有环，是否相交，若相交就返回第一个的节点
public class TwoListInterSect {
    public static void main(String[] args) {

       /* // 1->2->3->4->5->6->7->null
        TNode head1 = new TNode(1);
        head1.next = new TNode(2);
        head1.next.next = new TNode(3);
        head1.next.next.next = new TNode(4);
        head1.next.next.next.next = new TNode(5);
        head1.next.next.next.next.next = new TNode(6);
        head1.next.next.next.next.next.next = new TNode(7);

        // 0->9->8->6->7->null
        TNode head2 = new TNode(0);
        head2.next = new TNode(9);
        head2.next.next = new TNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        TNode res = getIntersectNode(head1, head2);*/
        System.out.println("======================================================");
        // 1->2->3->4->5->6->7->4...
       TNode head1 = new TNode(1);
        head1.next = new TNode(2);
        head1.next.next = new TNode(3);
        head1.next.next.next = new TNode(4);
        head1.next.next.next.next = new TNode(5);
        head1.next.next.next.next.next = new TNode(6);
        head1.next.next.next.next.next.next = new TNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        TNode head2 = new TNode(0);
        head2.next = new TNode(9);
        head2.next.next = new TNode(8);
        head2.next.next.next = head1.next; // 8->2
        TNode res1 = getIntersectNode(head1, head2);

       /* // 0->9->8->6->4->5->6..
        TNode head2 = new TNode(0);
        head2.next = new TNode(9);
        head2.next.next = new TNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6*/
        //TNode res1 = getIntersectNode(head1, head2);
        //System.out.println(getIntersectNode(head1, head2).value);

        if(res1 != null){
            System.out.println(res1.value);
        }else {
            System.out.println("不相交");
        }


    }

    public static TNode getIntersectNode(TNode head1 , TNode head2){
        if(head1 == null && head2 == null) return null;

        TNode loop1 = getLoopNode1(head1);
        TNode loop2 = getLoopNode1(head2);

        //都是无环的
        if(loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }

        //都是有环的，三种情况
        if(loop1 != null && loop2 != null){
            TNode res = bothLoop(head1 , head2 , loop1 , loop2);
            return res;
        }

        //一个有环，一个无环，肯定不想交
        return null;

    }

    public static TNode getLoopNode(TNode head){
        HashSet<TNode> set = new HashSet<>();
        TNode cur = head;
        while(cur != null){
            if(set.contains(cur)) return cur;
            set.add(cur);
            cur = cur.next;
        }

        return  null;

    }


    public static TNode getLoopNode1(TNode head){
        if(head==null||head.next==null||head.next.next==null) return null;
        TNode slow = head.next;
        TNode fast = head.next.next;

        while (slow != fast){

            if(fast.next == null || fast.next.next == null){
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while ((fast != slow)){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }


    public static TNode noLoop(TNode head1 , TNode head2){
        if(head1 == null || head2 == null){
            return  null;
        }

        TNode cur1 = head1;
        TNode cur2 = head2;
        int n = 0;
        int m = 0;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            m++;
            cur2 = cur2.next;
        }

        if(cur1 != cur2) return null;

        cur1 = (n >= m) ? head1 :head2;
        cur2 = (n >= m) ? head2 :head1;
        n = Math.abs(n - m);

        while (n != 0){
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public static TNode bothLoop(TNode head1 , TNode head2 , TNode loop1 , TNode loop2){
        //三种情况
        //1 两条链表相交，环在底部
        if(loop1 == loop2){

            TNode cur1 = head1;
            TNode cur2 = head2;
            int n = 0;
            int m = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                m++;
                cur2 = cur2.next;
            }

            if(cur1 != cur2) return null;

            cur1 = (n >= m) ? head1 :head2;
            cur2 = (n >= m) ? head2 :head1;
            n = Math.abs(n - m);

            while (n != 0){
                cur1 = cur1.next;
                n--;
            }

            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            // 2 判断是否相交，相交就是有两个相交的点，不相交就是不相交
            TNode cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;

        }

    }
}



class TNode{
    int value;
    TNode next;

    public TNode(int value) {
        this.value = value;
    }
}