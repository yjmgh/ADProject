package com.nowcoder.three;

import org.apache.ivy.plugins.version.PatternVersionMatcher;

import java.util.Stack;

/**
 * @author yuanjiameng
 * @create 2021-09-15 16:58
 * @describe
 */
public class ZuiDaZiJuZhen {

    public static void main(String[] args) {

        //int[] height = new int[]{5,5,5,5,5,4,4};
        //System.out.println(maxRecFromBottom(height));

        int[][] map = new int[][]{{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(maxRecSize(map));
    }

    public static int maxRecSize(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        //一行一行的算出以每一行为低的最大值
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height),maxArea);
        }

        return maxArea;
    }

    //求一维数组的最大面积 [5,5,5,5,5,4]，当第二个5来了之后，计算的数值只有第一个5，第二个5不参与计算
    public static int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }

        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k -1) * height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea =(height.length -k -1) *  height[j];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}
