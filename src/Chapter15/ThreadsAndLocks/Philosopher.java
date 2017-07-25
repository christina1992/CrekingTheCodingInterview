package Chapter15.ThreadsAndLocks;

/**
 * Created by hnastevska on 7/14/2017.
 */
public class Philosopher extends Thread {
    private int bites = 10;
    private Chopstick lower, higher;
    private int index;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        if (left.getNumber() < right.getNumber()) {
            this.lower = left;
            this.higher = right;
        } else {
            this.lower = right;
            this.higher = left;
        }
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    public void putDown() {
        higher.putDown();
        lower.putDown();
    }

    public void chew() {
    }


    public void pickUp() {
        lower.pickUp();
        higher.pickUp();
    }


    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}
