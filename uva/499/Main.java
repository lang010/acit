/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 499
 *  UVa link: http://uva.onlinejudge.org/external/4/499.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 20 23:38:52 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

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

    char[] cls = new char[500];
    int cnt;

    void run() {
        while (sc.hasNext()) {
            int[] ls = new int[256];
            String s = sc.nextLine();
            int max = 0;
            char c;
            cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c>='A' && c<='Z' || c>='a' && c<='z') {
                    ls[c]++;
                    if (max < ls[c]) {
                        max = ls[c];
                    }
                }
            }
            for (int i = 0; i < 256; i++) {
                if (ls[i] == max) {
                    cls[cnt++] = (char) i;
                }
            }
            Arrays.sort(cls, 0, cnt);
            pw.printf("%s %d%n", new String(cls, 0, cnt), max);
        }

    }

}
