/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11332
 *  UVa link: http://uva.onlinejudge.org/external/113/11332.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 20 22:20:28 2014
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
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            while (n>9) {
                int s = 0;
                while (n>0) {
                    s += n%10;
                    n /= 10;
                }
                n = s;
            }
            pw.println(n);
        }

    }

}
