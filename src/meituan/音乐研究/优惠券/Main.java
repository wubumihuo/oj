package meituan.音乐研究.优惠券;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/6/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            if (m == 0) {
                System.out.println(-1);
            } else {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                boolean end_flag = false;
                for (int i = 0; i < m; i++) {
                    String ch = in.next();
                    if (ch.equals("O")) {
                        int num = in.nextInt();
                        if (map.containsKey(num) && map.get(num) == 1) {
                            map.put(num, 0);
                        } else if (map.containsKey(0) && map.get(0) > 0) {
                            map.put(0, map.get(0) - 1);
                        } else {
                            end_flag = true;
                            System.out.println(i + 1);
                            break;
                        }

                    } else if (ch.equals("I")) {
                        int num = in.nextInt();
                        if (map.containsKey(num)) {
                            if (map.get(num) == 1) {
                                end_flag = true;
                                System.out.println(i + 1);
                                break;
                            } else {
                                map.put(num, 1);
                            }
                        } else {
                            map.put(num, 1);
                        }
                    } else {
                        if (map.containsKey(0))
                            map.put(0,map.get(0) + 1);
                        else map.put(0, 1);
                    }
                }
                if (!end_flag)
                    System.out.println(-1);
            }
        }
    }
}
