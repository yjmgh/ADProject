package com.nowcoder.five;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yjm
 * @create 2019-09-04 22:47
 */
//并查集
//主要是两个功能：1 看是否在一个集合里面   2 不是的话就合并两个集合
public class UnionFind {
    public static void main(String[] args) {
        List<UFNode>  list = new LinkedList<>();
        UFNode ufNode1 = new UFNode(3);
        UFNode ufNode2 = new UFNode(3);
        UFNode ufNode3 = new UFNode(3);
        UFNode ufNode4 = new UFNode(3);
        UFNode ufNode5 = new UFNode(3);

        list.add(ufNode1);
        list.add(ufNode2);
        list.add(ufNode3);
        list.add(ufNode4);
        list.add(ufNode5);


        UnionF unionF = new UnionF();
        unionF.makeSets(list);
        sameU(unionF,ufNode1,ufNode2);
        sameU(unionF,ufNode1,ufNode2);

    }

    public static void sameU(UnionF unionF,UFNode ufNode1,UFNode ufNode2){
        boolean sameSet = unionF.isSameSet(ufNode1, ufNode2);
        if(!sameSet){
            unionF.union(ufNode1,ufNode2);
            System.out.println("不是一个集合");
        }else {
            System.out.println("是一个集合");
        }

    }
}

class UFNode{
    int a;

    public UFNode(int a) {
        this.a = a;
    }
}

class UnionF{
    //并查集，玩的是集合，如果直接在UFNode里面定义了的话，那还叫什么集合
    public HashMap<UFNode,UFNode> fatherMap;
    public HashMap<UFNode,Integer> sizeMap;

    public UnionF() {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
    }

    public void makeSets(List<UFNode> nodes){
        fatherMap.clear();
        sizeMap.clear();
        for (UFNode node : nodes) {
            fatherMap.put(node,node);
            sizeMap.put(node,1);
        }
    }

    public UFNode findHead(UFNode node){
        UFNode father = fatherMap.get(node);
        if(father != node){
            father = findHead(father);
        }

        fatherMap.put(node , father);
        return father;
    }

    public boolean isSameSet(UFNode a,UFNode b){
        return findHead(a) == findHead(b);
    }

    public void union(UFNode a,UFNode b){
        if(a == null || b == null) return;

        UFNode aHead = findHead(a);
        UFNode bHead = findHead(b);

        if(aHead != bHead){
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);

            if(aSetSize <= bSetSize){
                fatherMap.put(aHead,bHead);
                sizeMap.put(bHead , aSetSize + bSetSize);
            }else {
                fatherMap.put(bHead , aHead);
                sizeMap.put(aHead , aSetSize + bSetSize);
            }


        }

    }
}

