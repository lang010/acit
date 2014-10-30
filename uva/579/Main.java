
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
        while (in.hasNext()) {
            String s = in.next();
            if ("0:00".equals(s))
                break;
            String[] ls = s.split(":");
            int h = Integer.valueOf(ls[0]);
            int m = Integer.valueOf(ls[1]);
            double x = h * 30 + m * 0.5 - m * 6;
            if (x < 0)
                x = -x;
            if (x>180)
                x = 360 - x;
            //out.println(h + " : " + m);
            out.printf("%.3f%n", x);
            //out.flush();
        }
    }

}
