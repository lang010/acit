/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 594
 *  UVa link: http://uva.onlinejudge.org/external/5/594.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 27 14:31:51 2014
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
        int x = 0;
        int y = 0;
        while (sc.hasNextInt()) {
            x = sc.nextInt();
            pw.printf("%d", x);
            y = 0;
            for (int i = 0; i < 4; i++) {
                y = (y<<8) + (x & ((1<<8) - 1));
                x = x>>8;
            }

            pw.printf(" converts to %d\n", y);
        }

    }

}
