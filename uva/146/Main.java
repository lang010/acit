/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 146
 *  UVa link: http://uva.onlinejudge.org/external/1/146.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 18 21:47:49 2014
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

    void run() {
        while (true) {
            String s = sc.nextLine();
            if ("#".equals(s)) {
                break;
            }
            int len = s.length();
            int id = len - 1;
            while (id>0) {
                if (s.charAt(id) > s.charAt(id-1)) {
                    break;
                }
                id--;
            }
            if (id == 0) {
                pw.println("No Successor");
                continue;
            }
            pw.printf(s.substring(0, id-1));
            char min = 'z';
            char[] ls = new char[100];
            int x = 0;
            for (int i = id; i < len; i++ ) {
                if (s.charAt(id-1) < s.charAt(i) && s.charAt(i) < min) {
                    min = s.charAt(i);
                    x = i;
                }
            }
            pw.printf("%c", min);
            int cnt = 0;
            for (int i = id-1; i < len; i++) {
                if (x!=i) {
                    ls[cnt++] = s.charAt(i);
                }
            }
            Arrays.sort(ls, 0, cnt);
            for (int i = 0; i < cnt; i++) {
                pw.printf("%c", ls[i]);
            }
            pw.println();
        }

    }

}
