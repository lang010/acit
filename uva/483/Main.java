/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 483
 *  UVa link: http://uva.onlinejudge.org/external/4/483.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 19 21:46:57 2014
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
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] ls = s.split(" ", -1);
            for (int i = 0; i < ls.length; i++) {
                if (i>0) {
                    pw.printf(" ");
                }
                int len = ls[i].length();
                for (int j = 0; j < len; j++) {
                    pw.printf("%c", ls[i].charAt(len-j-1));
                }
            }
            pw.println();
        }

    }

}
