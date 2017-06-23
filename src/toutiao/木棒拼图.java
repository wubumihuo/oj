package toutiao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/4/18.
 */
public class 木棒拼图 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;++i){
            int perform = in.nextInt();
            int length = in.nextInt();
            if(perform==1) {
                if(map.containsKey(length)) map.put(length,map.get(length)+1);
                else map.put(length,1);
            }
            else {
                map.put(length,map.get(length)-1);
            }
            System.out.println(canFormPolygon(map));
        }
    }
    public static String canFormPolygon(HashMap<Integer,Integer> map){
        int max = 0;
        int sum=0;
        int count =0;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key= (Integer) entry.getKey();
            int value = (Integer)entry.getValue();
            for(int i=0;i<value;i++){
                sum+=key;
                count++;
                if(key>max) max=key;
            }

        }
        if( count<3 || sum-max<=max ) return "No";
        else return "Yes";
    }
}
