/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 550
 *  UVa link: http://uva.onlinejudge.org/external/5/550.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.File;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }

    void run() {
        int b = 0;
        int f2 = 0;
        int f1 = 0;
        int up = 0;
        int cnt = 0;
        int m = 0;
        while (in.hasNext()) {
            b = in.nextInt();
            m = in.nextInt();
            f1 = m;
            f2 = in.nextInt();
            cnt = 0;
            up = 0;
            while (true) {
                int t = f1 * f2 + up;
                cnt++;
                f1 = t%b;
                up = t/b;
                //out.printf("%d %d%n",t ,f1[cnt]);
                //out.flush();
                if (up == 0 && f1 == m) {
                    out.println(cnt);
                    break;
                }
            }
        }
    }

}
