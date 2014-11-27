/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10222
 *  UVa link: http://uva.onlinejudge.org/external/102/10222.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 25 23:58:31 2014
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

    String s1 = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";

    void run() {
        while (sc.hasNext()) {
            String s = sc.nextLine().toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int id = s1.indexOf(c);
                if (id>1) {
                    pw.printf("%c", s1.charAt(id-2));
                } else {
                    pw.printf(" ");
                }
            }
            pw.println();
        }

    }

}
