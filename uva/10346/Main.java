/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10346
 *  UVa link: http://uva.onlinejudge.org/external/103/10346.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 21 20:09:46 2014
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
            int n = sc.nextInt();
            int k = sc.nextInt();
            int s = n;
            int r = n;
            while (r >= k) {
                s += r/k;
                r = r/k + r%k;
            }
            pw.println(s);
        }

    }

}
