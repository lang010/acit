/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10127
 *  UVa link: http://uva.onlinejudge.org/external/101/10127.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 21 20:37:17 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

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
        int cnt = 0;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int x = 1;
            cnt = 1;
            while (x%n != 0) {
                x = (x*10+1)%n;
                cnt++;
            }

            pw.println(cnt);
        }

    }

}
