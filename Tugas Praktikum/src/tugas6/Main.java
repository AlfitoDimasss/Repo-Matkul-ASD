package tugas6;

import java.util.*;

class Node1 {
    int data;
    List<Node1> childs;
    Node1 parent;

    public Node1(int data) {
        this.data = data;
        this.childs = new LinkedList<>();
    }
}

class Tree1 {
    Node1 root;

    public Tree1(Node1 root) {
        this.root = root;
    }

    public Tree1(int data) {
        root = new Node1(data);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Node1 getNode(Node1 node, int data) {
        if (node.data == data) {
            return node;
        }

        for (Object currNode : node.childs) {
            Node1 returnNode = getNode((Node1) currNode, data);
            if (returnNode != null) {
                return returnNode;
            }
        }
        return null;
    }

    public void add(int dataParent, int data) {
        Node1 node = getNode(root, dataParent);
        if (node != null) {
            Node1 child = new Node1(data);
            node.childs.add(child);
            child.parent = node;
        }
        // } else {
        // System.out.println("Node Parent Tidak Ditemukan");
        // }
    }

    private void access(Node1 node, String space) {
        System.out.println("");
        for (Object currNode : node.childs) {
            System.out.print(space + "->" + ((Node1) currNode).data);
            access((Node1) currNode, space + " ");
        }
        return;
    }

    public void access() {
        System.out.print(root.data);
        access(root, " ");
    }

    public void delete(int data) {
        if (root.data == data) {
            Node1 tmp = root.childs.get(0);
            for (int i = 1; i < root.childs.size(); i++) {
                root.childs.get(0).childs.add(root.childs.get(i));
            }
            tmp.parent = null;
            root = tmp;
        } else {
            Node1 node = getNode(root, data);
            if (node != null && node.childs == null) {
                Node1 parent = node.parent;
                parent.childs.remove(node);
            } else if (node != null) {
                for (int i = 0; i < node.childs.size(); i++) {
                    if (i == 0) {
                        node.parent.childs.add(node.childs.get(i));
                        node.childs.get(i).parent = node.parent;
                    } else {
                        node.parent.childs.get(node.parent.childs.size() - 1).childs.add(node.childs.get(i));
                        node.childs.get(i).parent = node.parent.childs.get(node.parent.childs.size() - 1);
                    }
                }
                Node1 parent = node.parent;
                parent.childs.remove(node);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        int root = io.nextInt();
        Node1 nd = new Node1(root);
        Tree1 tr = new Tree1(nd);
        for (int i = 0; i < n; i++) {
            String cmd = io.next();
            if (cmd.equalsIgnoreCase("TAMBAH")) {
                int parent = io.nextInt();
                int child = io.nextInt();
                tr.add(parent, child);
            } else if (cmd.equalsIgnoreCase("HAPUS")) {
                int data = io.nextInt();
                tr.delete(data);
            }
        }
        io.close();
        levelOrder(tr.root);
    }

    public static void levelOrder(Node1 root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return;
        }
        Queue<Node1> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> NodesAtOneLevel = new ArrayList<>();
            while (size-- > 0) {
                Node1 head = qu.poll();
                NodesAtOneLevel.add(head.data);
                for (Node1 child : head.childs) {
                    qu.offer(child);
                }
            }
            ans.add(NodesAtOneLevel);
        }
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
        }
    }
}
