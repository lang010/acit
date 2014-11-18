/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10696
 *  UVa link: http://uva.onlinejudge.org/external/106/10696.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 17 00:30:45 2014
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
        int n;
        int f;
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            if (n < 102) {
                f = 91;
            } else {
                f = n - 10;
            }

            pw.printf("f91(%d) = %d%n", n, f);
        }

    }

}
