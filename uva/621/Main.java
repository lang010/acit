
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

    int get(String s) {
	if (s.equals("1") || s.equals("4") || s.equals("78"))
	    return 1;
	if (s.endsWith("35")) {
	    return 2;
	}
	if (s.startsWith("9") && s.endsWith("4"))
	    return 3;
	if (s.startsWith("190")) {
	    return 4;
	}
	return -1;
    }

    void run() {
	int n = in.nextInt();
	for (int i = 0; i < n ; i++) {
 
	    switch (get(in.next())) {
	    case 1:
		out.println("+");
		break;
	    case 2:
		out.println("-");
		break;
	    case 3:
		out.println("*");
		break;
	    case 4:
		out.println("?");
		break;
	    default:
		out.println();
	    }
	    out.flush();
	}
    }

}
