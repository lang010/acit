/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10082
 *  UVa link: http://uva.onlinejudge.org/external/100/10082.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 24 12:21:10 2014
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

    String s1 = "'1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
    String s2 = "1234567890-= WERTYUIOP[]\\ SDFGHJKL;' XCVBNM,./";

    void run() {
        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    pw.printf(" ");
                    continue;
                }
                int id = s2.indexOf(c);
                pw.printf("%c", s1.charAt(id));
            }
            pw.println();
        }

    }

}
