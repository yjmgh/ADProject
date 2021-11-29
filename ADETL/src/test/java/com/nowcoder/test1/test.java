package com.nowcoder.test1;

import sun.util.resources.cldr.kk.CalendarData_kk_Cyrl_KZ;

import javax.xml.stream.XMLOutputFactory;
import java.util.Stack;

/**
 * @author yuanjiameng
 * @create 2021-09-21 13:44
 * @describe
 */
public class test {
    public static void main(String[] args) {

        String s = "abcd";
        char[] c = s.toCharArray();
        char[] cc = new char[3];
        cc[2] = 'c';
        //Combine(c);

        Combine_2(c);
    }

    public static void Combine(char[] c){
        if(c == null){
            return;
        }
        int len = c.length;
        boolean[] used = new boolean[len];
        char[] cache = new char[len];
        int result = len;

        while (true){
            int index = 0;
            while(used[index]){
                used[index] = false;
                ++result;
                if(++index == len){
                    return;
                }
            }

            used[index] = true;
            cache[--result] = c[index];
            System.out.println(new String(cache).substring(result)+" ");
        }
    }

    public static void Combine_2(char[] c){
        if(c == null) return;
        int len = c.length;
        boolean[] used = new boolean[len+1];
        char[] cache = new char[len];

        int index;
        int used_last_index = -1;

        boolean isUp;
        // 从000开始，每次加1
        while(true){
            index = 0;
            int cache_index = 0;
            isUp = true;
            cache = new char[len];
            //index

            //太过于复杂,可以只生成一个数，不用考虑其他的
            while(index <= used_last_index+1){

                if(index == used_last_index+1) {
                    // 来到最后+1的位置，并且该位置被置成了true则结束

                    if(isUp){
                        used[index] = true;
                        if(index == len && used[index] == true){
                            return;
                        }
                        cache[cache_index++] = c[index];
                        isUp = false;
                    }

                    //阻止index继续++
                    break;
                }

                // 当前值需要进位
                if(index <= used_last_index){

                    if(isUp){
                        if(used[index] == false){
                            used[index] = true;
                            // 将当前索引下的字母写入cache中
                            cache[cache_index++] = c[index];
                            //不进行进位
                            isUp = false;
                        }else{
                            used[index] = false;
                        }
                    }else{
                        if(used[index] == true)
                            cache[cache_index++] = c[index];
                    }

                }


                index++;
            }

            if(used[index] == true) used_last_index++;
            System.out.println(new String(cache).substring(0,cache_index)+" ");
        }

    }
}

