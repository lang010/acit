
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
        int cnt = 0;
	while (true) {
            cnt++;
            long a = in.nextInt();
            long b = in.nextInt();
            if (a == 0 && b == 0) {
                break;
            }

            out.printf("Case %d: %d%n", cnt, (a*(a-1)/2) * (b*(b-1)/2));
            //out.flush();
        }
    }

}
