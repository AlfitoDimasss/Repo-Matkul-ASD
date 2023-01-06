package UAP.nomor2.other;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // HINT: gunakanlah Stack untuk menyelesaikan studi kasus ini
        Scanner scanner = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();
        int tmp1 = 0;
        // int tmp2 = 0;

        char[] input = scanner.nextLine().toCharArray();
        boolean balance = true;// Boolean untuk mengecek apakah jumlah kurungnya
        // seimbang atau tidak

        for (char bracket : input) {
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
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stack.push(bracket);
                // tmp2++;
            } else {
                if ((bracket == '}' || bracket == ']' || bracket == ')')
                        && stack.isEmpty()) {
                    balance = false;
                } else if ((bracket == '}' && stack.peek() == '{')
                        || (bracket == ']' && stack.peek() == '[')
                        || (bracket == ')' && stack.peek() == '(')) {
                    stack.pop();
                    tmp1++;
                } else {
                    break;
                }
            }
        }
        // Pastikan balance tetap true dan semua isi stack telah habis untuk mencetak
        // Seimbang
        if (stack.size() == 0 && balance) {
            System.out.println("Seimbang " + tmp1);
        } else {
            System.out.println(
                    "Tidak Seimbang " + (method(input, '{', '}') + method(input, '[', ']') + method(input, '(', ')')));
        }
        scanner.close();
    }

    public static int method(char[] haystck, char needleOpen, char needleClose) {
        int semua = 0;
        int semuaOpen = 0;
        int semuaBuka = 0;

        for (char check : haystck) {
            if (check == needleOpen) {
                semuaOpen++;
            }
            if (check == needleClose) {
                semuaBuka++;
            }
        }
        while (semuaOpen > 0 && semuaBuka > 0) {
            if (semuaOpen >= 1 && semuaBuka >= 1) {
                semua++;
                semuaOpen--;
                semuaBuka--;
            }
        }
        return semua;
    }
}