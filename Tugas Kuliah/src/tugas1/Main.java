package tugas1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n===========================================================================\n");

        LinkedList<Integer> lk1 = new LinkedList<>();
        System.out.println(lk1);

        System.out.println("\n===========================================================================\n");

        try {
            lk1.add(9, 1);
            System.out.println(lk1);
        } catch (Exception e) {
            System.out.println("Belum ada node di dalam link list");
        }

        System.out.println("\n===========================================================================\n");

        lk1.addFirst(1);
        System.out.println(lk1);

        System.out.println("\n===========================================================================\n");

        lk1.add(2);
        System.out.println(lk1);

        System.out.println("\n===========================================================================\n");

        lk1.addLast(3);
        System.out.println(lk1);

        System.out.println("\n===========================================================================\n");

        lk1.add(4);
        System.out.println(lk1);

        System.out.println("\n===========================================================================\n");

        lk1.addFirst(5);
        System.out.println(lk1);

        System.out.println("\n===========================================================================\n");

        lk1.add(1, 6);
        System.out.println(lk1);

        System.out.println("\n===========================================================================\n");

    }
}
