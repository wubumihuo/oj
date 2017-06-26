package gongsi.codem;

import java.util.Scanner;

/**
 * Created by 60433 on 2017/6/25.
 */
public class Main5 {
    static String temp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        String t=in.next();
        int max_level = 16;
        t = t.trim();
        StringBuilder sb = new StringBuilder();
        for (int k = 2; k <= max_level; k++) {
            sb.delete(0, sb.length());
            for (int i = 1; i <= n ; i++) {
                sb.append(Integer.toString(i, k));
            }
            if(sb.toString().toUpperCase().contains(t)){
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }
}
