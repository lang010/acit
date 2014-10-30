
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
        int[] ls = new int[1000000];
        int cnt = 0;
        boolean t = false;
        for (int i = 2; i < 1000000; i++) {
            if (ls[i] != 0)
                continue;
            ls[cnt] = i;
            cnt++;
            for (int k = 2*i; k < 1000000; k+=i) {
                ls[k] = 1;
            }
        }
        while (in.hasNext()) {
            long x = in.nextLong();
            if (x < 0)
                break;
            for (int i = 0; i < cnt; i++) {
                if (x % ls[i] == 0) {
                    x = x / ls[i];
                    out.println("    " + ls[i]);
                    i--;
                    if (x == 1)
                        break;
                }
            }
            if (x > 1) {
                out.println("    " + x);
            }
            out.println();
        }

    }

}
