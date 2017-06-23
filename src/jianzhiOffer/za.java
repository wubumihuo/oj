package jianzhiOffer;

/**
 * Created by mazhi on 2017/4/2.
 */
public class za {
    public double Power(double base, int exponent) {
        double result =1;
        for(int i=0;i<Math.abs(exponent);i++){
            result *=base;
        }
        if(exponent<0){
            result=1/result;
        }
        return result;
    }

    //顺时针打印矩阵
}
