package UAP.nomor1;

//Nama : Alfito Dimas Prasetyo
//NIM  : 205150401111057
import java.util.*;

public class Main {
    // DILARANG MENGUBAH BAGIAN INI
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Tree<Integer> tree = new Tree<>();
        LinkedList<Integer> temp = new LinkedList<>();
        // int count = 0;
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            temp.addLast(a);
            if (tree.isEmpty()) {
                tree = new Tree<>(a);
            } else {
                int j = 0;
                boolean masuk;
                do {
                    masuk = tree.add(temp.get(j), a);
                    j++;
                } while (!masuk && j < temp.size());
            }
        }
        int t = input.nextInt();
        System.out.println("Banyak child dari node " + t + ": " + tree.hitungChild(t));
        System.out.println("Banyak descendant dari node " + t + ": " + tree.hitungDescendant(t));
        input.close();
    }
}

// DILARANG MENGUBAH BAGIAN INI
class Node<T> {
    T data;
    List<Node<T>> childs;

    public Node(T data) {
        this.data = data;
        childs = new LinkedList<Node<T>>();
    }
}

class Tree<T> {
    // DILARANG MENGUBAH BAGIAN INI
    Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Tree(T data) {
        root = new Node<T>(data);
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Method untuk mencari node berdasarkan datanya. DILARANG MENGUBAH BAGIAN INI
    @SuppressWarnings("unchecked")
    public Node<T> getNode(Node<T> node, T data) {
        if (node.data == data)
            return node;

        for (Object currNode : node.childs) {
            Node<T> returnNode = getNode((Node<T>) currNode, data);
            if (returnNode != null)
                return returnNode;
        }
        return null;
    }

    public boolean add(T dataParent, T data) {
        Node<T> node = getNode(root, dataParent);
        int jumlahDataChild = 0;
        if (node != null) {
            /*
             * Hitung jumlah data dengan melakukan looping semua
             * child dari variabel node. Jika jumlahnya <= data node * 2,
             * maka tambah data tersebut menjadi child dari node.
             * 
             * Jika berhasil ditambahkan menjadi child, return true
             * 
             * HINT: gunakan casting ke int agar tidak error
             */
            for (int i = 0; i < node.childs.size(); i++) {
                jumlahDataChild += (int) node.childs.get(i).data;
            }
            if ((jumlahDataChild + (int) data) <= ((int) node.data * 2)) {
                node.childs.add(new Node<T>(data));
                return true;
            }
        }
        return false;
    }

    public int hitungChild(T data) {
        /*
         * Cari node berdasarkan data yang diberikan.
         * Jika node null, kembalikan nilai 0.
         * Jika node tidak null, kembalikan ukuran dari childs
         */
        int jumlah = 0;
        Node<T> node = getNode(root, data);
        if (node != null) {
            jumlah += node.childs.size();
            return jumlah;
        }
        return jumlah;
    }

    public int hitungDescendant(T data) {
        /*
         * Cari node berdasarkan data yang diberikan.
         * Kemudian cari jumlah childnya.
         * Jika jumlah childnya 0, kembalikan nilai 0.
         * 
         * Jika jumlah childnya tidak 0, lakukan rekursif dari method ini
         * terhadap tiap child dari node, kemudian ditambahkan ke variabel
         * yang menyimpan jumlah childnya.
         * Terakhir, kembalikan variabel tersebut.
         */
        int jumlah = 0;
        Node<T> node = getNode(root, data);
        if (node != null) {
            jumlah += node.childs.size();
            for (int i = 0; i < node.childs.size(); i++) {
                jumlah += hitungDescendant((T) node.childs.get(i).data);
            }
        }
        return jumlah;
    }

}
