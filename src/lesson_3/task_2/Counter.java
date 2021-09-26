package lesson_3.task_2;

import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread {

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private int count = 0;

    @Override
    public void run() {
        while (count != 20) {
            add();
        }
    }

    private void add() {
        reentrantLock.lock();
        try {
            count++;
            System.out.println(count);
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
    }
}
