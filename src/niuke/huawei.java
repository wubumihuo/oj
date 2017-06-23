package niuke;

import java.util.Scanner;

/**
 * Created by mazhi on 2017/2/17.
 */
public class huawei {
    public static void main(String [] args){
        getResult();
    }
    public static void getResult (){
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int [] grade = new int[n];
        for(int i=0;i<n;i++) grade[i]=scan.nextInt();
        for(int i=0;i<m;i++){
            String str=scan.next();
            char c=str.charAt(0);
            if(c=='Q') {
                int start=scan.nextInt();
                int end=scan.nextInt();
                int max=grade[start-1];
                for(int j=start-1;j<end;j++){
                    if(grade[j]>max) max=grade[j];
                }
                System.out.println(max);
            }
            else {
                int index= scan.nextInt();
                int value = scan.nextInt();
                grade[index-1]=value;
            }
        }
        scan.close();
    }
}
