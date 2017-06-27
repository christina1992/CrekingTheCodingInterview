package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
 * and inserting each element. Given a binary search tree with distinct elements, print all possible
 * arrays that could have led to this tree.
 */
public class BST_Sequences {
    ArrayList<LinkedList<Integer>> allSequences(BNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add((Integer) node.info);


        //Recurse on left and right subtrees
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        //Weave together each list from the left and right sides
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveList(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    /*
        Weave lists together in all possible ways. This algorithm works by removing the
        head from one list, recursing, and then doing the same thing with the order
        list
     */
    private void weaveList(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        //One list is empty. Add remainder to [a cloned] prefix and store result
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
         /*
        Recurse with head of first added to the prefix. Removing the head will
        damage first, so we'll need to put it back where we found it afterwards
      */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveList(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        //Do the same thing with second, damaging and then restoring the list
        int headSEcond = second.removeFirst();
        prefix.addLast(headSEcond);
        weaveList(first,second,results,prefix);
        prefix.removeLast();
        second.addFirst(headSEcond);
    }


}
