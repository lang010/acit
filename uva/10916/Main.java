
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
        while (true) {
            int n = in.nextInt();
            if (n == 0)
                break;
            n = (n - 1940)/10;
            double k = Math.log(2) * Math.pow(2, n);
            double sum = 0;
            for (int i = 1; ; i++) {
                sum += Math.log(i);
                if (sum > k) {
                    out.println(i-1);
                    break;
                }
            }
        }
    }

}
