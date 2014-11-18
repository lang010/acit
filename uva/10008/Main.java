/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10008
 *  UVa link: http://uva.onlinejudge.org/external/100/10008.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 18 00:48:31 2014
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

    int[] ls = new int[30];
    void run() {
        int n = sc.nextInt();
        sc.nextLine();
        for (int i  = 0; i < n; i++) {
            String s = sc.nextLine().toUpperCase();
            for (int j = 0; j < s.length(); j++) {
                int id = s.charAt(j) - 'A';
                if (id >= 0 && id < 26) {
                    ls[id]++;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            int max = 0;
            int id = 0;
            for (int j = 0; j < 26; j++ ) {
                if (ls[j] > max) {
                    max = ls[j];
                    id = j;
                }
            }
            if (max > 0) {
                pw.printf("%c %d%n", (char)('A' + id), max);
                ls[id] = 0;
            }
        }

    }

}
