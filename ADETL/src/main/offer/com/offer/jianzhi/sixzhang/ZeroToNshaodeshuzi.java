package com.offer.jianzhi.sixzhang;

/**
 * @author Yj m
 * @create 2019-10-08 12:17
 */
//题目： 0 ~ n-1 中缺失了两个数 ， 请找出来:数组中的数字只能是0 到 n - 1，且是排好序
//思路： 使用二分查找：
// mid的值若是等于下标的值代表下标值及其左边都是没有缺失的
// 若不等：当前值 - mid = 1 看mid-1跟前一个值是否相等，相等代表当前mid就是第一个偏离的，相差1代表当前值的左边有缺的值，递归左边
//         当前值 - mid = 2 看mid-1跟前一个值是否相等，相等就是mid 与mid-1，不相等，看相差1，则是mid+1，相差2，都在左边
// 最终返回int[2]
//伪代码：
//计算出mid arr[mid] - mid :
//              0 右递归 ，
//              1 看arr[mid-1] - mid == 0 ? mid : 递归左边 + 递归右边， 使用arr[0]接受
//              2  arr[mid-1] - mid == 0 ? mid + mid+1 ? 1 mid + 1 ? 2 左递归   使用arr[0]，arr[1]接收
public class ZeroToNshaodeshuzi {
    public static void main(String[] args) {

        //int[] arr = new int[]{0 , 1 , 3 , 4 , 5 , 7 , 8 , 9 ,10};
        int[] arr = {0 ,1 , 2};
        int[] res = fun(arr,4);
        System.out.println(res[0] + " " + res[1]);
    }
    public static int[] fun(int[] arr , int n_1){ //n-1
        if(arr == null || arr.length == 0) return new int[]{-1, -1};
        int r_l = n_1 - arr[arr.length-1];
        int[] res = new int[2];
        if(r_l == 2){
            return new int[]{n_1-1,n_1};
        }else if(r_l == 1){
            res[1] = n_1;
            res[0] = process(arr , 0 , arr.length-1)[0];
            return res;
        }
        return process(arr , 0 , arr.length-1);
    }

    public static int[] process(int[] arr , int left , int right){
        int[] res = {-1,-1};

        if(left > right) return res;

        if(left == right){
            int r_l = arr[left] - left; //差值

            if(r_l == 2) {
                if(left == 0){
                    res[0] = left;
                    res[1] = left+1;
                }else {
                    if(arr[left-1] - (left-1) == 0){
                        res[0] = left;
                        res[1] = left+1;

                    }else if(arr[left-1] - (left-1) == 1){
                        res[0] = left+1;
                    }
                }

            }else if(r_l == 1){
                res[0] = left;
            }

            return res;
        }

        int mid = left + (right - left >> 1);
        int r_l = arr[mid] - mid;

        if(r_l == 0) {
            res = process(arr , mid+1 , right);
            return res;
        }

        if(r_l == 1){
            if(mid == 0) {
                res[0] = mid;
                res[1] = process(arr , mid+1 , right)[0];
            }else {
                if(arr[mid-1] - (mid-1)== 1) {
                    res[0] = process(arr , left , mid-1)[0];
                    res[1] = process(arr , mid+1 , right)[0];
                }else {
                    res[0] = mid;
                    res[1] = process(arr , mid+1 , right)[0];

                }
            }
            return res;
        }

        if(r_l == 2){
            if(mid == 0) {
                res[0] = mid;
                res[1] = mid+1;

            }else {
                if(arr[mid-1] - (mid-1) == 0){
                    res[0] = mid;
                    res[1] = mid+1;

                }else if(arr[mid-1] - (mid-1) == 1){
                    res[0] = process(arr , left , mid-1)[0];
                    res[1] = mid + 1;

                }else {
                    res = process(arr , left , mid-1);
                }

            }
            return res;
        }


        return res;//一定不会被调用

    }
}
