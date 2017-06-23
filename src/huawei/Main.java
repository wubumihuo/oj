package huawei;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/3/16.
 */
public class Main {
    //[编程题] 删数
    public static void main(String [] args) {

    }

    //[编程题] 进制转换
//    public static void main(String []args){
//        Scanner in =new Scanner(System.in);
//        String str=in.next();
//         char[] arr = str.toCharArray();
//        int renum=0;
//        for(int i=2;i<arr.length;i++){
//            if(arr[i]<='F'&& arr[i]>='A') renum=renum*16+(arr[i]-'A'+10);
//            else renum=renum*16+Character.getNumericValue(arr[i]);
//        }
//        System.out.println(renum);
//    }

    //[编程题] 明明的随机数
//    public static void main(String [] args){
//        HashSet<Integer> set =new HashSet<Integer>();
//        Scanner in = new Scanner(System.in);
//        int count=in.nextInt();
//        for(int j=0;j<count;j++){
//            set.add(in.nextInt());
//        }
//        Iterator iterator = set.iterator();
//       int arr[] = new int[set.size()];
//        int i=0;
//        while(iterator.hasNext()) arr[i++]=(int)iterator.next();
//        Arrays.sort(arr);
//        for(int a:arr) System.out.println(a);
//    }

    //[编程题] 汽水瓶
//    public static void main(String [] args){
//        Scanner in =new Scanner(System.in);
//        while(in.hasNext()){
//            int reSum=0;
//            int left=in.nextInt();
//            while(left>=3){
//                reSum += left/3;
//                left=left%3 + left/3;
//            }
//            if(left==2) reSum+=1;
//            System.out.println(reSum);
//        }
//    }


    //华为笔试模拟题
//    public static void main(String[] args) {
//        Scanner in =new Scanner(System.in);
//        while(in.hasNextLine()){
//            int a=in.nextInt();
//            int b=in.nextInt();
//            System.out.println(a+b);
//        }
//    }
//    public void swapWithZero(int[] array, int len, int n) {
//    }
//    public void sort(int[] array, int len) {
//        // 完成这个函数
//        if(len<2) return;
////        int zero_index =0;
////        for(int i=0;i<len;i++){
////            if(array[i]==0) zero_index=i;
////        }
//        for(int i=0;i<len;i++){
//            if(array[i]==i) continue;
//            else {
//                swapWithZero(array,len,i);
//                swapWithZero(array,len,array[i]);
//                swapWithZero(array,len,i);
//            }
//        }
//    }
}
