package zhenti.jingjishijie;

import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-10-20 19:40
 */
public class xianglian {
    public static void main(String[] args) {

    }

    public static int fun(String str , String aim){
        if(str == null || str.length() == 0) return -1;
        if(aim == null || aim.length() == 0) return str.length();

        char[] strs = str.toCharArray();
        char[] aims = aim.toCharArray();

        HashMap<Character , Integer> map1 = new HashMap<>();//窗口里面的数据
        HashMap<Character , Integer> map2 = new HashMap<>();//皇后喜欢的数据

        for (int i = 0; i < aims.length; i++) {
            map2.put(aims[i] , i);
        }

        int l = -1;
        int r = -1;
        int len = 0;
        int min = strs.length;
        for (int i = 0; i < strs.length; i++) {
            if(map2.containsKey(strs[i])){
                l = i;
                r = i;
                len = 0;
                break;
            }
        }

        if(l == -1) return str.length();

       while (true){
           //r能否右扩
           int r_r = r+1;
           if(r + 1 < strs.length){
               if(!map2.containsKey(strs[r_r])){
                   r = r_r;
               }else {
                   if(!map1.containsKey(strs[r_r])){
                       map1.put(strs[r_r] ,r_r);
                       r = r_r;
                       if(map1.size() == aims.length){
                           min = Math.min(min,r+1 - l);
                           for (int j = l+1; j < strs.length; j++) {
                               if(map2.containsKey(strs[j])){
                                   l = j;
                                   break;
                               }
                           }

                       }
                   }
               }

           }


       }




        /*for (int i = l; i < strs.length; i++) {
            if(map2.containsKey(strs[i])){
                if(map1.containsKey(strs[i])){

                }else {
                    map1.put(strs[i] , i);

                }

                if(map1.size() == aims.length){
                    min = Math.min(min,i+1 - l);
                    for (int j = l+1; j < strs.length; j++) {
                        if(map2.containsKey(strs[j])){
                            l = i;
                            break;
                        }
                    }

                }

            }
        }*/
    }
}
