package Chapter8.RecursionAndDynamicProgramming;

import java.util.Stack;

/**
 * Created by hnastevska on 7/4/2017.
 */
public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int index) {
        disks = new Stack<>();
        this.index = index;
    }

    public int index() {
        return index;
    }

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}
