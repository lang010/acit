
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
        long[] ls = new long[10010];
        ls[0] = 1;
        for (int i = 1; i < 10001; i++) {
            ls[i] = ls[i-1]*i;
            while (ls[i]%10 == 0) {
                ls[i] /= 10;
            }
            ls[i] = ls[i] % 100000000;
        }
        int id;
        while (in.hasNext()) {
            id = in.nextInt();
            out.printf("%5d -> %d%n", id, ls[id]%10);
            out.flush();
        }
    }

}
