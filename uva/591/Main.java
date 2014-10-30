
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
	    int n = in.nextInt();
	    if (n == 0)
		break;
	    cnt++;
	    int[] ls = new int[n];
	    int sum = 0;
	    for (int i = 0; i < n; i++) {
		ls[i] = in.nextInt();
		sum += ls[i];
	    }
	    sum = sum/n;
	    int r = 0;
	    for (int i = 0; i < n; i++) {
		if (ls[i] > sum)
		    r = r + ls[i] - sum;
	    }
	    out.println("Set #" + cnt);
	    out.printf("The minimum number of moves is %d.%n", r);
	    out.println();
	    out.flush();
	}
    }

}
