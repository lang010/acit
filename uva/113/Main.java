
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
	while (in.hasNext()) {
	    double d1 = in.nextDouble();
	    double d2 = in.nextDouble();
	    out.printf("%.0f%n", Math.pow(d2, 1/d1));
	    out.flush();
	}
    }

}
