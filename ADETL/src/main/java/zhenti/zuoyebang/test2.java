package zhenti.zuoyebang;

/**
 * @author Yjm
 * @create 2019-10-15 20:17
 */
/*
* 新年伊始，马蜂窝开展一项为期24小时的线上点亮城市活动。

假设在0点0分打开app的总共有n个用户，这批用户作为初始种子用户。

每个用户在接下来的三个小时里，每个小时可以把点亮链接分享给三个好友。

当三次分享结束后，点亮用户关闭点亮状态（变为非点亮状态，无法再进行分享）。

收到分享的三个用户成为点亮用户，即获得分享权限。

（在此假设每个用户在每小时内一定会全部分享，所有收到分享的人也一定会点击）

那么在m个小时后有多少用户处于点亮状态？

注意：活动只有24个小时，24个小时以后点亮用户无法继续分享，点亮状态的用户数不再变化 */
public class test2 {
    public static void main(String[] args) {

    }

    public static int[] fun(int n){
        if(n <= 0) return null;

        int[] arr1 = new int[24];
        int[] arr2 = new int[24];

        arr1[0] = n;

        int sum = n;
        arr2[0] = n;
        /*for (int i = 0; i < 24; i++) {
            if((i - 3) >= 0){
                arr1[i] = arr1[i-1] * 3 - arr2[]
            }
        }*/

        return null;
    }
}
