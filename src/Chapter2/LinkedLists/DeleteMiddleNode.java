package Chapter2.LinkedLists;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (Le., any node but
 * the fi rst and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a - >b- >c - >d - >e- >f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */
public class DeleteMiddleNode {

    public static boolean deleteNode(SLLNode<Integer> node) {
        if (node == null || node.succ == null) return false;
        SLLNode<Integer> deleteMe = node.succ;
        int element = deleteMe.element;
        node.element = element;
        node.succ = deleteMe.succ;
        return true;

    }

    public static void main(String[] args) {

    }
}
