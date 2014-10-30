
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
	int n = in.nextInt();
	for (int i = 0; i < n ; i++) {
	    int x = in.nextInt();
	    //System.out.println(x);
	    if (x == 0) {
		out.printf("3%n");
	    } else {
		if (x < 0)
		    x = -x;
		int r = (int)Math.sqrt(x*2);

		while (true) {
		    int y = r * (r+1)/2 -x;
		    if (y >= 0 && y%2 == 0)
			break;
		    r++;
		}
		out.printf("%d%n", r);
	    }

	    if (i < n-1)
		out.println();
	    out.flush();
	}
    }

}
