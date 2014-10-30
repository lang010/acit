
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }
    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() throws Exception {
	in.close();
	out.close();
    }

    void run() throws Exception {
        int n;
        String s;
        int b;
        int f1, f2;
        String[] ls;
        while (true) {
            s = in.readLine();
            if (s == null || s.length() < 1)
                break;
            b = Integer.valueOf(s);
            s = in.readLine();
            ls = s.split(" ");
            n = ls.length;

            out.printf("q(x):");

            f1 = Integer.parseInt(ls[0]);
            for (int i = 1; i < n ; i++) {
                f2 = Integer.parseInt(ls[i]);
                f2 = f2 + f1 * b;
                out.printf(" " + f1);
                f1 = f2;
            }

            out.printf("%nr = %d%n%n", f1);
            //out.flush();
        }
    }

}
