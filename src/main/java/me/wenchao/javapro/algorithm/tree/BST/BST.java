package me.wenchao.javapro.algorithm.tree.BST;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author wenchaofu
 * @DATE 16:20 2018/8/5
 * @DESC
 */
public class BST<K extends Comparable<K>, V> {


    private int count;
    private Node root;


    public BST() {
        this.root = null;
        this.count = 0;
    }

    public void change(K key, V value) {
        change(root, key, value);
    }

    private void change(Node root, K key, V value) {
        if (search(key) == null) {
            return;
        }
        if (root.key.compareTo(key) > 0) {
            change(root.left, key, value);
        } else if (root.key.compareTo(key) < 0) {
            change(root.right, key, value);
        } else {
            root.value = value;
        }

    }


    private class Node {
        private K key;
        private V value;
        Node left;
        Node right;


        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "[" +String.valueOf(this.value) + "]";
        }
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 向以node为根的二叉搜索树中,插入节点(key, value)
    public boolean contain(K key) {
        return contain(root, key);
    }

    private boolean contain(Node root, K key) {
        if (root == null) {
            return false;
        }
        if (root.key.compareTo(key) == 0) {
            return true;

        } else if (root.key.compareTo(key) > 0) {
            return contain(root.left, key);
        } else {
            return contain(root.right, key);
        }
    }

    public V search(K key) {
        return search(root, key);
    }

    private V search(Node root, K key) {
        if (root == null) {
            return null; // 没有找到
        }
        if (root.key.compareTo(key) == 0)
            return root.value;
        else if (root.key.compareTo(key) > 0) {
            return search(root.left, key);

        } else {
            return search(root.right, key);
        }
    }

    // 搜索的非递归版本
    private V search2(Node root, K key) {
        Node node = root;
        while (node.key.compareTo(key) != 0) {
            int comp = node.key.compareTo(key);
            if (comp > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            if (node == null) {
                return null;
            }
        }
        return node.value;
    }

    public void insert(K key, V value) {
        root = insert2(root, key, value);
    }

    // // 向以node为根的二叉搜索树中,插入节点(key, value)
    // 返回插入新节点后的二叉搜索树的根
    private Node insert(Node root, K key, V value) {
        if (root == null) {
            count++;
            return new Node(key, value);
        }
        if (root.key.compareTo(key) == 0) {
            root.value = value;
        } else if (root.key.compareTo(key) > 0) {
            root.left = insert(root.left, key, value);
        } else {
            root.right = insert(root.right, key, value);
        }
        return root;
    }

    // 返回跟节点
    private Node insert2(Node root, K key, V value) {
        Node node = root;
        Node newNode = new Node(key, value);
        if (node == null) {
            count++;
            return newNode;
        }
        while (node != null) {
            int comp = node.key.compareTo(key);
            if (comp == 0) {
                node.value = value;
                return root;
            } else if (comp > 0) {
                if (node.left == null) {
                    node.left = newNode;
                    count++;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = newNode;
                    count++;
                } else {
                    node = node.right;
                }
            }
        }
        return root;

    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        if (root != null) {
            queue.offer(root);  // 增加一个元素，满返回fals
        }
        while (!queue.isEmpty()) {
            Node pop = queue.poll(); // 移除并返回头部元素
            System.out.println(pop.value);
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }


        }
    }

    // min
    public K getMin() {
        if (count == 0) {
            return null;
        }
        return getMin(root);

    }

    private K getMin(Node root) {
        if (root.left == null) {
            return root.key;
        }
        return getMin(root.left);
    }

    private K getMin2(Node root) {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    // max
    public K getMax() {
        if (count == 0) {
            return null;
        }
        return getMax2(root);
    }

    private K getMax(Node root) {
        if (root.right == null) {
            return root.key;
        }
        return getMax(root.right);
    }

    private K getMax2(Node root) {
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.key;
    }
    // remove Min

    // 返回删除节点后新的二分搜索树的根
    public K removeMin() {
        if (root != null) {
            root = removeMin2(root);
            return root.key;
        }
        return null;
    }

    // 返回删除节点后新的二分搜索树的根
    // 递归
    private Node removeMin(Node root) {
        if (root.left == null) {
            Node right = root.right;
            count--;
            return right;
        }
        root.left = removeMin(root.left);
        return root;
    }

    // 非递归
    private Node removeMin2(Node root) {
        Node node = root;
        Node parent = null;
        while (node.left != null) {
            parent = node;
            node = node.left;
        }
        parent.left = node.right;
        return root;
    }


    public Node removeMax() {
        if (count == 0) {
            return null;
        }
        return removeMax(root);
    }

    // 返回树根
    private Node removeMax(Node root) {
        if (root.right == null) {
            Node left = root.left;
            count--;
            return left;

        }
        root.right = removeMax(root.right);
        return root;
    }

    public Node removeNode(K key) {
        return removeNode(root, key);
    }

    private Node removeNode(Node root, K key) {
        if (root == null) {
            return null;
        }

        int comp = root.key.compareTo(key);
        if (comp > 0) {
            root.left = removeNode(root.left, key);
        } else if (comp < 0) {
            root.right = removeNode(root.right, key);
        } else { // 删除节点
            if (root.left == null) { // 删除节点的左子树为空
                root = root.right;
                return root;
            } else if (root.right == null) { // 右子树为空
                root = root.left;
                return root;
            }
            // 左右都不为空
            K delK = getMin(root.right);
            V delV = search(delK);
            Node delNode = new Node(delK, delV);
            delNode.right = removeMin(root.right);
            delNode.left = root.left;
            count--;
            return delNode;


        }
        return null;
    }

    public void print(){
        print(root);
    }
    private  void print(Node root) {
        // 找到左边的最大偏移量
        int maxLeftOffset = findMaxOffset(root, 0, true);
        int maxRightOffset = findMaxOffset(root, 0, false);
        int offset = Math.max(maxLeftOffset, maxRightOffset);
        // 计算最大偏移量
        Map<Integer, PrintLine> lineMap = new HashMap();
        calculateLines(root, offset, lineMap, 0, true);
        Iterator<Integer> lineNumbers = lineMap.keySet().iterator();
        int maxLine = 0;
        while (lineNumbers.hasNext()) {
            int lineNumber = lineNumbers.next();
            if (lineNumber > maxLine) {
                maxLine = lineNumber;
            }
        }
        for (int i = 0; i <= maxLine; i++) {
            PrintLine line = lineMap.get(i);
            if (line != null) {
                System.out.println(line.getLineString());
            }
        }

    }

    private void calculateLines(Node parent, int offset, Map<Integer, PrintLine> lineMap, int level,
                                       boolean right) {
        if (parent == null) {
            return;
        }
        int nameoffset = parent.toString().length() / 2  ;
        PrintLine line = lineMap.get(level);
        if (line == null) {
            line = new PrintLine();
            lineMap.put(level, line);
        }
        line.putString(right ? offset : (offset - nameoffset), parent.toString());
        // 判断有没有下一级
        if (parent.left == null && parent.right == null) {
            return;
        }
        // 如果有，添加分割线即/\
        PrintLine separateLine = lineMap.get(level + 1);
        if (separateLine == null) {
            separateLine = new PrintLine();
            lineMap.put(level + 1, separateLine);
        }
        if (parent.left != null) {
            separateLine.putString(offset - 1, "/");
            calculateLines(parent.left, offset - nameoffset - 2, lineMap, level + 2, false);
        }
        if (parent.right != null) {
            separateLine.putString(offset + nameoffset + 1, "\\");
            calculateLines(parent.right, offset + nameoffset + 3, lineMap, level + 2, true);
        }

    }

    /**
     * 需要打印的某一行
     *
     * @author zhuguohui
     */
    private static class PrintLine {
        /**
         * 记录了offset和String的map
         */
        Map<Integer, String> printItemsMap = new HashMap<>();
        int maxOffset = 0;

        public void putString(int offset, String info) {
            printItemsMap.put(offset, info);
            if (offset > maxOffset) {
                maxOffset = offset;
            }
        }

        public String getLineString() {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i <= maxOffset; i++) {
                String info = printItemsMap.get(i);
                if (info == null) {
                    buffer.append(" ");
                } else {
                    buffer.append(info);
                    i += info.length();
                }
            }
            return buffer.toString();
        }

    }

    private  int findMaxOffset(Node parent, int offset, boolean findLeft) {
        if (parent != null) {
            offset += parent.toString().length();
        }
        if (findLeft && parent.left != null) {
            offset += 1;
            return findMaxOffset(parent.left, offset, findLeft);
        }
        if (!findLeft && parent.right != null) {
            return findMaxOffset(parent.right, offset, findLeft);
        }
        return offset;
    }

}
