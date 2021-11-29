package com.nowcoder.one;

/**
 * @author Yjm
 * @create 2019-09-13 10:41
 */
//找出字符串中最大的回文子串的长度，时间复杂度O(n)
//解法:当前元素i，当前回文的右边界，都是不可逆的递增
public class Manacher {
    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(manacher(str1));
    }

    public static char[] bianxing(String str){
        char[] chs1 = str.toCharArray();
        char[] res = new char[chs1.length*2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chs1[index++]; //(i & 1) == 0 等价于 i%2 == 0
        }
        return res;

    }

    public static int manacher(String str){
        //1 先变形
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chs = bianxing(str);
        int[] lenArr = new int[chs.length]; //每一个点回文半径长度
        int R = -1;
        int index = -1; //  R` -- index -- R
        int max = Integer.MIN_VALUE;
        //2 R递增

        for (int i = 0; i < chs.length; i++) {
            //一共是四种情况：
            // 1 i > R : 暴力破
            // 2 lenArre[i`]在R`里面 //跟3 4 合到一起的话向外扩一步就死了
            // 3 lenArre[i`] == R`
            // 4 lenArre[i`] > R`  3 4 可以合成一个 以右边界为准
            lenArr[i] = R > i ? Math.min(lenArr[index * 2 - i] , R - i) : 1; //index * 2 - 1 -- (R` + R) / 2 == index

            //下面的是能暴力扩就暴力扩，否则直接break
            while (i + lenArr[i] < chs.length && i - lenArr[i] > -1){
                if(chs[i + lenArr[i]] == chs[i - lenArr[i]]){
                    lenArr[i]++;
                }else {
                    break;
                }

            }
           // (R` -- index -- R) 是开区间
            if(i + lenArr[i] > R){
                R = i + lenArr[i];
                index = i;
            }
            max = Math.max(max , lenArr[i]);
        }

        //3 返回结果
        //因为算上了#的个数 max本来是一半 带# len = lenArr[i] * 2 - 1
        //因为都是奇数 不带# = (len[#] - 1) / 2   12 = 13
        return max - 1;

    }

}
