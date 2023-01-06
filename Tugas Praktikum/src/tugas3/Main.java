package tugas3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);
        LinkedList<Object> li = new LinkedList<>();
        int n = io.nextInt();
        for (int i = 0; i < n; i++) {
            String cmd = io.next();
            if (cmd.equalsIgnoreCase("TambahDiAwal")) {
                Object o = io.next();
                li.addFirst(o);
            } else if (cmd.equalsIgnoreCase("TambahDiAkhir")) {
                Object o = io.next();
                li.addLast(o);
            } else if (cmd.equalsIgnoreCase("TambahDiIndex")) {
                int a = io.nextInt();
                Object o = io.next();
                li.add(a, o);
            } else if (cmd.equalsIgnoreCase("HapusDiAwal")) {
                li.removeFirst();
            } else if (cmd.equalsIgnoreCase("HapusDiAkhir")) {
                li.removeLast();
            } else if (cmd.equalsIgnoreCase("HapusDiIndex")) {
                int a = io.nextInt();
                li.remove(a);
            }
        }
        for (int i = 0; i < li.size(); i++) {
            System.out.print(li.get(i) + " ");
        }
        io.close();
    }
}
