package niuke;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhi on 2017/3/17.
 */
public class digui {
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloor(int target) {
        if(target==1) return 1;
        if(target==2) return 2;
        return JumpFloor(target-1) + JumpFloor(target-2);
    }
    public  int JumpFloorII(int target) {
        List <Integer> list= new ArrayList<>();
        dfsHelper(target,list);
        return list.size();
    }
    public void dfsHelper(int target, List list){
        if(target==0) {
            list.add(0);
            return ;
        }
        for(int i=1;i<=3&&i<=target;i++)
            dfsHelper(target-i,list);
    }

    public static void main(String [] args){
        String to="Hello World";
        System.out.println(to.indexOf("I",3));
    }

}
