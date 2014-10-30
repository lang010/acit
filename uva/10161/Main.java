
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
	
	while (true) {
	    long n = in.nextInt();
	    if (n == 0)
		break;
	    long x = (long) Math.sqrt(n);
	    long y = n - x * x;
	    boolean f = false;
	    //out.printf("Test: %d, %d%n", x, y);
	    if (x%2 == 1)
		f = true;
	    if (y > 0)
		x++;
	    if (y > x) {
		n = y;
		y = x;
		x = x * 2 - n;
	    }
	    if (y == 0)
		y++;
	    
	    if (f) {
		n = y;
		y = x;
		x = n;
	    }
	    out.println(x + " " + y);
	    out.flush();
	}
    }

}
