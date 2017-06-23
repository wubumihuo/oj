package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/3/24.
 */
public class Main {
    public static void main(String[] args) {
        int [][] arrWeight= {{0,2,10,5,3,-1},{-1,0,12,-1,-1,10},
                {-1,-1,0,-1,7,-1},{2,-1,-1,0,2,-1},
                {4,-1,-1,1,0,-1},{3,-1,1,-1,2,0}};
        Scanner in = new Scanner(System.in);
        int arrNeed = in.nextInt();
        int frogIndex = in.nextInt();
        if(frogIndex==5) System.out.println(1000);
        else {
            if(frogIndex==0) {}
            else {
                for(int j=0;j<6;j++) {
                    arrWeight[frogIndex - 1][j] = -1;
                    arrWeight[j][frogIndex - 1] = -1;
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(5);
            ArrayList<List> relist = new ArrayList<>();
            dfshelper(5,arrNeed,arrWeight,list,relist);
            List<Integer> answerlist = new ArrayList<>();
            int mincost=Integer.MAX_VALUE;
            if(relist.size()==0) System.out.println(1000);
            else{
                for(int i=0;i<relist.size();i++){
                    int cost=0;
                    for(int j=1;j<relist.get(i).size();j++){
                        cost+=arrWeight[(Integer) relist.get(i).get(j-1)-1][(Integer) relist.get(i).get(j)-1];
                    }
                    if(mincost>cost){
                        mincost=cost;
                        answerlist=relist.get(i);
                    }
                }
                System.out.println(mincost);
                System.out.print('[');
                for(int i=0;i<answerlist.size()-1;i++) {
                    System.out.print((Integer) answerlist.get(i));
                    System.out.print(", ");
                }
                System.out.print(answerlist.get(answerlist.size()-1));
                System.out.print(']');
            }
        }

    }
    public static void dfshelper(int nowIndex, int targetIndex,int arrWeight[][], List<Integer> list, List<List> relist){
        for(int j=0;j<6;j++){
//            if(arrWeight[nowIndex-1][j]==0) {
//                relist.add(list);
//                return;
//            }
             if(arrWeight[nowIndex-1][j]>0) {
                 List<Integer> templist= list;
                 if((j+1)==targetIndex){
                     templist.add(j+1);
                     relist.add(list);
                     return;
                 }
                boolean flag = true;
                for (int i = 0; i < templist.size(); i++) {
                    if (templist.get(i) == (j+1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(j+1);
                    dfshelper(j+1,targetIndex, arrWeight,templist,relist);
                }
            }
        }
        return;
    }

}
