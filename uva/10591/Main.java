/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10591
 *  UVa link: http://uva.onlinejudge.org/external/105/10591.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  4 21:53:45 2014
 */
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {
    Scanner sc = new Scanner(System.in, "ISO-8859-1");
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.run();
        m.release();
    }
    void release() {
        sc.close();
        pw.close();
    }

    void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            long x = n;
            while (x >= 10) {
                long s = 0;
                while (x>0) {
                    s += (x%10)*(x%10);
                    x /= 10;
                }
                x = s;
                //pw.printf("%d %d%n", x, n);
                //pw.flush();
                if (x == n) {
                    break;
                }
            }
            pw.printf("Case #%d: %d ", i, n);
            if (x == 1 || x == 7) {
                pw.println("is a Happy number.");
            } else {
                pw.println("is an Unhappy number.");
            }
            pw.flush();
        }

    }

}
