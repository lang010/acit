/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10469
 *  UVa link: http://uva.onlinejudge.org/external/104/10469.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 21 20:28:03 2014
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
        long x = 0;
        long y = 0;
        while (sc.hasNext()) {
            x = sc.nextLong();
            y = sc.nextLong();
            pw.println(x^y);
        }

    }

}
