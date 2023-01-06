package tugas2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<>();
        Scanner io = new Scanner(System.in);
        int n = io.nextInt();
        for (int i = 0; i < n; i++) {
            int val = io.nextInt();
            if (li.size() == 0) {
                li.add(val);
            } else {
                if (val > li.getLast() && val % 2 == 0) {
                    li.addLast(val);
                } else if (val < li.getFirst() && val % 2 == 1) {
                    li.addFirst(val);
                } else if (val > li.getFirst() && val < li.getLast()) {
                    li.add(li.size() / 2, val);
                }
            }
        }
        io.close();
        for (int i = 0; i < li.size(); i++) {
            System.out.print(li.get(i) + " ");
        }
    }
}
