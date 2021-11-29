package com.medium;

import java.util.HashMap;

/**
 * @author yuanjiameng
 * @create 2021-10-13 23:13
 * @describe
 */
public class Solution_213 {
    HashMap<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution_213 ob = new Solution_213();
        int[] nums = {94,40,49,65,21,21,106,80,92,81,679,4,61,6,237,12,72,74,29,95,265,35,47,1,61,397,52,72,37,51,1,81,45,435,7,36,57,86,81,72};
        System.out.println(ob.rob(nums));
    }

    public int rob(int[] nums) {
        //处理特殊情况
        //当前元素是要还是不要，要的话，他上下一个元素就不能打劫，不要的话上下就能打劫
        //isHaveEnd == true 代表0号位置不要
        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];

        int res2 = robComm(nums, 2, 0);//不要
        int res1 = robComm(nums, 1, 1); //要

        return Math.max(res1,res2+nums[0]);
    }

    public int robComm(int[] a,int cur, int isHaveEnd){

        if(cur > a.length-1){
            return 0;
        }

        if(cur == a.length-1){
            if(isHaveEnd == 1){
                return a[cur];
            }else{
                return 0;
            }
        }

        //当前元素要的情况
        int res1;//当前值没有要
        int res2;//当前值要了

        if(map.containsKey(""+(cur+2)+"_"+isHaveEnd)){
            res2 = map.get(""+(cur+2)+"_"+isHaveEnd);
        }else{
            res2 = robComm(a, cur+2, isHaveEnd);
        }

        if(map.containsKey(""+(cur+1)+"_"+isHaveEnd)){
            res1 = map.get(""+(cur+1)+"_"+isHaveEnd);
        }else{
            res1 = robComm(a, cur+1, isHaveEnd);
        }

        int max = Math.max(res1,res2+a[cur]);
        map.put(""+cur+"_"+isHaveEnd,max);
        return max;
    }
}

