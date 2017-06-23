package codecraft;

/**
 * Created by mazhi on 2017/3/25.
 */
public class Main {
    public static void main(String[] args) {
        double m=3000;
        double delta =0.95;
        int i=0;
        while(m>1){
            m*=delta;
            i++;
        }
        System.out.println(i);
    }
}
