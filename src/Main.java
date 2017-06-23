import java.util.ArrayList;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean []visited = new boolean[n+1];
        for(int i=0;i<n;i++){
            visited[i]=false;
        }
        ArrayList<Integer> list = new ArrayList();
        int []result = new int[2];
        result[0]=0;
        dfsHelper(n,visited,list,result);
        System.out.println(result[0]);
    }
    public static void dfsHelper(int now_max,boolean []visited,ArrayList<Integer> list,int result[]){
        if(now_max == 0){
            int renum=1;
            for(int a:list) renum*=a;
            if(result[0]<renum) result[0]=renum;
        }
        for(int i=now_max;i>0;i--) {
            if (visited[i] == true) return;
            else {
                boolean []newvisited = new boolean[visited.length];
                System.arraycopy(visited,0,newvisited,0,visited.length);
                newvisited[i]=true;
                ArrayList<Integer> newlist = new ArrayList<>();
                newlist = (ArrayList<Integer>)list.clone();
                newlist.add(i);
                dfsHelper(now_max - i, newvisited, newlist, result);
            }
        }
    }
}