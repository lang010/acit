/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 846
 *  UVa link: http://uva.onlinejudge.org/external/8/846.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
        int cnt = in.nextInt();
        for (int i = 0; i < cnt; i++) {
            int b = in.nextInt();
            int e = in.nextInt();
            int t = 0;
            int step = 1;
            while (b < e) {
                if (e - b <= step) {
                    t++;
                    break;
                }
                if (e - b <= 2*step) {
                    t += 2;
                    break;
                }
                
                b += step;
                e -= step;
                step++;
                t += 2;
            }
            out.println(t);
            out.flush();
        }
    }

}
