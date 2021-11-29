package com.nowcoder.four;

import java.util.TreeMap;

/**
 * @author Yjm
 * @create 2019-09-14 14:44
 */
public class UseTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String>  treeMap = new TreeMap<>();
        treeMap.put(5 , "zuo");
        treeMap.put(10,"cheng");
        treeMap.put(25,"laowang");
        treeMap.put(15,"yun");
        treeMap.put(20,"yao");

        /*String s = treeMap.toString();
        System.out.println(s);*/

        //treeMap.forEach((k , v) -> System.out.println("k :"+k+" v :"+v ));
        System.out.println(treeMap.containsKey(5));
        System.out.println(treeMap.get(5));
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.ceilingKey(5));
        System.out.println(treeMap.floorKey(5));

    }
}
