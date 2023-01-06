package UAP.uap2019;

import java.util.Scanner;

class Bst {
    class Node {
        int data;
        Node left, right;
        Node parent;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    void insert(int input) {
        root = add(root, input);
    }

    Node add(Node root, int input) {
        if (root == null) {
            root = new Node(input);
            return root;
        }
        if (root.data > input) {
            root.left = add(root.left, input);
            root.left.parent = root;
        } else if (root.data < input) {
            root.right = add(root.right, input);
            root.right.parent = root;
        }
        return root;
    }

    int findSecondLargest() {
        Node max = findLargest(root);
        if (max.left != null) {
            max = findLargest(max.left);
            return max.data;
        }
        return max.parent.data;
    }

    Node findLargest(Node root) {
        if (root.right != null) {
            root = findLargest(root.right);
            return root;
        }
        return root;
    }

    int findSecondSmallest() {
        Node min = findSmallest(root);
        if (min.right != null) {
            min = findSmallest(min.right);
            return min.data;
        }
        return min.parent.data;
    }

    Node findSmallest(Node root) {
        if (root.left != null) {
            root = findSmallest(root.left);
            return root;
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bst bst = new Bst();
        int perintah = in.nextInt();

        while (perintah-- > 0) {
            String jenis = in.next();

            if (jenis.equals("masuk")) {
                int angka = in.nextInt();
                bst.insert(angka);
            } else if (jenis.equals("kecilKedua")) {
                System.out.println(bst.findSecondSmallest());
            } else {
                System.out.println(bst.findSecondLargest());
            }
        }
        in.close();
    }
}