package zhenti.xueersi;

import java.util.Scanner;
import java.util.Stack;


public class xueersione {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String[] chs = str.split(" ");
        int[] arr = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            arr[i] = Integer.parseInt(chs[i]);
        }

        if(arr == null || arr.length == 0) return;
        int[] res = fun(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
    public static int[] fun(int[] arr){
        //if(arr == null || arr.length == 0) return null;
        if(arr.length == 1) return arr;
        int[] temp = new int[arr.length];
        int k = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        while (!stack.isEmpty()){
            temp[k] = stack.pop();
            k++;
        }


        return temp;
    }
}
