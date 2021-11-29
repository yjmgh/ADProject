package com.nowcoder.five;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yjm
 * @create 2019-09-15 19:57
 */
//题目：多叉树：公司举办年会，已知当前节点的直接父节点来的话，当前节点不来，统计最大的活跃度
public class MaxHappy {
    public static void main(String[] args) {

    }

    public static int getHuoNumber(HuoNode head){
        if(head == null) return 0;
        ResultData resultData = fun(head);
        return Math.max(resultData.lai_huo , resultData.bu_lai_huo);
    }

    public static ResultData fun(HuoNode head){

        //1 当前节点去
        //2 当前节点不去
        int lai_huo = head.huo;
        int bu_lai_huo = 0;
        for (int i = 0; i < head.nexts.size(); i++) {
            HuoNode next = head.nexts.get(i);
            ResultData nextData = fun(next);
            lai_huo += nextData.bu_lai_huo;
            bu_lai_huo += Math.max(nextData.lai_huo,nextData.bu_lai_huo);
        }

        return new ResultData(lai_huo , bu_lai_huo);
    }

}

class HuoNode{
    int huo;
    List<HuoNode> nexts;

    public HuoNode(int huo) {
        this.huo = huo;
        this.nexts = new ArrayList<>();
    }
}

class ResultData{
    int lai_huo;
    int bu_lai_huo;

    public ResultData(int lai_huo, int bu_lai_huo) {
        this.lai_huo = lai_huo;
        this.bu_lai_huo = bu_lai_huo;
    }
}