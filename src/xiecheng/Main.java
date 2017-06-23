package xiecheng;

import java.util.*;

/**
 * Created by mazhi on 2017/4/11.
 */
public class Main {
     /*请完成下面这个函数，实现题目要求的功能*/
    /*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    static int run(String numbers){
        int []num = new int[9];
        for(int i=0;i<numbers.length();i++){
            num[i]=numbers.charAt(i)-'0';
        }
        int[] stop_position = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        Set<int[]> visited = new HashSet<>();
        Queue<Integer> levelQ = new ArrayDeque<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(num);
        levelQ.offer(0);
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentLevel = levelQ.poll();
            visited.add(current);
            if (Arrays.equals(current, stop_position)) {
                return currentLevel;
            }
            List<int[]> nexts = nextsOf(current);
            for (int[] next : nexts) {
                if (!visited.contains(next)) {
                    q.offer(next);
                    levelQ.offer(currentLevel + 1);
                }
            }
        }
        return -1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static List<int[]> nextsOf(int[] current) {
        int r = 0, c = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (current[i * 3 + j] == 0) {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        List<int[]> nexts = new ArrayList<>();
        if (r > 0) {
            int[] next = Arrays.copyOf(current, current.length);
            swap(next, 3 * r + c, 3 * (r - 1) + c);
            nexts.add(next);
        }
        if (r < 2) {
            int[] next = Arrays.copyOf(current, current.length);
            swap(next, 3 * r + c, 3 * (r + 1) + c);
            nexts.add(next);
        }
        if (c > 0) {
            int[] next = Arrays.copyOf(current, current.length);
            swap(next, 3 * r + c, 3 * r + c - 1);
            nexts.add(next);
        }
        if (c < 2) {
            int[] next = Arrays.copyOf(current, current.length);
            swap(next, 3 * r + c, 3 * r + c + 1);
            nexts.add(next);
        }
        return nexts;
    }
    /******************************结束写代码******************************/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numbers = new String();
        for(int rows=3; rows>0; rows--){
            for(String n: scan.nextLine().split(" ")){
                numbers += n;
            }
        }
        int res = run(numbers);
        System.out.println(String.valueOf(res));
    }
}
