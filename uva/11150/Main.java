/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11150
 *  UVa link: http://uva.onlinejudge.org/external/111/11150.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 26 17:37:47 2014
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

    int cnt(int b, int n) {
        int ans = 0;
        int e = b;
        while (n > 0) {
            ans += n;
            e += n;
            n = e/3;
            e = e%3;
        }
        if (e<b) {
            return 0;
        }
        return ans;
    }

    void run() {
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int t = 0;
            int max = 0;
            while (t<3) {
                int a = cnt(t, n);
                if (a>max) {
                    max = a;
                }
                t++;
            }
            pw.println(max);
        }

    }

}
