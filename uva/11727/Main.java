/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11727
 *  UVa link: http://uva.onlinejudge.org/external/117/11727.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 26 16:43:06 2014
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
        int[] ls = new int[3];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                ls[j] = sc.nextInt();
            }
            Arrays.sort(ls);
            pw.printf("Case %d: %d%n", i+1, ls[1]);
        }

    }

}
