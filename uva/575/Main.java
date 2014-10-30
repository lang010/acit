
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
            if ("0".equals(s))
                break;
            int r = 0;
            for (int i = 0; i < s.length(); i++) {
                r += ((s.charAt(s.length()-i-1)) - '0') * ((1<<(i+1))-1);
            }
            out.println(r);
        }
    }

}
