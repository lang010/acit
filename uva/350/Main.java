
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

    void run() {
        int Z, I, M, L;
        int cnt;
        int n = 0;
        while (in.hasNext()) {
            n++;
            Z = in.nextInt();
            I = in.nextInt();
            M = in.nextInt();
            L = in.nextInt();
            if (Z == 0 && I == 0 && M == 0 && L == 0)
                break;
            int[] ls = new int[10009];
            cnt = 1;
            while (true) {
                if (ls[L] > 0) {
                    cnt = cnt - ls[L];
                    break;
                }
                ls[L] = cnt++;
                L = (Z*L + I) % M;
            }
            out.printf("Case %d: %d%n", n, cnt);
        }
    }

}
