/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10921
 *  UVa link: http://uva.onlinejudge.org/external/109/10921.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 24 14:06:47 2014
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

    int[] ls = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};

    void run() {
        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c <= 'Z' && c >= 'A') {
                    pw.printf("%d", ls[c-'A']);
                } else {
                    pw.printf("%c", c);
                }
            }
            pw.println();
        }

    }

}
