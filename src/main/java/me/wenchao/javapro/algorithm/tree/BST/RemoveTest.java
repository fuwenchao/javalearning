package me.wenchao.javapro.algorithm.tree.BST;

import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 11:46 2018/8/6
 * @DESC
 */
public class RemoveTest {
    private static Random random = new Random();
    public static void main(String[] args) {
        BST<Integer,Integer> bst = new BST<>();
        bst.insert(10,10);
        bst.insert(9,9);
        bst.insert(14,14);
        for (int i = 0; i < 20; i++) {
            int value = random.nextInt(20);
            bst.insert(value,value);

        }
        bst.levelOrder();

        bst.print();

        System.out.println("min " + bst.removeNode(14));
        bst.levelOrder();
        bst.print();

    }
}
