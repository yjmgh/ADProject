package com.nowcoder.four;

import java.util.*;

/**
 * @author Yjm
 * @create 2019-09-14 17:52
 */
//题目：画出建筑物的轮廓
/*
* 给定一个3列二维数组，每一行表示有一座大楼，一其有N座大楼。
* 所有大楼的底部都室落在X辅上，每一行的三个值：
（a.b.c）代表每座大楼的从（a.0）点开始，到b.0）点结束，高度为e。输入的数据可以保证a（b，且a，b，c均为正数。
大楼之间可以有重合。请输出整体的轮廓图。
例子：给定一个二维数组【【1,3,3】.【2,4,4】.【5 ,6 ,1】
输出为轮期线【【1,2,3】.【2,4,4】.【5,6,1】】
* */
/*解：
   (1 , 6 , 4) , (2 , 4 , 3) , (5 , 8 , 5) ,(7 , 10 , 3 )
   (1 , 4 , "上")
   (2 , 3 , "上")
   (4 , 3 , "下")
   (5 , 5 , "上")
   (6 , 4 , "下")
   (7 , 3 , "上")
   (8 , 5 , "下")
   (10 , 3 , "下")
   遇到上就添加，遇到下就删除，最大高度发生变化就会产生轮廓线 添加删除就是htMap干的事 (高度，次数)
   最大高度变化：先添加/删除节点，而后获得最大高度，跟之前的进行比较就可以了，发生变化输出轮廓图
   */

/*
以下代码主要分为三个部分：
1 htMap：对每一条竖线进行操作，上升则添加 ， 下降则删除 ，这么做是为了pmMap每一个点获得最大的高度
2 pmMap：坐标上的每一个点的最大高度
3 轮廓线：根据高度来画轮廓
*/
public class Building_OutLine {
    public static void main(String[] args) {

        int[][] arr = new int[][]{{1 , 6 , 4},{2 , 4 , 3},{5 , 8 , 5},{7 , 10 , 3}};
        List<List<Integer>> list = fun(arr);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> fun(int[][] arr){
        //if(arr == null || arr[0].length == 0) return;
        //先进行拆分
        XNode[] xnode = new XNode[arr.length *2];
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            xnode[i] = new XNode(true ,arr[i][0] , arr[i][2] );
            xnode[xnode.length - i -1] = new XNode(false , arr[i][1],arr[i][2]);
        }
        Arrays.sort(xnode, new Comparator<XNode>() {
            @Override
            public int compare(XNode o1, XNode o2) {
                if(o1.posi != o2.posi){
                    return o1.posi - o2.posi;
                }
                if(o1.isUp != o2.isUp){
                    return o1.isUp ? -1 : 1;//下降优先
                }
                /*if(o1.h != o2.h){
                    return o2.h - o1.h;
                }*/
                return 0;//位置相同,高度相同，则无所谓
            }
        });

        TreeMap<Integer,Integer> pmMap = new TreeMap<>();
        TreeMap<Integer,Integer> htMap = new TreeMap<>();

        for (int i = 0; i < xnode.length; i++) {
            if(xnode[i].isUp){ //上升则添加
                if(!htMap.containsKey(xnode[i].h)){
                    htMap.put(xnode[i].h,1);
                }else {
                    htMap.put(xnode[i].h,htMap.get(xnode[i].h) + 1);
                }
            }else {//下降则删除
                if (htMap.containsKey(xnode[i].h)) {
                    if (htMap.get(xnode[i].h) == 1) {
                        htMap.remove(xnode[i].h);
                    } else {
                        htMap.put(xnode[i].h, htMap.get(xnode[i].h) - 1);
                    }
                }
            }
            //将轮廓线放进pm里面
            if(htMap.isEmpty()){ //到最后或者中间有空隙的情况
                pmMap.put(xnode[i].posi , 0);
            }else {
                pmMap.put(xnode[i].posi,htMap.lastKey()); //记录了每一个点的最大值
            }

        }

        //输出
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;

        for(Map.Entry<Integer,Integer> entry : pmMap.entrySet()){
            int curPosi = entry.getKey();
            int curMaxHeight = entry.getValue();
            if(height != curMaxHeight){
                if(height != 0){
                    List<Integer> newRecord = new ArrayList<>();
                    newRecord.add(start);
                    newRecord.add(curPosi);
                    newRecord.add(height);
                    res.add(newRecord);
                }

                start = curPosi;
                height = curMaxHeight;
            }
        }

        return res;
    }

}
class XNode{
    public boolean isUp;
    public int posi;
    public int h;

    public XNode(boolean isUp, int posi, int h) {
        this.isUp = isUp;
        this.posi = posi;
        this.h = h;
    }
}
