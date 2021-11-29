package com.nowcoder.two;

import org.apache.ivy.plugins.version.PatternVersionMatcher;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yjm
 * @create 2019-09-18 20:19
 */
public class test {
    public static void main(String[] args) {
        //String[] str = new String[] { "1", "2", "3", "4" };
        String[] str = new String[] { "a", "b", "c", "d" };
        listAll(Arrays.asList(str), "");
    }

    public static void listAll(List candidate, String prefix) {
        if (!prefix.equalsIgnoreCase(""))  //这儿体现了递归的出口
            System.out.println(prefix);
        for (int i = 0; i < candidate.size(); i++) {
            List temp = new LinkedList<>(candidate);
            prefix += temp.remove(i);//a  temp == b c d
            listAll(temp, prefix + temp.remove(i));
//函数中的参数从右边开始解析
        }
    }
}
