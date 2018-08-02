package me.wenchao.javapro.algorithm.sort;

/**
 * @Author wenchaofu
 * @DATE 17:34 2018/7/4
 * @DESC
 */
public class MergeList {


    private static class Node {
        Node next = null;
        int data;
        public Node(int data){
            this.data = data;
        }

    }

    public static void main(String[] args) {

        Node head1 = genList(1,3,5,9);
        printNodeList(head1);
        System.out.println("after reverse...");
        printNodeList(reverse(head1));
        System.out.println("======");
        Node head2 = genList(2,4,6,7,8);
        printNodeList(head2);
        System.out.println("======");
        Node headAll = mergeList(head1, head2);
        printNodeList(headAll);

    }

    private static Node mergeList(Node head1, Node head2) {
        Node head = null;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data < head2.data) {
            head = head1;
            head.next = mergeList(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeList(head1, head2.next);
        }
        return head;

    }

    private static void printNodeList(Node headNode) {
        while (headNode != null) {
            System.out.print(headNode.data + "   ");
            headNode = headNode.next;

        }

    }

    private static Node genList(int... arr) {
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
            head = addNode(head,new Node(arr[i]));

        }
        return head;
    }

    private static Node addNode(Node head,Node node) {
        if (head == null) {
            head = node;
            return head;
        }
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    private static Node reverse(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            return head;

        }
        // 先反转后续节点head.getNext()
        Node rehead = reverse(head.next);
        // 将当前结点的指针域指向前一结点
        head.next.next = head;
        // 前一结点的指针域令为null;
        head.next = null;
        return rehead;
    }
}
