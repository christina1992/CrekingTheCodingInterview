package Chapter15.ThreadsAndLocks;

import java.util.concurrent.Semaphore;

/**
 * Calli n Order: Suppose we have the followi ng code:
 * public class Foo {
 * public FOO() { ... }
 * public void first() { ... }
 * public void second() { ... }
 * public void third() { ... }
 * }
 * The same instance of Foo will be passed to three different threads. ThreadA will call first, threadB
 * will call second, and threadC will call third. Design a mechanism to ensure that first is called
 * before second and second is called before third.
 */
public class Foo {
    public Semaphore sem1, sem2;

    public Foo() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);
            sem1.acquire();
            sem2.acquire();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void first() {
        try {
            //......
            sem1.release();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void second() {
        try {
            sem1.acquire();
            sem1.release();
            //....
            sem2.release();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void third() {
        try {
            sem2.acquire();
            sem2.release();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
