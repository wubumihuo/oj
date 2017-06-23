package jingdong;

/**
 * Created by mazhi on 2017/4/7.
 */

import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        while(s.hasNext())
        {
            int n = s.nextInt();
            int v = s.nextInt();
            ArrayList<Candy> candy1 = new ArrayList<Candy>();
            ArrayList<Candy> candy2 = new ArrayList<Candy>();
            ArrayList<Candy> best = new ArrayList<Candy>();
            for (int i = 0; i < n; i++)
            {
                int t = s.nextInt();
                int p = s.nextInt();
                if (t == 1)  candy1.add(new Candy(t, p, i+1));
                else candy2.add(new Candy(t, p, i+1));
            }
            Collections.sort(candy1, new CandyCom1());
            Collections.sort(candy2, new CandyCom1());
            int count1 = 0, count2 = 0;
            int max= 0;
            while(v>1)
            {
                if(count1<candy1.size() && (count2>=candy2.size()||candy1.get(count1).p > candy2.get(count2).p))
                {
                    max += candy1.get(count1).p;
                    best.add(candy1.get(count1++));
                    v--;
                }
                else if(count1+1<candy1.size() && (count2>=candy2.size()||candy1.get(count1).p + candy1.get(count1+1).p > candy2.get(count2).p))
                {
                    max += candy1.get(count1).p;
                    best.add(candy1.get(count1++));
                    v--;
                }
                else
                {
                    if ( count2>=candy2.size()) break;
                    max += candy2.get(count2).p;
                    best.add(candy2.get(count2++));
                    v-=2;
                }
            }
            if (v==1 && count1<candy1.size())
            {
                best.add(candy1.get(count1));
                max+=candy1.get(count1).p;
            }
            System.out.println(max);
            Collections.sort(best, new CandyCom2());
            if (best.size() == 0)    System.out.println("No");
            for (int i = 0; i < best.size(); i++)
            {
                System.out.print(best.get(i).num);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        s.close();
    }
}
class Candy
{
    int t, p, num;
    public Candy(int ti, int pi, int numi)
    {
        t = ti;
        p = pi;
        num = numi;
    }
}
class CandyCom1 implements Comparator<Candy>
{
    public int compare(Candy c1, Candy c2)
    {
        if (c1.p == c2.p)
        {
            if (c1.t == c2.t) return c1.num-c2.num;
            else return c1.t-c2.t;
        }
        else return c2.p-c1.p;
    }
}
class CandyCom2 implements Comparator<Candy>
{
    public int compare(Candy c1, Candy c2)
    {
        return c1.num - c2.num;
    }
}
