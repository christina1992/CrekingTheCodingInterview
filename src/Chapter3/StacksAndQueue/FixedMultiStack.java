package Chapter3.StacksAndQueue;

import java.util.EmptyStackException;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 */
public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        this.stackCapacity = stackSize;
        this.values = new int[stackSize * this.numberOfStacks];
        this.sizes = new int[numberOfStacks];
    }

    public static void main(String[] args) {

    }

    /* Push value onto stack*/
    public void push(int stackNum, int value) throws FullStackException {
        /*Check that we have space for the next element */
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        /*Increment stack pointer and then update top value*/
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /*Pop item from top stack*/
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; //Get Top
        values[topIndex] = 0; //Clear
        sizes[stackNum]--;
        return value;
    }

    /*Return top element*/
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }
}
