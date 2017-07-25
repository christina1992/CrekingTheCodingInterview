package Chapter15.ThreadsAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hnastevska on 7/14/2017.
 */
public class Chopstick {
    private Lock lock;
    private int number;

    public Chopstick(int n) {
        lock = new ReentrantLock();
        this.number = n;
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }

    public int getNumber() {
        return number;
    }
}
