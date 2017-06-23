package gaoqi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhi on 2017/3/6.
 */
public class ThreadTest {


    public static void main(String[] args) throws InterruptedException {
        ShareVar ins = new ShareVar();
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread;
            if (i % 2 == 0) {
                thread = new Thread(new AddThread(ins));

            } else {
                thread = new Thread(new SubThread(ins));

            }

            thread.start();
            threadList.add(thread);

        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println(Thread.currentThread().getId() + "   " + ins.getCount());


    }


}

class ShareVar {
    private int count;

    public void add() {
        try {
            Thread.sleep(100);//此处为了更好的体现多线程安全问题
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;


    }

    public void sub() {
        count--;
    }

    public int getCount() {
        return count;
    }
}

class AddThread implements Runnable {
    private ShareVar shareVar;

    public AddThread(ShareVar shareVar) {
        this.shareVar = shareVar;
    }

    @Override
    public void run() {
        shareVar.add();
    }
}

class SubThread implements Runnable {
    private ShareVar shareVar;

    public SubThread(ShareVar shareVar) {
        this.shareVar = shareVar;
    }

    @Override
    public void run() {
        shareVar.sub();
    }
}