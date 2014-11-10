/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10050
 *  UVa link: http://uva.onlinejudge.org/external/100/10050.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  3 23:38:14 2014
 */

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

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
        int[] ls = new int[200];
        int cnt = in.nextInt();
        while (cnt-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            for (int i = 0; i < p; i++) {
                ls[i] = in.nextInt();
            }
            int s = 0;
            for (int i = 0; i < n; i++) {
                if (i%7 == 5 || i%7 == 6) {
                    continue;
                }
                for (int j = 0; j < p; j++) {
                    if ((i+1)%ls[j] == 0) {
                        s++;
                        break;
                    }

                }
            }
            out.println(s);
        }

    }

}
