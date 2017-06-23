package gaoqi;

/**
 * Created by mazhi on 2017/3/6.
 * 利用Thread 和 Runnable
 */
public class ThreadRun implements Runnable {
    public void run() {
       // synchronized(this) {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
       // }
    }
    public static void main(String[] args) {
        ThreadRun t1 = new ThreadRun();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }
}
