package zhenti.ningmeng;

/**
 * @author Yjm
 * @create 2019-10-18 20:51
 */
//题目：ipv4转化为32位字符串
public class ipvfourTo {
    public static void main(String[] args) {
        String s = "225:12:5:9";
        System.out.println(fun(s));
    }

    public static String fun(String str){
        if(str == null || str.length() == 0) return "";

        //String[] sp = str.split("/.");

        String[] sp = str.split(":");
        int[] arr = new int[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.valueOf(sp[i]);
        }

        int[] res = new int[32];

        for (int i = 0; i < 4; i++) {
            int k = 1;
            int w = (i + 1) * 8 -1;
            for (int j = 0; j < 8; j++) {
                if((k & arr[i]) != 0){
                    res[w] = 1;
                }
                k = k << 1;
                w--;
            }
        }

        String r = fun2(res);

        return r;
    }

    public static String fun2(int[] arr){
        String str = "";
        for (int i = 0; i < 8; i++) {
            str += change(arr , i);
        }

        return str;
    }

    public static char change(int[] arr ,int i){
        int begin = i * 4;
        int sum = 0;
        for (int j = begin; j < begin + 4; j++) {
            sum = sum*2 + arr[j];
        }

        char[] ch = new char[]{'0','1' , '2' , '3' ,'4' , '5' , '6','7' , '8' , '9' ,'A' , 'B' , 'C','D' , 'E' , 'F'};

        return ch[sum];

    }
}
