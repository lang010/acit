
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
        double h, u, d, f;
        int cnt;
        while (true) {
            h = in.nextInt();
            u = in.nextInt();
            d = in.nextInt();
            f = in.nextInt();
            if (h < 1) {
                break;
            }
            f = u * f / 100;
            double hh = 0;
            cnt = 1;
            while (true) {
                if (u>0)
                    hh += u;
                u = u -f;
                if (hh > h) {
                    break;
                }
                hh -= d;
                if (hh < 0) {
                    break;
                }
                cnt++;
            }

            if (hh >= h) {
                out.println("success on day " + cnt);
            } else {
                out.println("failure on day " + cnt);
            }

            out.flush();
        }
    }
            
}
