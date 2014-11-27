/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10035
 *  UVa link: http://uva.onlinejudge.org/external/100/10035.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 22:25:17 2014
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
        long l, r;
        long rm, c;
        while (true) {
            l = sc.nextLong();
            r = sc.nextLong();
            if (l == 0 && r == 0) {
                break;
            }
            rm = 0;
            c = 0;
            while (l > 0 || r > 0) {
                rm = rm + l%10 + r%10;
                rm /= 10;
                r /= 10;
                l /= 10;
                if (rm>0) {
                    c++;
                }
            }
            if (c == 0) {
                pw.println("No carry operation.");
            } else if (c == 1) {
                pw.println("1 carry operation.");
            } else {
                pw.printf("%d carry operations.%n", c);
            }
        }

    }

}
