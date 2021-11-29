package deshuai;

import java.util.Scanner;

/**
 * @author yuanjiameng
 * @create 2020-08-12 19:45
 */
public class jiaoyan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n <= 0 ) return;

        String[] result = new String[n];

        for (int i = 0; i <n; i++) {

            String temp = sc.next().trim();
            if(temp == null || temp.length() == 0 || temp.length() > 20) return;

            char[] char_arr = temp.toCharArray();
            if(isRight(char_arr, char_arr.length)){
                result[i] = "Accept";
            }else {
                result[i] = "Wrong";

            }

        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static boolean isRight(char[] char_arr, int l) {

        boolean isNumFlag = false;
        boolean isCharFlag = false;
        if (!(Character.isUpperCase((char_arr[0]) )|| Character.isLowerCase(char_arr[0]))) return false;

        for (int i = 0; i < l; i++) {
            if(!(Character.isDigit(char_arr[i]) == true || Character.isLowerCase(char_arr[i]) == true ||Character.isUpperCase(char_arr[i]) == true)) return false;
            if (Character.isDigit(char_arr[i])) isNumFlag = true;
            if (Character.isLowerCase(char_arr[i])||Character.isUpperCase(char_arr[i])) isCharFlag = true;

        }

        if(isNumFlag == false || isCharFlag == false) return false;
        return true;
    }
}
