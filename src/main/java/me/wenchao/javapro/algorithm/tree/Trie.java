package me.wenchao.javapro.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 18:41 2018/8/6
 * @DESC
 */
public class Trie {
    Node root;
    private class Node{
        private int count;
        private char content;
        private List<Node> chileNodes;
        private Node(char c){
            this.content = c;
            this.count = 0;
            this.chileNodes = new LinkedList<>();
        }

        public Node childNode(char c) {
            if (chileNodes == null) {
                return null;
            }
            for (Node chileNode : chileNodes) {
                if (chileNode.content == c) {
                    return chileNode;
                }
            }
            return null;
        }
    }

    public Trie() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        Node current = root;
        if(!search(word))
            return;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node nextNode = current.childNode(c);
            if (nextNode == null) {
                Node newNode = new Node(c);
                current.chileNodes.add(newNode);
                current = newNode;


            }else{
                current = nextNode;
            }

        }
        current.count++;
    }

    private boolean search(String word) {
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("wen");
        trie.insert("we");
        System.out.println("hh");
    }
}
