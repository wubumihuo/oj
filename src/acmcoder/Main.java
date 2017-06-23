package acmcoder;

/**
 * Created by mazhi on 2017/4/7.
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat(".#####");
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        double []pi=new double[n];
        for(int i=0;i<n;i++){
            pi[i]=in.nextInt()*0.01;
        }
        double single_pi=1;
        ArrayList<Double> pi_list = new ArrayList();
        pi_list.add(0.0);
        int correct=0;
        dfsHelper(0,n,0,pi,single_pi,pi_list);
        double answer=0;
        System.out.printf("%.5f\n", pi_list.get(0));
    }
    public static void dfsHelper(int index,int n,int correct,double [] pi,double now_pi,ArrayList list){
        if(index>=n) {
            double a=correct;
            double b=n;
            if(a/b>=0.6) list.set(0,(double)list.get(0)+now_pi);
            return;
        }
        dfsHelper(index+1,n,correct+1,pi,now_pi*pi[index],list);
        dfsHelper(index+1,n,correct,pi,now_pi*(1-pi[index]),list);
        return;
    }
}