
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
        int s;
        int a, b;
        while (in.hasNext()) {
            a = in.nextInt();
            b = in.nextInt();
            if (a < b) {
                s = a;
                a = b;
                b = s;
            }
            s = 0;
            if (a > 1) {
                s = a - 1;
            }
            if (b > 1) {
                s += (b-1) * a;
            }
            out.println(s);
        }
    }

}
