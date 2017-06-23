package acmcoder;

import java.util.*;

/**
 * Created by mazhi on 2017/4/6.
 */
public class purchaselist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] pricearr = new int[n];
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                pricearr[i] = in.nextInt();
            }
            Arrays.sort(pricearr);
            for (int i = 0; i < m; i++) {
                String str = in.next();
                if (map.containsKey(str)) map.put(str, map.get(str) + 1);
                else map.put(str, 1);
            }
            ArrayList<Integer> goodslist = new ArrayList();
            Iterator iter_map = map.entrySet().iterator();
            while (iter_map.hasNext()) {
                Map.Entry<String, Integer> ent = (Map.Entry) iter_map.next();
                goodslist.add(ent.getValue());
            }
            Collections.sort(goodslist);
            int i = 0;
            int len = pricearr.length;
            int price_min = 0;
            int price_max = 0;
            for (int j = goodslist.size() - 1; j >= 0; j--) {
                price_max += goodslist.get(j) * pricearr[len - 1 - i];
                price_min += goodslist.get(j) * pricearr[i];
                i++;
            }
            System.out.println(price_min + " " + price_max);
        }
    }
}
