package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mazhi on 2017/3/7.
 */
public class firstone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int temp_sqrt = (int) Math.sqrt(n);
        List<Integer> primes = getPrimes(temp_sqrt);
        for (Integer prime : primes) {
            int count = 0;
            while (n % prime == 0) {
                n = n / prime;
                count++;
                if (n == prime) {
                    System.out.println(prime + " " + (++count));
                    return;
                }
            }
        }
        System.out.println("No");
    }

    /**
     * 求 n 以内的所有素数
     *
     * @return n 以内的所有素数
     */
    private static List<Integer> getPrimes(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(2);
        for (int i = 3; i <= n; i += 2) {
            if (!divisible(i, result)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 判断 n 是否能被整除
     *
     * @return 如果 n 能被 primes 中任何一个整除，则返回 true。
     */
    private static boolean divisible(int n, List<Integer> primes) {
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return true;
            }
        }
        return false;
    }

}
