package leetcode;

/**
 * Created by mazhi on 2017/4/21.
 */
public class Main {
    public static void main(String[] args) {
        double T_REF=3000.0;
        double delta = 0.99;
        double t=T_REF;
        for(int i=0;i<450;i++){
            t *= delta;
        }
        System.out.println(t/T_REF);
    }
}
