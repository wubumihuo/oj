package jianzhiOffer;

import java.util.*;

/**
 * Created by mazhi on 2017/3/11.
 */
public class ArrayPerform {
    //    在一个二维数组中，每一行都按照从左到右递增的顺序排序，
//    每一列都按照从上到下递增的顺序排序。请完成一个函数，
//    输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public boolean Find(int target, int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        return true;
    }

    //    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    public int minNumberInRotateArray(int[] array) {
        if (array.length < 1) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    // 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() < 1) return list;
        HashSet<String> set = new HashSet<>();
        permutationHelper(set, str, "");
        for (String str1 : set) {
            list.add(str1);
        }
        Collections.sort(list);
        return list;
    }

    public void permutationHelper(HashSet<String> set, String str, String result) {
        if (str.length() == 0) {
            set.add(result);
            return;
        }
        for (int j = 0; j < str.length(); j++) {
            permutationHelper(set, str.substring(0, j) + str.substring(j + 1, str.length()), result + str.charAt(j));
        }
    }
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    public void reOrderArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) list.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) list.add(array[i]);
        }
        int i = 0;
        for (int a : list) {
            array[i] = a;
            i++;
        }
    }

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    // 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    // 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length < 1) return 0;
        int tmp = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == tmp) count++;
            else {
                if (count > 0) count--;
                else {
                    count++;
                    tmp = array[i];
                }
            }
        }
        count=0;
        for(int a:array){
            if(a==tmp) count++;
        }
        if(count*2>array.length) return tmp;
        else return 0;
    }

    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
    // 则最小的4个数字是1,2,3,4,。
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length <= 0 || input.length < k) return list;
        //构建最大堆
        for (int len = k / 2 - 1; len >= 0; len--) {
            heapfy(input, len, k );
        }
        //从第K个元素开始分别于最大堆的最大值作比较，如果比最大值小，
        //则替换并调整堆。最终堆里的就是最小的K个数。
        int tmp;
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                tmp = input[0];
                input[0] = input[i];
                input[i] = tmp;
                heapfy(input, 0, k );
            }
        }
        for (int j = 0; j < k; j++) list.add(input[j]);
        return list;
    }

    public  static void adjustMaxHeapSort(int[] input, int pos, int length) {
        int temp;
        int child = 0;
        for (temp = input[pos]; 2 * pos + 1 <= length; pos = child) {
            child = 2 * pos + 1;
            if (child < length && input[child] < input[child + 1]) {
                child++;
            }
            if (input[child] > temp) {
                input[pos] = input[child];
            } else {
                break;
            }
        }
        input[pos] = temp;
    }
    public static void heapfy(int a[],int index,int heapsize)
    {
        int left=index*2+1;
        int right=left+1;
        int largest=index;
        if(left<heapsize&&a[index]<a[left])
            largest=left;
        if(right<heapsize&&a[largest]<a[right])
            largest=right;
        if(largest!=index)
        {
            swap(a,index,largest);
            heapfy(a,largest,heapsize);
        }
    }
    public static void swap(int []arr,int a_index,int b_index){
        int tmp = arr[a_index];
        arr[a_index] = arr[b_index];
        arr[b_index] =tmp;
    }
/*在一个字符串(1<=字符串长度<=10000，全部由字母组成)
// 中找到第一个只出现一次的字符,并返回它的位置。
// 如果字符串为空,返回-1*/
public int FirstNotRepeatingChar(String str) {
    if(str==null) return -1;
    char[] c=str.toCharArray();
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i=0;i<str.length();i++)
    {
        if(map.containsKey(c[i]))
        map.put(c[i],map.get(c[i])+1);
        else map.put(c[i],1);
    }
    for(int i=0;i<str.length();++i){
        if (map.get(c[i])==1)
            return i;
    }
    return 0;
}
    /*求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
    但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
    可以很快的求出任意非负整数区间中1出现的次数。*/

    //if n = xyzdabc
//    and we are considering the occurrence of one on thousand, it should be:
//
//            (1) xyz * 1000                     if d == 0
//            (2) xyz * 1000 + abc + 1           if d == 1
//            (3) xyz * 1000 + 1000              if d > 1
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) ans += n % x + 1;
            if (digit >  1) ans += x;
            x *= 10;
        } while (q > 0);
        return ans;
    }
    /*输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
    打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
    则打印出这三个数字能排成的最小数字为321323。*/
    public String PrintMinNumber(int [] numbers) {
       if(numbers==null||numbers.length==0) return "";
        int len=numbers.length;
        String[]str = new String[len];
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<len;i++){
            str[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                String c1=s1+s2;
                String c2=s2+s1;
                return c1.compareTo(c2);
            }
        });
        for(int i=0;i<len;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
    /*把只包含因子2、3和5的数称作丑数（Ugly Number）。
    例如6、8都是丑数，但14不是，因为它包含因子7。
    习惯上我们把1当做是第一个丑数。
    求按从小到大的顺序的第N个丑数。*/
    public static int GetUglyNumber_Solution(int index) {
        if(index<7) return index;
        int t2=0,t3=0,t5=0;
        int arr[]=new int[index];
        arr[0]=1;
        for(int i=1;i<index;i++){
            arr[i]=getMin(arr[t2]*2,arr[t3]*3,arr[t5]*5);
            if(arr[i]==arr[t2]*2) ++t2;
            if(arr[i]==arr[t3]*3) ++t3;
            if(arr[i]==arr[t5]*5) ++t5;
        }
        return arr[index-1];
    }
    public  static int  getMin(int a, int b,int c){
        int min=a;
        if(b<min) min=b;
        if(c<min) min=c;
        return min;
    }
    /*统计一个数字在排序数组中出现的次数。*/
    public static int GetNumberOfK(int [] array , int k) {
        int len=array.length;
        if(len==0) return 0;
        int left=0,right=len-1;
        int mid=0;
        while(left<=right){
            mid= (left+right)/2;
            if(array[mid]==k) break;
            else if(array[mid]>k) left=mid+1;
            else right=mid-1;
        }
        if(array[mid]==k){
            int t_left=mid,t_right=mid;
            while((t_left-1)>-1&&array[t_left-1]==k){
                t_left--;
            }
            while ((t_right+1)<len&&array[t_right+1]==k){
                t_right++;
            }
            return t_right-t_left+1;
        }
        else return 0;
    }
    public static void main(String[] args) {
       int array[]={1,2,3,3,3,3,4,5};
        int k=3;
        GetNumberOfK(array,k);
    }
}
