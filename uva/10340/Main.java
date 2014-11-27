/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10340
 *  UVa link: http://uva.onlinejudge.org/external/103/10340.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 23:14:37 2014
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
        int i, j;
        String s, t;
        while (sc.hasNext()) {
            s = sc.next();
            t = sc.next();
            i = 0;
            j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            if (i < s.length()) {
                pw.println("No");
            } else {
                pw.println("Yes");
            }
        }

    }

}
