
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
        long n, x;
        while (in.hasNext()) {
            n = in.nextLong();
            if (n == 0)
                break;
            x = (long) Math.sqrt(n);
            if (x*x == n)
                out.println("yes");
            else
                out.println("no");
        }
    }

}
