package jianzhiOffer;

/**
 * Created by mazhi on 2017/3/29.
 */
public class BitPerform {
    public int NumberOf1(int n) {
        int flag=1;
        int count=0;
        while(flag!=0){
            if((n&flag)!=0) count++;
            flag =flag<<1;
        }
        return count;
    }
}
