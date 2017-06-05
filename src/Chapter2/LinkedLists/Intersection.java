package Chapter2.LinkedLists;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 */
public class Intersection {
    public static SLLNode<Intersection> findIntersection(SLLNode<Integer> list1, SLLNode<Integer> list2) {
        if (list1 == null && list2 == null) return null;
        /* Get tail and sizes*/
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        SLLNode shorter = result1.size < result2.size ? list1 : list2;
        SLLNode longer = result1.size < result2.size ? list2 : list1;

        /* Advance the pointer for the longer linked list by difference in lengths. */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter.succ;
            longer = longer.succ;
        }
        /* Return either one. */
        return longer;
    }

    private static SLLNode getKthNode(SLLNode head, int k) {
        SLLNode current = head;
        while (k > 0 && current != null) {
            current = current.succ;
            k--;
        }
        return current;
    }

    private static Result getTailAndSize(SLLNode<Integer> list) {
        if (list == null) return null;
        int size = 1;
        SLLNode current = list;
        while (current.succ != null) {
            size++;
            current = current.succ;
        }
        return new Result(current, size);
    }

    static class Result {
        public SLLNode<Integer> tail;
        public int size;

        public Result(SLLNode<Integer> tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}
