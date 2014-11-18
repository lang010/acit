/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11172
 *  UVa link: http://uva.onlinejudge.org/external/111/11172.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 23:17:51 2014
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
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > b) {
                pw.println(">");
            } else if (a < b) {
                pw.println("<");
            } else {
                pw.println("=");
            }
        }

    }

}
