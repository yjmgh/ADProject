package zhenti.other;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-11 14:10
 */
public class Test2_My {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) return;
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
        }
        //System.out.println(lengthOfLIS(number));
        System.out.println(len(number));

    }

    public static int len(int[] arr) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        int number;//存放第一层循环当前元素值
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            number = arr[i];
            if (number > temp[index]) {
                /*index++;
                temp[index] = number;*/
                temp[++index] = number;
            } else {
                int low = 0;
                int high = index;
                while (low < high) {
                    int mid = ((high + low) >> 1);
                    //如 4 5 7 9 10 输入7，则7必须归到 4 5 这一块才能替换7
                    if (number > temp[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                if (temp[low] < number && (low + 1) < temp.length) {
                    temp[low + 1] = number;
                } else {
                    temp[low] = number;
                }
            }

        }

        for (int item : temp) {
            System.out.print(item + " ");
        }
        return index + 1;
    }
}
