package Chapter2.LinkedLists;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C - > D -> E -> C [the same C as earlier)
 * Output: C
 */
public class LoopDetection {

    SLLNode<Integer> findBegining(SLLNode<Integer> head) {
        SLLNode<Integer> slow = head;
        SLLNode<Integer> fast = head;

        /*Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
        while (fast != null && fast.succ != null) {
            slow = slow.succ;
            fast = fast.succ.succ;
            if (slow == fast) { // Collision point
                break;
            }
        }
        /*Error check - no meeting point, and therefore no loop*/
        if (fast == null || fast.succ == null) return null;

        /*
          Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
          Loop Start. If they move at the same pace, they must meet at Loop Start.
         */
        slow = head;
        while (slow != fast) {
            slow = slow.succ;
            fast = fast.succ;
        }
        /*Both now point to the start of the loop */
        return fast;
    }

}

