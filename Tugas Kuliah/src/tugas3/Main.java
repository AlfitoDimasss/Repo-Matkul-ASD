package tugas3;

import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;
    Node temp = root;

    BinaryTree(int value) {
        this.root = new Node(value);
    }

    BinaryTree(Node root) {
        this.root = root;
    }

    BinaryTree() {
        this.root = null;
    }

    private void insert(Node temp, int value) {
        if (temp == null) {
            this.root = new Node(value);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.left == null) {
                temp.left = new Node(value);
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(value);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    public void insert(int value) {
        insert(root, value);
    }

    private void access(Node node, String space, String child) {
        if (node == null) {
            return;
        }

        if (node != root) {
            System.out.println(space + "->" + child + node.value);
        } else {
            System.out.println(node.value);
        }

        access(node.left, space + " ", "(L)");
        access(node.right, space + " ", "(R)");
    }

    public void access() {
        access(root, " ", "");
    }

    private void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.value + " ");
    }

    private void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

    private void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void printPostorder() {
        printPostorder(root);
    }

    public void printInorder() {
        printInorder(root);
    }

    public void printPreorder() {
        printPreorder(root);
    }

    private void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            System.out.print(curr.value + " ");

        }
    }

    public void printLevelOrder() {
        levelOrder(root);
    }

}

public class Main {
    public static void main(String[] args) throws Exception {
        Node nd = new Node(1);
        BinaryTree bt = new BinaryTree(nd);
        bt.root.left = new Node(3);
        bt.root.right = new Node(7);
        bt.root.left.left = new Node(5);
        bt.root.left.left.left = new Node(4);
        bt.root.left.left.right = new Node(6);
        bt.root.right.left = new Node(8);
        bt.root.right.right = new Node(9);
        bt.root.right.right.right = new Node(10);
        bt.root.right.right.right.left = new Node(11);
        bt.root.right.right.right.right = new Node(12);

        // bt.root = new Node(15);
        // bt.root.left = new Node(8);
        // bt.root.right = new Node(20);
        // bt.root.left.left = new Node(2);
        // bt.root.left.right = new Node(11);
        // bt.root.left.left.right = new Node(6);
        // bt.root.left.left.right.left = new Node(3);
        // bt.root.left.left.right.right = new Node(7);
        // bt.root.left.right.left = new Node(10);
        // bt.root.left.right.right = new Node(12);
        // bt.root.left.right.right.right = new Node(14);
        // bt.root.right.right = new Node(27);
        // bt.root.right.right.left = new Node(22);
        // bt.root.right.right.right = new Node(30);

        System.out.print("Pre Order\t: ");
        bt.printPreorder();
        System.out.println("");
        System.out.print("In Order\t: ");
        bt.printInorder();
        System.out.println("");
        System.out.print("Post Order\t: ");
        bt.printPostorder();
        System.out.println("");
        System.out.print("Level Order\t: ");
        bt.printLevelOrder();
    }
}
