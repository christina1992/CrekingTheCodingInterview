package Chapter2.LinkedLists;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -) 5 -) 8 -) 5 -) 113 -) 2 -) 1 [partition = 5]
 * Output: 3 -) 1 -) 2 -) 113 -) 5 -) 5 -) 8
 */
public class Partition {
    public static SLLNode partition(SLLNode<Integer> node, int x) {
        SLLNode beforeStart = null;
        SLLNode beforeEnd = null;
        SLLNode afterStart = null;
        SLLNode afterEnd = null;

        while (node != null) {
            SLLNode next = node.succ;
            node.succ = null;
            if (node.element < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.succ = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.succ = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.succ = afterStart;
        return beforeStart;

    }

    public static SLLNode<Integer> partition1(SLLNode<Integer> node, int x) {
        SLLNode<Integer> head = null;
        SLLNode<Integer> tail = null;
        while (node != null) {
            SLLNode<Integer> next = node.succ;
            if (node.element < x) {
                /* Insert node at head. */
                node.succ = head;
                head = node;
            } else {
                node.succ = tail;
                tail = node;
            }
            node = next;
        }
        tail.succ = node;
        return head;
    }

    public static void main(String[] args) {


    }
}
