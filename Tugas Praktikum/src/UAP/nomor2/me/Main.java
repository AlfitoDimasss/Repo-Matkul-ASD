package UAP.nomor2.me;

//Nama : Alfito Dimas Prasetyo
//NIM  : 205150401111057
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // HINT: gunakanlah Stack untuk menyelesaikan studi kasus ini
        Scanner input = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        String s = input.next();
        // boolean balance = true;// Boolean untuk mengecek apakah jumlah kurungnya
        // seimbang atau tidak
        int jumlah = 0;
        int jumlahBuka = 0;
        int jumlahTutup = 0;
        if (s.length() <= 20) {
            for (int i = 0; i < s.length(); i++) {
                /*
                 * Lakukan pengecekan terhadap satu per satu karakter dari string.
                 * Jika karakternya merupakan kurung buka, tambah ke stack.
                 * Jika karakternya kurung tutup, lakukan pengecekan dengan karakter paling atas
                 * di stack.
                 * 
                 * Jika karakternya sejenis dengan karakter paling atas, keluarkan karakter
                 * tersebut dari stack.
                 * Jika karakternya tidak sejenis, maka sudah pasti tidak seimbang.
                 */
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    st.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    char c = st.peek();
                    if (c == '(') {
                        st.pop();
                    }
                } else if (s.charAt(i) == ']') {
                    char c = st.peek();
                    if (c == '[') {
                        st.pop();
                    }
                } else if (s.charAt(i) == '}') {
                    char c = st.peek();
                    if (c == '{') {
                        st.pop();
                    }
                }
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                    jumlahBuka++;
                } else {
                    jumlahTutup++;
                }
            }

            if (jumlahBuka <= jumlahTutup) {
                jumlah = jumlahBuka;
            } else {
                jumlah = jumlahTutup;
            }

            if (st.empty()) {
                System.out.println("Seimbang " + jumlah);
            } else {
                System.out.println("Tidak Seimbang " + jumlah);
            }
            // Pastikan balance tetap true dan semua isi stack telah habis untuk mencetak
            // Seimbang
        }
        input.close();

    }
}
