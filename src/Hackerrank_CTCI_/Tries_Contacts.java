package Hackerrank_CTCI_;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hnastevska on 7/27/2017.
 */
public class Tries_Contacts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String operation = scan.next();
            String contact = scan.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        scan.close();
    }
}

/* Based loosely on tutorial video in this problem */
class Node {
    public int size;
    private HashMap<Character, Node> children = new HashMap<>();

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new Node());
    }

    public Node getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    Node root = new Node();

    Trie() {
    } // default constructor

    Trie(String[] words) {
        for (String word : words) {
            add(word);
        }
    }

    public void add(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        Node curr = root;

        /* Traverse down tree to end of our prefix */
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}

