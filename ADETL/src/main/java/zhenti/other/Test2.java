package zhenti.other;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-11 11:45
 */
public class Test2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
        }
        //System.out.println(lengthOfLIS(number));
        System.out.println(getLength(number));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }

    private static int getLength(int[] array) {
        int[] assistArray = new int[array.length];
        assistArray[0] = array[0];
        int length = 0;
        for (int number : array) {
            if (assistArray[length] < number) {
                assistArray[++length] = number;
            } else {
                int low = 0;
                int high = length;
                while (low < high) {
                    int middle = (low + high) >> 1;
                    //如 4 5 7 9 10 输入7，则7必须归到 4 5 这一块才能替换7
                    //就是说相等的直接放在了小的里面了，有几个连续的就一直往左走
                    if (assistArray[middle] < number) {
                        low = middle + 1;
                    } else {
                        high = middle - 1;
                    }
                }
                if (assistArray[low] < number && (low + 1) < assistArray.length) {
                    assistArray[low + 1] = number;
                } else {
                    assistArray[low] = number;
                }
            }
        }
        for (int tmp : assistArray) {
            System.out.println(tmp);
        }
        return length + 1;
    }
}
