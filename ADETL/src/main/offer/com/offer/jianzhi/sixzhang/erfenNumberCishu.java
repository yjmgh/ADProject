package com.offer.jianzhi.sixzhang;

/**
 * @author Yjm
 * @create 2019-10-08 10:36
 */
//题目：数字在排序的数组中出现的次数
//思路：在数组中先找到一个数字 == aim
//看他左边是否等于他 ， 不等于那么他就是最左边 ，等于那说明左边界在左边
// 看他右边是否等于他 ， 不等于那么他就是最右边 ，等于那说明右边界在右边
//伪代码：
//1 特殊值判断：null lengh == 0 之后fun()
//2 l == r 判断该值是否是aim 是返回坐标 不是返回-1
//3 使用while循环找到该值 ， 若没有该值返回-1
//4 判断左边 是否到0位置 ， 判断左边是否相等
//5 判断右边 是否到length-1位置 ， 判断右边是否相等 递归调用
//6 右边减去左边 返回  //问题所在：返回值 ：左递归返回左边 ， 右递归返回右边 ，给调用函数返回长度，是一个函数？
//答：使用的是三个函数 34是一个函数 35也是一个函数 ，再有一个控制函数
public class erfenNumberCishu {
    public static void main(String[] args) {

        int[] arr = new int[]{1 , 2 , 3 , 3 , 3 , 4 , 8 , 9 ,12};
        System.out.println(getNumber(arr, 4));
    }

    public static int getNumber(int[] arr , int aim){
        if(arr == null || arr.length == 0 || aim > arr[arr.length-1] || aim < arr[0]) return 0;

        return fun(arr , aim);
    }

    public static int fun(int[] arr , int aim){
        int number = 0;

        int first = process_left(arr , aim , 0 , arr.length-1);
        int last = process_right(arr , aim , 0 , arr.length-1);

        if(first > -1 && last > -1){
            number = last - first + 1;
        }

        return number;
    }

    public static int process_left(int[] arr , int aim , int left , int right){

        if(left == right) return arr[left] == aim ? left : -1;
        if(arr[left] == aim) return left;

        int l = left;
        int r = right;
        int mid = 0; //能找到的情况下一定赋值了 ， 没找到的情况下就直接返回-1了，因而不会出错

        while (l <= r){ // 先找一个点
            mid = l + (r - l >> 1);
            if(arr[mid] == aim) {
                break;
            }else if(arr[mid] < aim){
                l = mid +1;
            }else {
                r = mid - 1;
            }

        }
        //找到的情况是 l <= r , 没找到的情况是 l > r
        if(l > r ) return -1;

        //找到的情况 -- mid 不可能等于最左边
        if(arr[mid - 1] == aim){
            return process_left(arr , aim, left , mid-1);
        }else {
            return mid;
        }


    }

    public static int process_right(int[] arr , int aim , int left , int right){

        if(left == right) return arr[left] == aim ? left : -1;
        if(arr[right] == aim) return right;

        int l = left;
        int r = right;
        int mid = 0; //能找到的情况下一定赋值了 ， 没找到的情况下就直接返回-1了，因而不会出错

        while (l <= r){ // 先找一个点
            mid = l + (r - l >> 1);
            if(arr[mid] == aim) {
                break;
            }else if(arr[mid] < aim){
                l = mid +1;
            }else {
                r = mid - 1;
            }

        }
        //找到的情况是 l <= r , 没找到的情况是 l > r
        if(l > r ) return -1;

        //找到的情况 -- mid 不可能等于最左边
        if(arr[mid + 1] == aim){
            return process_left(arr , aim, mid+1 , right);
        }else {
            return mid;
        }


    }
}
