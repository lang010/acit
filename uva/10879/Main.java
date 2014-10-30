
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
        int cnt = (int) Math.sqrt(10000000);
        int N = 0;
        int[] ls = new int[100000];

        for(int i = 2; i < cnt + 2; i++ ) {
            if (ls[i] != 0)
                continue;
            for (int j = 2*i; j < cnt+2; j+= i) {
                ls[j] = 1;
            }
            ls[N++] = i;
        }

        cnt = in.nextInt();
        for (int i = 0; i < cnt; i++) {
            int K = in.nextInt();
            int n = 0;
            out.printf("Case #%d: %d", i+1, K);
            for (int j = 0; j < N; j++) {
                //out.println(ls[j]);
                if (K%ls[j] == 0) {
                    out.printf(" = %d * %d", ls[j], K/ls[j]);
                    n++;
                    if (n == 2)
                        break;
                    if (K%(ls[j]*ls[j]) == 0) {
                        out.printf(" = %d * %d", ls[j]*ls[j], K/ls[j]/ls[j]);
                        break;
                    }
                }
            }
            out.println();
        }
    }

}
