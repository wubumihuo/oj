package jianzhiOffer;

/**
 * Created by mazhi on 2017/4/1.
 */
public class huawei {
    public static void main(String[] args) {
        double delta = 0.99;
        int T_REF = 3000;
        double t =T_REF;
        int count=0;
        while(t/T_REF>0.5){
            count++;
            t*=delta;
        }
        System.out.println(count);
    }
}
