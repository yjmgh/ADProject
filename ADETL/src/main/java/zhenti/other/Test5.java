package zhenti.other;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-11-14 19:47
 */
public class Test5 {
    public static void main(String[] args) {
int[] arr = new int[]{-4,-2,0,1,1,4,6};
        //System.out.println(threeSum(arr));
    }

    public static int threeSum(String numstr){
        if(numstr == null || numstr.length() == 0) return 0;
        String[] sp = numstr.split(",");
        int[] arr = new int[sp.length];

        for (int i = 0; i < sp.length; i++) {
            arr[i] = Integer.valueOf(sp[i]);
        }
        int re = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) break;
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int j = arr.length-1;
            int xiangfan = 0 - arr[i];
            int k = i + 1;
            while (k < j){
                if(arr[k] + arr[j] == xiangfan){
                    re++;
                    while(k < j && arr[k] == arr[k+1]) k++;
                    while(k < j && arr[j] == arr[j-1]) j--;
                    k++;
                    j--;
                }else if(arr[k] + arr[j] > xiangfan){
                    j--;
                }else {
                    k++;
                }
            }
        }

    return re;
    }
}
