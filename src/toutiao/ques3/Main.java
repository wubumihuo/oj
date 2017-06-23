package toutiao.ques3;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
        String num[][] = {{"***", "* *", "* *", "* *", "***"},
                {"*", "*", "*", "*", "*"},
                {"***", "  *", "***", "*  ", "***"},
                {"***", "  *", "***", "  *", "***"},
                {"* *", "* *", "***", "  *", "  *"},
                {"***", "*  ", "***", "* *", "***"},
                {"***", "*  ", "***", "* *", "***"},
                {"***", "  *", "  *", "  *", "  *"},
                {"***", "* *", "***", "* *", "***"},
                {"***", "* *", "***", "  *", "***"}
        };
        String perform[][] = {
                {"   ", " * ", "***", " * ", "   "},
                {"   ", "   ", "***", "   ", "   "},
                {"   ", "* *", " * ", "* *", "   "},
                {"   ", "  *", " * ", "*  ", "   "},
                {"    ", "****", "    ", "****", "    "},
                {"  ", "  ", "  ", "**", "**"}
        };
        Scanner in =new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        String str3 = in.next();
        long a1 = Long.parseLong(str1);
        long a2= Long.parseLong(str3);
        long result =0;
        boolean ischufa = false;
        double result_chufa = 0;
        for(int i=0;i<5;i++){
            char [] arr1 = str1.toCharArray();
            for(int j=0;j<arr1.length;++j){
                int a=arr1[j]-'0';
                System.out.print(num[a][i]);
                System.out.print("  ");
            }
            if(str2.equals("+")) {
                result=a1+a2;
                System.out.print(perform[0][i]);
            }
            else if(str2.equals("-")){
                result=a1-a2;
                System.out.print(perform[1][i]);
            }
            else if(str2.equals("*")){
                result=a1*a2;
                System.out.print(perform[2][i]);
            }
            else if(str2.equals("/")) {
                result=a1/a2;
                result_chufa =(double) a1/a2;
                ischufa = true;
                System.out.print(perform[3][i]);
            }
            System.out.print("  ");
            char [] arr3 = str3.toCharArray();
            for(int j=0;j<arr3.length;++j){
                int a=arr3[j]-'0';
                System.out.print(num[a][i]);
                System.out.print("  ");
            }
            System.out.print(perform[4][i]);
            System.out.print("  ");
            String d = "";
            if(ischufa) d= String.valueOf(result_chufa);
            else  d=String.valueOf(result);
            char [] last_result = d.toCharArray();
            for(int j=0;j<last_result.length;++j){
                if(last_result[j]=='.') {
                    System.out.print(perform[5][i]);
                    System.out.print("  ");
                    for(int k=j+1;k<last_result.length;k++){
                        if(last_result[k]==0) break;
                        else {
                            int b= last_result[k]-'0';
                            System.out.print(num[b][i]);
                        }
                    }
                        break;
                }
                else {
                    int a=last_result[j]-'0';
                    System.out.print(num[a][i]);
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
