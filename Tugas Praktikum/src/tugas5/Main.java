package tugas5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int res = 0;
        int n = io.nextInt();
        Queue<Barang> q = new LinkedList<>();
        String s = io.next();
        String[] spt = s.split(",");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(spt[i]);
            Barang b = new Barang("x", a);
            q.add(b);
        }
        int y = io.nextInt();
        Barang c = new Barang("ira", y);
        q.add(c);
        while (!q.isEmpty()) {
            if (q.peek().getName().equalsIgnoreCase("ira") && q.peek().getNum() <= 2) {
                break;
            } else if (q.peek().getNum() <= 2) {
                res++;
                q.remove();
            } else if (q.peek().getNum() > 2 && q.peek().getName().equalsIgnoreCase("ira")) {
                int v = q.peek().getNum() - 2;
                q.remove();
                Barang x = new Barang("ira", v);
                q.add(x);
            } else if (q.peek().getNum() > 2) {
                res++;
                int v = q.peek().getNum() - 2;
                q.remove();
                Barang x = new Barang("x", v);
                q.add(x);
            }
        }
        System.out.println(res);
        io.close();
    }
}

class Barang {
    private String name;
    private int num;

    Barang(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return this.name;
    }

}
