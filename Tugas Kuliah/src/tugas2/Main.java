package tugas2;

import java.util.LinkedList;

public class Main {

    static LinkedList<Object> li = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("\n===========================================================================\n");
        li.add(1);
        li.add(2);
        li.add(3.5);
        li.add(4.5);
        li.add(5.5f);
        li.add(6.5f);
        li.add('e');
        li.add('f');
        li.add("fito");
        li.add("dimas");
        System.out.println("Isi Linked List Saat Ini: " + li);
        System.out.println("\n===========================================================================\n");
        li = reverseLinkedList();
        System.out.println("Isi Linked List Saat Ini: " + li);
        System.out.println("\n===========================================================================\n");
        addData(1);
        addData("prasetyo");
    }

    static LinkedList<Object> reverseLinkedList() {
        LinkedList<Object> revLinkedList = new LinkedList<>();
        for (int i = li.size() - 1; i >= 0; i--) {
            revLinkedList.add(li.get(i));
        }
        return revLinkedList;
    }

    static void addData(Object ob) {
        if (li.contains(ob)) {
            System.out.println("Data sudah ada dalam LinkedList");
            System.out.println("\n===========================================================================\n");
            System.out.println("Isi Linked List Saat Ini: " + li);
            System.out.println("\n===========================================================================\n");
        } else {
            li.add(ob);
            System.out.println("Data berhasil ditambahkan ke dalam LinkedList");
            System.out.println("\n===========================================================================\n");
            System.out.println("Isi Linked List Saat Ini: " + li);
            System.out.println("\n===========================================================================\n");
        }
    }
}
