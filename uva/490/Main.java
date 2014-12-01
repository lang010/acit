/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 490
 *  UVa link: http://uva.onlinejudge.org/external/4/490.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 30 17:58:28 2014
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

    String[] ls = new String[200];
    int n = 0;
    int max = 0;

    void run() {
        while (sc.hasNext()) {
            ls[n++] = sc.nextLine();
            if (ls[n-1].length() > max) {
                max = ls[n-1].length();
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = n-1; j >= 0; j--) {
                if (i<ls[j].length()) {
                    pw.printf("%c", ls[j].charAt(i));
                } else {
                    pw.printf(" ");
                }

            }
            pw.println();
        }

    }

}
