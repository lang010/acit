
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.File;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }
    int n = 0;
    int[][] ls = new int[50][50];

    void returnAbove(int ai, int aj) {
        while (ls[ai][n] > aj + 1) {
            ls[ai][n]--;
            int id = ls[ai][ls[ai][n]];
            ls[id][ls[id][n]] = id;
            ls[id][n]++;
        }

    }

    void move(int ai, int aj, int bi, int bj) {
        for (int i = aj; i < ls[ai][n]; i++) {
            ls[bi][ls[bi][n]] = ls[ai][i];
            ls[bi][n]++;
        }
        ls[ai][n] = aj;
    }

    void run() {

        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            ls[i][0] = i;
            ls[i][n] = 1;
        }
        in.nextLine();
        while (true) {
            String s = in.nextLine();
            if ("quit".equals(s)) {
                break;
            }
            String[] sl = s.split(" ");
            int a = Integer.valueOf(sl[1]);
            int b = Integer.valueOf(sl[3]);

            if (a == b)
                continue;
            int ai = 0, aj = 0;
            int bi = 0, bj = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < ls[i][n]; j++) {
                    if (ls[i][j] == a) {
                        ai = i;
                        aj = j;
                    } else if (ls[i][j] == b) {
                        bi = i;
                        bj = j;
                    }
                }
            }
            if (ai == bi) {
                continue;
            }

            if ("move".equals(sl[0])) {
                returnAbove(ai, aj);
            }
            if ("onto".equals(sl[2])) {
                returnAbove(bi, bj);
            }
            move(ai, aj, bi, bj);

        }
        for (int i = 0; i < n; i++) {
            out.printf("%d:", i);
            for (int j = 0; j < ls[i][n]; j++) {
                out.printf(" " + ls[i][j]);
            }
            out.println();
        }
    }

}
