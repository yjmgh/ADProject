package LinkedList;

/**
 * @author Yjm
 * @create 2019-08-03 21:22
 */
//使用循环链表解决约瑟夫问题
//1 构建循环链表
//2 解决问题
    // 遍历-1.需要一个辅助指针 helper=first，循环，结束的条件是helper.next=first，结束/核心算法代码：
    // 1.n表示小孩数量，k从第几个小孩数m表示数几下n=5k=2m=2
    // 2.先定义一个辅助指针helper，让 helper定位到first的前面
    // 3.i让first和helper移动到第k个小孩移动（k-1），报数移动（m-1）次，first执行要删除的小孩helper指向要删除的小孩的前一个节点
    // 4.可以first=first.next helper.next=first，将小孩出圈
    // 5.重复3，4步，直到helper==first，圈中只有一个小孩
public class CircleLinkedList {
    public static void main(String[] args) {

        Josepfu josepfu = new Josepfu();
        josepfu.add(5);
        josepfu.list();

        josepfu.countBoy(5 , 2 , 2);

    }
}

class Josepfu{

    private Boy first = null;
    private Boy cur = null; //仅仅用于插入

    public void countBoy(int n , int k , int m){
        if(first == null || k > n|| m <1){
            return;
        }

        Boy heaper = cur;

        for(int i = 0 ;i < k-1 ;i++){
            first = first.next;
            heaper = heaper.next;
        }

        while(true){
            for(int i = 0 ;i < m-1 ;i++){
                first = first.next;
                heaper = heaper.next;
            }

            System.out.println(first + "移除\n");

            first = first.next;
            heaper.next=first;

            if(first == heaper){
                break;
            }
        }

        System.out.println(first+"最后一个小孩");
    }




    public void add(int nums){
        if(nums < 1){
          return;
        }

        for(int i = 1; i <= nums; i++){
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.next = first;
                cur=first;
            }else{
                boy.next = cur.next;
                cur.next = boy;
                cur = boy;
            }



        }

    }

    public boolean isEmply(){
        return first == null;
    }

    public void list(){
        if(isEmply()){
            return;
        }
        Boy heaper = first;
        while(true){
            System.out.println(heaper);
            if(heaper.next == first){
                break;
            }
            heaper = heaper.next;
        }

    }


}

class Boy{
    public int no;
    Boy next = null;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
